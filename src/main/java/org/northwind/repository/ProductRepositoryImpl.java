package org.northwind.repository;
import org.northwind.domain.Category;
import org.northwind.domain.Product;
import org.northwind.domain.QProduct;
import org.northwind.domain.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;

/**
 * = ProductRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = ProductRepositoryCustom.class)
@Transactional(readOnly = true)
public class ProductRepositoryImpl extends QueryDslRepositorySupportExt<Product> implements ProductRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    ProductRepositoryImpl() {
        super(Product.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CODE = "code";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String UNIT_COST = "unitCost";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String UNITS_IN_STOCK = "unitsInStock";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CATEGORY = "category";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String UNIT_PRICE = "unitPrice";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String QUANTITY_PER_UNIT = "quantityPerUnit";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REORDER_LEVEL = "reorderLevel";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DISCONTINUED = "discontinued";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SUPPLIER = "supplier";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String NAME = "name";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Product> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QProduct product = QProduct.product;
        JPQLQuery<Product> query = from(product);
        Path<?>[] paths = new Path<?>[] { product.category, product.name, product.code, product.quantityPerUnit, product.unitCost, product.unitPrice, product.unitsInStock, product.reorderLevel, product.discontinued, product.supplier };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CATEGORY, product.category).map(NAME, product.name).map(CODE, product.code).map(QUANTITY_PER_UNIT, product.quantityPerUnit).map(UNIT_COST, product.unitCost).map(UNIT_PRICE, product.unitPrice).map(UNITS_IN_STOCK, product.unitsInStock).map(REORDER_LEVEL, product.reorderLevel).map(DISCONTINUED, product.discontinued).map(SUPPLIER, product.supplier);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Product> findByCategory(Category category, GlobalSearch globalSearch, Pageable pageable) {
        QProduct product = QProduct.product;
        JPQLQuery<Product> query = from(product);
        Assert.notNull(category, "category is required");
        query.where(product.category.eq(category));
        Path<?>[] paths = new Path<?>[] { product.category, product.name, product.code, product.quantityPerUnit, product.unitCost, product.unitPrice, product.unitsInStock, product.reorderLevel, product.discontinued, product.supplier };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CATEGORY, product.category).map(NAME, product.name).map(CODE, product.code).map(QUANTITY_PER_UNIT, product.quantityPerUnit).map(UNIT_COST, product.unitCost).map(UNIT_PRICE, product.unitPrice).map(UNITS_IN_STOCK, product.unitsInStock).map(REORDER_LEVEL, product.reorderLevel).map(DISCONTINUED, product.discontinued).map(SUPPLIER, product.supplier);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Product> findBySupplier(Supplier supplier, GlobalSearch globalSearch, Pageable pageable) {
        QProduct product = QProduct.product;
        JPQLQuery<Product> query = from(product);
        Assert.notNull(supplier, "supplier is required");
        query.where(product.supplier.eq(supplier));
        Path<?>[] paths = new Path<?>[] { product.category, product.name, product.code, product.quantityPerUnit, product.unitCost, product.unitPrice, product.unitsInStock, product.reorderLevel, product.discontinued, product.supplier };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CATEGORY, product.category).map(NAME, product.name).map(CODE, product.code).map(QUANTITY_PER_UNIT, product.quantityPerUnit).map(UNIT_COST, product.unitCost).map(UNIT_PRICE, product.unitPrice).map(UNITS_IN_STOCK, product.unitsInStock).map(REORDER_LEVEL, product.reorderLevel).map(DISCONTINUED, product.discontinued).map(SUPPLIER, product.supplier);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, product);
    }
}
