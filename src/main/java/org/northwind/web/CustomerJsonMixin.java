package org.northwind.web;
import java.util.Set;

import org.northwind.domain.Customer;
import org.northwind.domain.CustomerOrder;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * = CustomerJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Customer.class)
public abstract class CustomerJsonMixin {

    @JsonIgnore
    private Set<CustomerOrder> customerOrders;

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
}
