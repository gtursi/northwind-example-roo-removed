package org.northwind.repository;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.OrderDetail;
import org.northwind.domain.Product;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = OrderDetailRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = OrderDetail.class)
@Transactional(readOnly = true)
public interface OrderDetailRepository extends DetachableJpaRepository<OrderDetail, Long>, OrderDetailRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return Long
     */
    public abstract long countByProduct(Product product);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @return Long
     */
    public abstract long countByCustomerOrder(CustomerOrder customerOrder);
}
