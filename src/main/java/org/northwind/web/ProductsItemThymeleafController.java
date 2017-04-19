package org.northwind.web;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.northwind.domain.Product;
import org.northwind.service.api.ProductService;
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
 * = ProductsItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@Controller
@RequestMapping(value = "/products/{product}", name = "ProductsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class ProductsItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<ProductsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ProductService productService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public ProductsItemThymeleafController(ProductService productService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setProductService(productService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(ProductsItemThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ProductService
     */
    public ProductService getProductService() {
        return productService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productService
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
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
    public MethodLinkBuilderFactory<ProductsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<ProductsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    @ModelAttribute
    public Product getProduct(@PathVariable("product") Long id, Locale locale, HttpMethod method) {
        Product product = null;
        if (HttpMethod.PUT.equals(method)) {
            product = productService.findOneForUpdate(id);
        } else {
            product = productService.findOne(id);
        }
        if (product == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Product", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return product;
    }

    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        return new ModelAndView("products/show");
    }

    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        return new ModelAndView("products/showInline :: inline-content");
    }

    @InitBinder("product")
    public void initProductBinder(WebDataBinder dataBinder) {
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
    public ModelAndView editForm(@ModelAttribute Product product, Model model) {
        populateForm(model);
        model.addAttribute("product", product);
        return new ModelAndView("products/edit");
    }

    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Product product, @RequestParam("version") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("products/edit");
        }
        // Concurrency control
        Product existingProduct = getProductService().findOne(product.getId());
        if (product.getVersion() != existingProduct.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("product", product);
            model.addAttribute("concurrency", true);
            return new ModelAndView("products/edit");
        } else if (product.getVersion() != existingProduct.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("product", existingProduct);
            model.addAttribute("concurrency", false);
            return new ModelAndView("products/edit");
        } else if (product.getVersion() != existingProduct.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            product.setVersion(existingProduct.getVersion());
        }
        Product savedProduct = getProductService().save(product);
        UriComponents showURI = getItemLink().to(ProductsItemThymeleafLinkFactory.SHOW).with("product", savedProduct.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Product product) {
        getProductService().delete(product);
        return ResponseEntity.ok().build();
    }
}
