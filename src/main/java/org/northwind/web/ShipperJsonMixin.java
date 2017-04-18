package org.northwind.web;
import java.util.Set;

import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Shipper;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * = ShipperJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Shipper.class)
public abstract class ShipperJsonMixin {

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
