package org.northwind.web;
import java.util.Set;

import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Employee;
import org.northwind.domain.PurchaseOrder;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * = EmployeeJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Employee.class)
public abstract class EmployeeJsonMixin {

    @JsonIgnore
    private Set<CustomerOrder> customerOrders;

    @JsonIgnore
    private Set<PurchaseOrder> purchaseOrders;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrders
     */
    public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrders
     */
    public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }
}
