package org.northwind.service.impl;
import java.util.List;

import org.northwind.domain.CustomerOrder;
import org.northwind.domain.OrderDetail;
import org.northwind.domain.Product;
import org.northwind.repository.OrderDetailRepository;
import org.northwind.service.api.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.domain.GlobalSearch;

/**
 * = OrderDetailServiceImpl
 TODO Auto-generated class documentation
 *
 */
@Service
@Transactional(readOnly = true)
public class OrderDetailServiceImpl implements OrderDetailService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OrderDetailRepository orderDetailRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderDetailRepository
     */
    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        setOrderDetailRepository(orderDetailRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return OrderDetailRepository
     */
    public OrderDetailRepository getOrderDetailRepository() {
        return orderDetailRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetailRepository
     */
    public void setOrderDetailRepository(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetail
     */
    @Transactional
    public void delete(OrderDetail orderDetail) {
        // Clear bidirectional many-to-one child relationship with Product
        if (orderDetail.getProduct() != null) {
            orderDetail.getProduct().getOrderDetails().remove(orderDetail);
        }
        // Clear bidirectional many-to-one child relationship with CustomerOrder
        if (orderDetail.getCustomerOrder() != null) {
            orderDetail.getCustomerOrder().getOrderDetails().remove(orderDetail);
        }
        getOrderDetailRepository().delete(orderDetail);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<OrderDetail> save(Iterable<OrderDetail> entities) {
        return getOrderDetailRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<OrderDetail> toDelete = getOrderDetailRepository().findAll(ids);
        getOrderDetailRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return OrderDetail
     */
    @Transactional
    public OrderDetail save(OrderDetail entity) {
        return getOrderDetailRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return OrderDetail
     */
    public OrderDetail findOne(Long id) {
        return getOrderDetailRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return OrderDetail
     */
    public OrderDetail findOneForUpdate(Long id) {
        return getOrderDetailRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<OrderDetail> findAll(Iterable<Long> ids) {
        return getOrderDetailRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<OrderDetail> findAll() {
        return getOrderDetailRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getOrderDetailRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderDetail> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getOrderDetailRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderDetail> findByCustomerOrder(CustomerOrder customerOrder, GlobalSearch globalSearch, Pageable pageable) {
        return getOrderDetailRepository().findByCustomerOrder(customerOrder, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderDetail> findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable) {
        return getOrderDetailRepository().findByProduct(product, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @return Long
     */
    public long countByCustomerOrder(CustomerOrder customerOrder) {
        return getOrderDetailRepository().countByCustomerOrder(customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return Long
     */
    public long countByProduct(Product product) {
        return getOrderDetailRepository().countByProduct(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<OrderDetail> getEntityType() {
        return OrderDetail.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
