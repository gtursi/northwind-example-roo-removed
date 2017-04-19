package org.northwind.service.api;
import java.util.List;

import org.northwind.domain.Category;
import org.northwind.domain.Product;
import org.northwind.domain.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = ProductService
 TODO Auto-generated class documentation
 *
 */
public interface ProductService extends EntityResolver<Product, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Product
     */
    public abstract Product findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     */
    public abstract void delete(Product product);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Product> save(Iterable<Product> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Product
     */
    public abstract Product save(Product entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Product
     */
    public abstract Product findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Product> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Product> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderDetailsToAdd
     * @return Product
     */
    public abstract Product addToOrderDetails(Product product, Iterable<Long> orderDetailsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderDetailsToRemove
     * @return Product
     */
    public abstract Product removeFromOrderDetails(Product product, Iterable<Long> orderDetailsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderDetails
     * @return Product
     */
    public abstract Product setOrderDetails(Product product, Iterable<Long> orderDetails);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param purchaseOrdersToAdd
     * @return Product
     */
    public abstract Product addToPurchaseOrders(Product product, Iterable<Long> purchaseOrdersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param purchaseOrdersToRemove
     * @return Product
     */
    public abstract Product removeFromPurchaseOrders(Product product, Iterable<Long> purchaseOrdersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param purchaseOrders
     * @return Product
     */
    public abstract Product setPurchaseOrders(Product product, Iterable<Long> purchaseOrders);

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
     * @return Long
     */
    public abstract long countByCategory(Category category);

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @return Long
     */
    public abstract long countBySupplier(Supplier supplier);

    /**
     * TODO Auto-generated method documentation
     *
     * @param discontinued
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findByDiscontinuedOrderByNameAsc(Boolean discontinued, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param discontinued
     * @return Long
     */
    public abstract long countByDiscontinuedOrderByNameAsc(Boolean discontinued);
}
