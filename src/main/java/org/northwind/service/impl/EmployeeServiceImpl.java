package org.northwind.service.impl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Employee;
import org.northwind.domain.PurchaseOrder;
import org.northwind.repository.EmployeeRepository;
import org.northwind.service.api.CustomerOrderService;
import org.northwind.service.api.EmployeeService;
import org.northwind.service.api.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.domain.GlobalSearch;

/**
 * = EmployeeServiceImpl
 TODO Auto-generated class documentation
 *
 */
@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PurchaseOrderService purchaseOrderService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerOrderService customerOrderService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private EmployeeRepository employeeRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param employeeRepository
     * @param customerOrderService
     * @param purchaseOrderService
     */
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, @Lazy CustomerOrderService customerOrderService, @Lazy PurchaseOrderService purchaseOrderService) {
        setEmployeeRepository(employeeRepository);
        setCustomerOrderService(customerOrderService);
        setPurchaseOrderService(purchaseOrderService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return EmployeeRepository
     */
    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employeeRepository
     */
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
     * @return PurchaseOrderService
     */
    public PurchaseOrderService getPurchaseOrderService() {
        return purchaseOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrderService
     */
    public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     * @param customerOrdersToAdd
     * @return Employee
     */
    @Transactional
    public Employee addToCustomerOrders(Employee employee, Iterable<Long> customerOrdersToAdd) {
        List<CustomerOrder> customerOrders = getCustomerOrderService().findAll(customerOrdersToAdd);
        employee.addToCustomerOrders(customerOrders);
        return getEmployeeRepository().save(employee);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     * @param purchaseOrdersToAdd
     * @return Employee
     */
    @Transactional
    public Employee addToPurchaseOrders(Employee employee, Iterable<Long> purchaseOrdersToAdd) {
        List<PurchaseOrder> purchaseOrders = getPurchaseOrderService().findAll(purchaseOrdersToAdd);
        employee.addToPurchaseOrders(purchaseOrders);
        return getEmployeeRepository().save(employee);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     * @param customerOrdersToRemove
     * @return Employee
     */
    @Transactional
    public Employee removeFromCustomerOrders(Employee employee, Iterable<Long> customerOrdersToRemove) {
        List<CustomerOrder> customerOrders = getCustomerOrderService().findAll(customerOrdersToRemove);
        employee.removeFromCustomerOrders(customerOrders);
        return getEmployeeRepository().save(employee);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     * @param purchaseOrdersToRemove
     * @return Employee
     */
    @Transactional
    public Employee removeFromPurchaseOrders(Employee employee, Iterable<Long> purchaseOrdersToRemove) {
        List<PurchaseOrder> purchaseOrders = getPurchaseOrderService().findAll(purchaseOrdersToRemove);
        employee.removeFromPurchaseOrders(purchaseOrders);
        return getEmployeeRepository().save(employee);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     * @param customerOrders
     * @return Employee
     */
    @Transactional
    public Employee setCustomerOrders(Employee employee, Iterable<Long> customerOrders) {
        List<CustomerOrder> items = getCustomerOrderService().findAll(customerOrders);
        Set<CustomerOrder> currents = employee.getCustomerOrders();
        Set<CustomerOrder> toRemove = new HashSet<CustomerOrder>();
        for (Iterator<CustomerOrder> iterator = currents.iterator(); iterator.hasNext(); ) {
            CustomerOrder nextCustomerOrder = iterator.next();
            if (items.contains(nextCustomerOrder)) {
                items.remove(nextCustomerOrder);
            } else {
                toRemove.add(nextCustomerOrder);
            }
        }
        employee.removeFromCustomerOrders(toRemove);
        employee.addToCustomerOrders(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        employee.setVersion(employee.getVersion() + 1);
        return getEmployeeRepository().save(employee);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     * @param purchaseOrders
     * @return Employee
     */
    @Transactional
    public Employee setPurchaseOrders(Employee employee, Iterable<Long> purchaseOrders) {
        List<PurchaseOrder> items = getPurchaseOrderService().findAll(purchaseOrders);
        Set<PurchaseOrder> currents = employee.getPurchaseOrders();
        Set<PurchaseOrder> toRemove = new HashSet<PurchaseOrder>();
        for (Iterator<PurchaseOrder> iterator = currents.iterator(); iterator.hasNext(); ) {
            PurchaseOrder nextPurchaseOrder = iterator.next();
            if (items.contains(nextPurchaseOrder)) {
                items.remove(nextPurchaseOrder);
            } else {
                toRemove.add(nextPurchaseOrder);
            }
        }
        employee.removeFromPurchaseOrders(toRemove);
        employee.addToPurchaseOrders(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        employee.setVersion(employee.getVersion() + 1);
        return getEmployeeRepository().save(employee);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     */
    @Transactional
    public void delete(Employee employee) {
        // Clear bidirectional one-to-many parent relationship with CustomerOrder
        for (CustomerOrder item : employee.getCustomerOrders()) {
            item.setEmployee(null);
        }
        // Clear bidirectional one-to-many parent relationship with PurchaseOrder
        for (PurchaseOrder item : employee.getPurchaseOrders()) {
            item.setEmployee(null);
        }
        getEmployeeRepository().delete(employee);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Employee> save(Iterable<Employee> entities) {
        return getEmployeeRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Employee> toDelete = getEmployeeRepository().findAll(ids);
        getEmployeeRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Employee
     */
    @Transactional
    public Employee save(Employee entity) {
        return getEmployeeRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Employee
     */
    public Employee findOne(Long id) {
        return getEmployeeRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Employee
     */
    public Employee findOneForUpdate(Long id) {
        return getEmployeeRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Employee> findAll(Iterable<Long> ids) {
        return getEmployeeRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Employee> findAll() {
        return getEmployeeRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getEmployeeRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Employee> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getEmployeeRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Employee> getEntityType() {
        return Employee.class;
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
