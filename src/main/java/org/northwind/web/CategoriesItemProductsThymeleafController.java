package org.northwind.web;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.northwind.domain.Category;
import org.northwind.domain.Product;
import org.northwind.service.api.CategoryService;
import org.northwind.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.ConvertedDatatablesData;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesColumns;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;

/**
 * = CategoriesItemProductsThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Category.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "products")
@RooThymeleaf
@Controller
@RequestMapping(value = "/categories/{category}/products", name = "CategoriesItemProductsThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CategoriesItemProductsThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<CategoriesCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CategoryService categoryService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ProductService productService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param categoryService
     * @param productService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public CategoriesItemProductsThymeleafController(CategoryService categoryService, ProductService productService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setCategoryService(categoryService);
        setProductService(productService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(CategoriesCollectionThymeleafController.class));
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
    public MethodLinkBuilderFactory<CategoriesCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<CategoriesCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Category
     */
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

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Product>> datatables(@ModelAttribute Category category, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Product> products = getProductService().findByCategory(category, search, pageable);
        long totalProductsCount = getProductService().countByCategory(category);
        ConvertedDatatablesData<Product> data = new ConvertedDatatablesData<Product>(products, totalProductsCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Category category, Model model) {
        populateForm(model);
        model.addAttribute("product", new Product());
        return new ModelAndView("categories/products/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param productsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromProducts", value = "/{productsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromProducts(@ModelAttribute Category category, @PathVariable("productsToRemove") Long productsToRemove) {
        getCategoryService().removeFromProducts(category, Collections.singleton(productsToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param productsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromProductsBatch", value = "/batch/{productsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromProductsBatch(@ModelAttribute Category category, @PathVariable("productsToRemove") Collection<Long> productsToRemove) {
        getCategoryService().removeFromProducts(category, productsToRemove);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param products
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute Category category, @RequestParam(value = "productsIds", required = false) List<Long> products, @RequestParam("parentVersion") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (products != null) {
            for (Iterator<Long> iterator = products.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if (version != category.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            // Obtain the selected books and include them in the author that will be
            // included in the view
            if (products != null) {
                category.setProducts(new HashSet<Product>(getProductService().findAll(products)));
            } else {
                category.setProducts(new HashSet<Product>());
            }
            // Reset the version to prevent update
            category.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("category", category);
            model.addAttribute("concurrency", true);
            return new ModelAndView("categories/products/create");
        } else if (version != category.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("category", category);
            model.addAttribute("concurrency", false);
            return new ModelAndView("categories/products/create");
        }
        getCategoryService().setProducts(category, products);
        return new ModelAndView("redirect:" + getCollectionLink().to(CategoriesCollectionThymeleafLinkFactory.LIST).toUriString());
    }
}
