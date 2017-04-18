package org.northwind.web;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.northwind.domain.PurchaseOrder;
import org.northwind.service.api.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
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
 * = PurchaseOrdersItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = PurchaseOrder.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/purchaseorders/{purchaseOrder}", name = "PurchaseOrdersItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class PurchaseOrdersItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PurchaseOrderService purchaseOrderService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<PurchaseOrdersItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param purchaseOrderService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public PurchaseOrdersItemThymeleafController(PurchaseOrderService purchaseOrderService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setPurchaseOrderService(purchaseOrderService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(PurchaseOrdersItemThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PurchaseOrderService
     */
    public PurchaseOrderService getPurchaseOrderService() {
        return purchaseOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrderService
     */
    public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
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
    public MethodLinkBuilderFactory<PurchaseOrdersItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<PurchaseOrdersItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    @ModelAttribute
    public PurchaseOrder getPurchaseOrder(@PathVariable("purchaseOrder") Long id, Locale locale, HttpMethod method) {
        PurchaseOrder purchaseOrder = null;
        if (HttpMethod.PUT.equals(method)) {
            purchaseOrder = purchaseOrderService.findOneForUpdate(id);
        } else {
            purchaseOrder = purchaseOrderService.findOne(id);
        }
        if (purchaseOrder == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "PurchaseOrder", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return purchaseOrder;
    }

    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {
        model.addAttribute("purchaseOrder", purchaseOrder);
        return new ModelAndView("purchaseorders/show");
    }

    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {
        model.addAttribute("purchaseOrder", purchaseOrder);
        return new ModelAndView("purchaseorders/showInline :: inline-content");
    }

    @InitBinder("purchaseOrder")
    public void initPurchaseOrderBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("orderDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
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
    public ModelAndView editForm(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {
        populateForm(model);
        model.addAttribute("purchaseOrder", purchaseOrder);
        return new ModelAndView("purchaseorders/edit");
    }

    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute PurchaseOrder purchaseOrder, @RequestParam("version") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("purchaseorders/edit");
        }
        // Concurrency control
        PurchaseOrder existingPurchaseOrder = getPurchaseOrderService().findOne(purchaseOrder.getId());
        if (purchaseOrder.getVersion() != existingPurchaseOrder.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("purchaseOrder", purchaseOrder);
            model.addAttribute("concurrency", true);
            return new ModelAndView("purchaseorders/edit");
        } else if (purchaseOrder.getVersion() != existingPurchaseOrder.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("purchaseOrder", existingPurchaseOrder);
            model.addAttribute("concurrency", false);
            return new ModelAndView("purchaseorders/edit");
        } else if (purchaseOrder.getVersion() != existingPurchaseOrder.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            purchaseOrder.setVersion(existingPurchaseOrder.getVersion());
        }
        PurchaseOrder savedPurchaseOrder = getPurchaseOrderService().save(purchaseOrder);
        UriComponents showURI = getItemLink().to(PurchaseOrdersItemThymeleafLinkFactory.SHOW).with("purchaseOrder", savedPurchaseOrder.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute PurchaseOrder purchaseOrder) {
        getPurchaseOrderService().delete(purchaseOrder);
        return ResponseEntity.ok().build();
    }
}
