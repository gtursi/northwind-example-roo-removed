package org.northwind.service.impl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.northwind.domain.Customer;
import org.northwind.domain.CustomerOrder;
import org.northwind.repository.CustomerRepository;
import org.northwind.service.api.CustomerOrderService;
import org.northwind.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.domain.GlobalSearch;

/**
 * = CustomerServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = CustomerService.class)
@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerRepository customerRepository;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerOrderService customerOrderService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerRepository
     * @param customerOrderService
     */
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, @Lazy CustomerOrderService customerOrderService) {
        setCustomerRepository(customerRepository);
        setCustomerOrderService(customerOrderService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerRepository
     */
    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerRepository
     */
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerOrderService
     */
    public CustomerOrderService getCustomerOrderService() {
        return customerOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrderService
     */
    public void setCustomerOrderService(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param customerOrdersToAdd
     * @return Customer
     */
    @Transactional
    public Customer addToCustomerOrders(Customer customer, Iterable<Long> customerOrdersToAdd) {
        List<CustomerOrder> customerOrders = getCustomerOrderService().findAll(customerOrdersToAdd);
        customer.addToCustomerOrders(customerOrders);
        return getCustomerRepository().save(customer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param customerOrdersToRemove
     * @return Customer
     */
    @Transactional
    public Customer removeFromCustomerOrders(Customer customer, Iterable<Long> customerOrdersToRemove) {
        List<CustomerOrder> customerOrders = getCustomerOrderService().findAll(customerOrdersToRemove);
        customer.removeFromCustomerOrders(customerOrders);
        return getCustomerRepository().save(customer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param customerOrders
     * @return Customer
     */
    @Transactional
    public Customer setCustomerOrders(Customer customer, Iterable<Long> customerOrders) {
        List<CustomerOrder> items = getCustomerOrderService().findAll(customerOrders);
        Set<CustomerOrder> currents = customer.getCustomerOrders();
        Set<CustomerOrder> toRemove = new HashSet<CustomerOrder>();
        for (Iterator<CustomerOrder> iterator = currents.iterator(); iterator.hasNext(); ) {
            CustomerOrder nextCustomerOrder = iterator.next();
            if (items.contains(nextCustomerOrder)) {
                items.remove(nextCustomerOrder);
            } else {
                toRemove.add(nextCustomerOrder);
            }
        }
        customer.removeFromCustomerOrders(toRemove);
        customer.addToCustomerOrders(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        customer.setVersion(customer.getVersion() + 1);
        return getCustomerRepository().save(customer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     */
    @Transactional
    public void delete(Customer customer) {
        // Clear bidirectional one-to-many parent relationship with CustomerOrder
        for (CustomerOrder item : customer.getCustomerOrders()) {
            item.setCustomer(null);
        }
        getCustomerRepository().delete(customer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Customer> save(Iterable<Customer> entities) {
        return getCustomerRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Customer> toDelete = getCustomerRepository().findAll(ids);
        getCustomerRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Customer
     */
    @Transactional
    public Customer save(Customer entity) {
        return getCustomerRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Customer
     */
    public Customer findOne(Long id) {
        return getCustomerRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Customer
     */
    public Customer findOneForUpdate(Long id) {
        return getCustomerRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Customer> findAll(Iterable<Long> ids) {
        return getCustomerRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Customer> findAll() {
        return getCustomerRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getCustomerRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Customer> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getCustomerRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Customer> getEntityType() {
        return Customer.class;
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
