package org.northwind.service.api;
import java.util.List;

import org.northwind.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import org.springframework.roo.addon.security.annotations.RooSecurityAuthorization;
import org.springframework.roo.addon.security.annotations.RooSecurityAuthorizations;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = CustomerService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Customer.class)
@RooSecurityAuthorizations(authorizations = { @RooSecurityAuthorization(method = "delete", parameters = { Customer.class }, roles = "ADMIN,EMPLEADO"), @RooSecurityAuthorization(method = "delete", parameters = { Iterable.class }, roles = "ADMIN,EMPLEADO") })
public interface CustomerService extends EntityResolver<Customer, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Customer
     */
    public abstract Customer findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     */
    public abstract void delete(Customer customer);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Customer> save(Iterable<Customer> entities);

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
     * @return Customer
     */
    public abstract Customer save(Customer entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Customer
     */
    public abstract Customer findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Customer> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Customer> findAll();

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
    public abstract Page<Customer> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param customerOrdersToAdd
     * @return Customer
     */
    public abstract Customer addToCustomerOrders(Customer customer, Iterable<Long> customerOrdersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param customerOrdersToRemove
     * @return Customer
     */
    public abstract Customer removeFromCustomerOrders(Customer customer, Iterable<Long> customerOrdersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param customerOrders
     * @return Customer
     */
    public abstract Customer setCustomerOrders(Customer customer, Iterable<Long> customerOrders);
}
