package org.northwind.repository;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.OrderDetail;
import org.northwind.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;

import io.springlets.data.domain.GlobalSearch;

/**
 * = OrderDetailRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = OrderDetail.class)
public interface OrderDetailRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderDetail> findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderDetail> findByCustomerOrder(CustomerOrder customerOrder, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderDetail> findAll(GlobalSearch globalSearch, Pageable pageable);
}
