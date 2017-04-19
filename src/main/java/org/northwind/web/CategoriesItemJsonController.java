package org.northwind.web;
import javax.validation.Valid;

import org.northwind.domain.Category;
import org.northwind.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import io.springlets.web.NotFoundException;

/**
 * = CategoriesItemJsonController
 TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/api/categories/{category}", name = "CategoriesItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriesItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CategoryService categoryService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param categoryService
     */
    @Autowired
    public CategoriesItemJsonController(CategoryService categoryService) {
        this.categoryService = categoryService;
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

    @ModelAttribute
    public Category getCategory(@PathVariable("category") Long id) {
        Category category = categoryService.findOne(id);
        if (category == null) {
            throw new NotFoundException(String.format("Category with identifier '%s' not found", id));
        }
        return category;
    }

    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Category category) {
        return ResponseEntity.ok(category);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @return UriComponents
     */
    public static UriComponents showURI(Category category) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(CategoriesItemJsonController.class).show(category)).buildAndExpand(category.getId()).encode();
    }

    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Category storedCategory, @Valid @RequestBody Category category, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        category.setId(storedCategory.getId());
        getCategoryService().save(category);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Category category) {
        getCategoryService().delete(category);
        return ResponseEntity.ok().build();
    }
}
