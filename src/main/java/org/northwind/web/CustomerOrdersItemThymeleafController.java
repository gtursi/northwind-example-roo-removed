package org.northwind.web;
import java.util.Arrays;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Status;
import org.northwind.service.api.CustomerOrderService;
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
 * = CustomerOrdersItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@Controller
@RequestMapping(value = "/customerorders/{customerOrder}", name = "CustomerOrdersItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CustomerOrdersItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerOrderService customerOrderService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<CustomerOrdersItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerOrderService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public CustomerOrdersItemThymeleafController(CustomerOrderService customerOrderService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setCustomerOrderService(customerOrderService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(CustomerOrdersItemThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerOrderService
     */
    public CustomerOrderService getCustomerOrderService() {
        return customerOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrderService
     */
    public void setCustomerOrderService(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
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
    public MethodLinkBuilderFactory<CustomerOrdersItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<CustomerOrdersItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    @ModelAttribute
    public CustomerOrder getCustomerOrder(@PathVariable("customerOrder") Long id, Locale locale, HttpMethod method) {
        CustomerOrder customerOrder = null;
        if (HttpMethod.PUT.equals(method)) {
            customerOrder = customerOrderService.findOneForUpdate(id);
        } else {
            customerOrder = customerOrderService.findOne(id);
        }
        if (customerOrder == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "CustomerOrder", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return customerOrder;
    }

    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute CustomerOrder customerOrder, Model model) {
        model.addAttribute("customerOrder", customerOrder);
        return new ModelAndView("customerorders/show");
    }

    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute CustomerOrder customerOrder, Model model) {
        model.addAttribute("customerOrder", customerOrder);
        return new ModelAndView("customerorders/showInline :: inline-content");
    }

    @InitBinder("customerOrder")
    public void initCustomerOrderBinder(WebDataBinder dataBinder) {
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
        model.addAttribute("requiredDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        model.addAttribute("shippedDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        model.addAttribute("invoiceDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        model.addAttribute("closeDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateForm(Model model) {
        populateFormats(model);
        model.addAttribute("status", Arrays.asList(Status.values()));
    }

    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute CustomerOrder customerOrder, Model model) {
        populateForm(model);
        model.addAttribute("customerOrder", customerOrder);
        return new ModelAndView("customerorders/edit");
    }

    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute CustomerOrder customerOrder, @RequestParam("version") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("customerorders/edit");
        }
        // Concurrency control
        CustomerOrder existingCustomerOrder = getCustomerOrderService().findOne(customerOrder.getId());
        if (customerOrder.getVersion() != existingCustomerOrder.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("customerOrder", customerOrder);
            model.addAttribute("concurrency", true);
            return new ModelAndView("customerorders/edit");
        } else if (customerOrder.getVersion() != existingCustomerOrder.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("customerOrder", existingCustomerOrder);
            model.addAttribute("concurrency", false);
            return new ModelAndView("customerorders/edit");
        } else if (customerOrder.getVersion() != existingCustomerOrder.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            customerOrder.setVersion(existingCustomerOrder.getVersion());
        }
        CustomerOrder savedCustomerOrder = getCustomerOrderService().save(customerOrder);
        UriComponents showURI = getItemLink().to(CustomerOrdersItemThymeleafLinkFactory.SHOW).with("customerOrder", savedCustomerOrder.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute CustomerOrder customerOrder) {
        getCustomerOrderService().delete(customerOrder);
        return ResponseEntity.ok().build();
    }
}
