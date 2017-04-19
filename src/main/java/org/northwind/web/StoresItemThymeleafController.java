package org.northwind.web;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.northwind.domain.Store;
import org.northwind.service.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;

/**
 * = StoresItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@Controller
@RequestMapping(value = "/stores/{store}", name = "StoresItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class StoresItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private StoreService storeService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<StoresItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param storeService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public StoresItemThymeleafController(StoreService storeService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setStoreService(storeService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(StoresItemThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return StoreService
     */
    public StoreService getStoreService() {
        return storeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storeService
     */
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MessageSource
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param messageSource
     */
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<StoresItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<StoresItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    @ModelAttribute
    public Store getStore(@PathVariable("store") Long id, Locale locale, HttpMethod method) {
        Store store = null;
        if (HttpMethod.PUT.equals(method)) {
            store = storeService.findOneForUpdate(id);
        } else {
            store = storeService.findOne(id);
        }
        if (store == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Store", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return store;
    }

    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Store store, Model model) {
        model.addAttribute("store", store);
        return new ModelAndView("stores/show");
    }

    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Store store, Model model) {
        model.addAttribute("store", store);
        return new ModelAndView("stores/showInline :: inline-content");
    }

    @InitBinder("store")
    public void initStoreBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateForm(Model model) {
        populateFormats(model);
    }

    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Store store, Model model) {
        populateForm(model);
        model.addAttribute("store", store);
        return new ModelAndView("stores/edit");
    }

    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Store store, @RequestParam("version") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("stores/edit");
        }
        // Concurrency control
        Store existingStore = getStoreService().findOne(store.getId());
        if (store.getVersion() != existingStore.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("store", store);
            model.addAttribute("concurrency", true);
            return new ModelAndView("stores/edit");
        } else if (store.getVersion() != existingStore.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("store", existingStore);
            model.addAttribute("concurrency", false);
            return new ModelAndView("stores/edit");
        } else if (store.getVersion() != existingStore.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            store.setVersion(existingStore.getVersion());
        }
        Store savedStore = getStoreService().save(store);
        UriComponents showURI = getItemLink().to(StoresItemThymeleafLinkFactory.SHOW).with("store", savedStore.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Store store) {
        getStoreService().delete(store);
        return ResponseEntity.ok().build();
    }
}
