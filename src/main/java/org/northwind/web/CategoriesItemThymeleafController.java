package org.northwind.web;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.northwind.domain.Category;
import org.northwind.service.api.CategoryService;
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
 * = CategoriesItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Category.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/categories/{category}", name = "CategoriesItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CategoriesItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<CategoriesItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CategoryService categoryService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param categoryService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public CategoriesItemThymeleafController(CategoryService categoryService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setCategoryService(categoryService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(CategoriesItemThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CategoryService
     */
    public CategoryService getCategoryService() {
        return categoryService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param categoryService
     */
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
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
    public MethodLinkBuilderFactory<CategoriesItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<CategoriesItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    @ModelAttribute
    public Category getCategory(@PathVariable("category") Long id, Locale locale, HttpMethod method) {
        Category category = null;
        if (HttpMethod.PUT.equals(method)) {
            category = categoryService.findOneForUpdate(id);
        } else {
            category = categoryService.findOne(id);
        }
        if (category == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Category", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return category;
    }

    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Category category, Model model) {
        model.addAttribute("category", category);
        return new ModelAndView("categories/show");
    }

    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Category category, Model model) {
        model.addAttribute("category", category);
        return new ModelAndView("categories/showInline :: inline-content");
    }

    @InitBinder("category")
    public void initCategoryBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("createdDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        model.addAttribute("modifiedDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
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
    public ModelAndView editForm(@ModelAttribute Category category, Model model) {
        populateForm(model);
        model.addAttribute("category", category);
        return new ModelAndView("categories/edit");
    }

    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Category category, @RequestParam("version") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("categories/edit");
        }
        // Concurrency control
        Category existingCategory = getCategoryService().findOne(category.getId());
        if (category.getVersion() != existingCategory.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("category", category);
            model.addAttribute("concurrency", true);
            return new ModelAndView("categories/edit");
        } else if (category.getVersion() != existingCategory.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("category", existingCategory);
            model.addAttribute("concurrency", false);
            return new ModelAndView("categories/edit");
        } else if (category.getVersion() != existingCategory.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            category.setVersion(existingCategory.getVersion());
        }
        Category savedCategory = getCategoryService().save(category);
        UriComponents showURI = getItemLink().to(CategoriesItemThymeleafLinkFactory.SHOW).with("category", savedCategory.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Category category) {
        getCategoryService().delete(category);
        return ResponseEntity.ok().build();
    }
}
