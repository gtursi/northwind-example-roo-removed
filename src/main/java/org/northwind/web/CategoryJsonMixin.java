package org.northwind.web;
import java.util.Set;

import org.northwind.domain.Category;
import org.northwind.domain.Product;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * = CategoryJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Category.class)
public abstract class CategoryJsonMixin {

    @JsonIgnore
    private Set<Product> products;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param products
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
