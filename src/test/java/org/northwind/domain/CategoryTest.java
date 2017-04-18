package org.northwind.domain;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.northwind.domain.dod.CategoryFactory;
import org.northwind.domain.dod.ProductFactory;
import org.springframework.roo.addon.jpa.annotations.test.RooJpaUnitTest;

/**
 * = CategoryTest
 TODO Auto-generated class documentation
 *
 */
@RooJpaUnitTest(targetClass = Category.class)
public class CategoryTest {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ProductFactory productFactory = new ProductFactory();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CategoryFactory categoryFactory = new CategoryFactory();

    /**
     * TODO Auto-generated method documentation
     *
     * @return CategoryFactory
     */
    public CategoryFactory getCategoryFactory() {
        return categoryFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param categoryFactory
     */
    public void setCategoryFactory(CategoryFactory categoryFactory) {
        this.categoryFactory = categoryFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ProductFactory
     */
    public ProductFactory getProductFactory() {
        return productFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productFactory
     */
    public void setProductFactory(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    @Test
    public void addToProductsShouldAddTheProductToTheproductsRelationship() {
        // Setup
        Category category = getCategoryFactory().create(0);
        Product product1 = getProductFactory().create(0);
        Product product2 = getProductFactory().create(1);
        // Exercise
        category.addToProducts(Arrays.asList(product1, product2));
        // Verify
        assertThat(category.getProducts()).as("Check 'addToProducts' adds the products to the relationship").contains(product1).contains(product2);
        assertThat(category).as("Check 'addToProducts' updates the Product relationship side").isEqualTo(product1.getCategory()).isEqualTo(product2.getCategory());
    }

    @Test
    public void addToProductsShouldRemoveTheProductFromTheproductsRelationship() {
        // Setup
        Category category = getCategoryFactory().create(0);
        Product product1 = getProductFactory().create(0);
        Product product2 = getProductFactory().create(1);
        category.addToProducts(Arrays.asList(product1, product2));
        // Exercise
        category.removeFromProducts(Collections.singleton(product1));
        // Verify
        assertThat(product1.getCategory()).as("Check 'removeFromProducts' updates the Product relationship side").isNull();
        assertThat(category.getProducts()).as("Check 'removeFromProducts' removes a Product from the relationship").doesNotContain(product1).contains(product2);
    }
}
