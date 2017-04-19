package org.northwind.web;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.northwind.domain.Supplier;
import org.northwind.service.api.SupplierService;
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
 * = SuppliersItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@Controller
@RequestMapping(value = "/suppliers/{supplier}", name = "SuppliersItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class SuppliersItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<SuppliersItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private SupplierService supplierService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param supplierService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public SuppliersItemThymeleafController(SupplierService supplierService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setSupplierService(supplierService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(SuppliersItemThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return SupplierService
     */
    public SupplierService getSupplierService() {
        return supplierService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplierService
     */
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
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
    public MethodLinkBuilderFactory<SuppliersItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<SuppliersItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    @ModelAttribute
    public Supplier getSupplier(@PathVariable("supplier") Long id, Locale locale, HttpMethod method) {
        Supplier supplier = null;
        if (HttpMethod.PUT.equals(method)) {
            supplier = supplierService.findOneForUpdate(id);
        } else {
            supplier = supplierService.findOne(id);
        }
        if (supplier == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Supplier", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return supplier;
    }

    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Supplier supplier, Model model) {
        model.addAttribute("supplier", supplier);
        return new ModelAndView("suppliers/show");
    }

    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Supplier supplier, Model model) {
        model.addAttribute("supplier", supplier);
        return new ModelAndView("suppliers/showInline :: inline-content");
    }

    @InitBinder("supplier")
    public void initSupplierBinder(WebDataBinder dataBinder) {
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
    public ModelAndView editForm(@ModelAttribute Supplier supplier, Model model) {
        populateForm(model);
        model.addAttribute("supplier", supplier);
        return new ModelAndView("suppliers/edit");
    }

    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Supplier supplier, @RequestParam("version") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("suppliers/edit");
        }
        // Concurrency control
        Supplier existingSupplier = getSupplierService().findOne(supplier.getId());
        if (supplier.getVersion() != existingSupplier.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("supplier", supplier);
            model.addAttribute("concurrency", true);
            return new ModelAndView("suppliers/edit");
        } else if (supplier.getVersion() != existingSupplier.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("supplier", existingSupplier);
            model.addAttribute("concurrency", false);
            return new ModelAndView("suppliers/edit");
        } else if (supplier.getVersion() != existingSupplier.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            supplier.setVersion(existingSupplier.getVersion());
        }
        Supplier savedSupplier = getSupplierService().save(supplier);
        UriComponents showURI = getItemLink().to(SuppliersItemThymeleafLinkFactory.SHOW).with("supplier", savedSupplier.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Supplier supplier) {
        getSupplierService().delete(supplier);
        return ResponseEntity.ok().build();
    }
}
