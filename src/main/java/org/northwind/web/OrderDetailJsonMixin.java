package org.northwind.web;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.OrderDetail;
import org.northwind.domain.Product;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * = OrderDetailJsonMixin
 TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = OrderDetail.class)
public abstract class OrderDetailJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = ProductDeserializer.class)
    private Product product;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = CustomerOrderDeserializer.class)
    private CustomerOrder customerOrder;

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerOrder
     */
    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     */
    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}
