package org.northwind.web;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.northwind.domain.SoldProduct;
import org.northwind.service.api.SoldProductService;
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
 * = SoldProductsItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@Controller
@RequestMapping(value = "/soldproducts/{soldProduct}", name = "SoldProductsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class SoldProductsItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private SoldProductService soldProductService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<SoldProductsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param soldProductService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public SoldProductsItemThymeleafController(SoldProductService soldProductService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setSoldProductService(soldProductService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(SoldProductsItemThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return SoldProductService
     */
    public SoldProductService getSoldProductService() {
        return soldProductService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProductService
     */
    public void setSoldProductService(SoldProductService soldProductService) {
        this.soldProductService = soldProductService;
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
    public MethodLinkBuilderFactory<SoldProductsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<SoldProductsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    @ModelAttribute
    public SoldProduct getSoldProduct(@PathVariable("soldProduct") Long id, Locale locale, HttpMethod method) {
        SoldProduct soldProduct = null;
        if (HttpMethod.PUT.equals(method)) {
            soldProduct = soldProductService.findOneForUpdate(id);
        } else {
            soldProduct = soldProductService.findOne(id);
        }
        if (soldProduct == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "SoldProduct", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return soldProduct;
    }

    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute SoldProduct soldProduct, Model model) {
        model.addAttribute("soldProduct", soldProduct);
        return new ModelAndView("soldproducts/show");
    }

    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute SoldProduct soldProduct, Model model) {
        model.addAttribute("soldProduct", soldProduct);
        return new ModelAndView("soldproducts/showInline :: inline-content");
    }

    @InitBinder("soldProduct")
    public void initSoldProductBinder(WebDataBinder dataBinder) {
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
    public ModelAndView editForm(@ModelAttribute SoldProduct soldProduct, Model model) {
        populateForm(model);
        model.addAttribute("soldProduct", soldProduct);
        return new ModelAndView("soldproducts/edit");
    }

    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute SoldProduct soldProduct, @RequestParam("version") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("soldproducts/edit");
        }
        // Concurrency control
        SoldProduct existingSoldProduct = getSoldProductService().findOne(soldProduct.getId());
        if (soldProduct.getVersion() != existingSoldProduct.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("soldProduct", soldProduct);
            model.addAttribute("concurrency", true);
            return new ModelAndView("soldproducts/edit");
        } else if (soldProduct.getVersion() != existingSoldProduct.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("soldProduct", existingSoldProduct);
            model.addAttribute("concurrency", false);
            return new ModelAndView("soldproducts/edit");
        } else if (soldProduct.getVersion() != existingSoldProduct.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            soldProduct.setVersion(existingSoldProduct.getVersion());
        }
        SoldProduct savedSoldProduct = getSoldProductService().save(soldProduct);
        UriComponents showURI = getItemLink().to(SoldProductsItemThymeleafLinkFactory.SHOW).with("soldProduct", savedSoldProduct.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute SoldProduct soldProduct) {
        getSoldProductService().delete(soldProduct);
        return ResponseEntity.ok().build();
    }
}
