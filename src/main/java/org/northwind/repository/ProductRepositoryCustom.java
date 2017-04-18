package org.northwind.repository;
import org.northwind.domain.Category;
import org.northwind.domain.Product;
import org.northwind.domain.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;

import io.springlets.data.domain.GlobalSearch;

/**
 * = ProductRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = Product.class)
public interface ProductRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findBySupplier(Supplier supplier, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findByCategory(Category category, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findAll(GlobalSearch globalSearch, Pageable pageable);
}
