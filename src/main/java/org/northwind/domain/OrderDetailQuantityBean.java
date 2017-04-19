package org.northwind.domain;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = OrderDetailQuantityBean
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class OrderDetailQuantityBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Long orderDetailId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Long customerOrderId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Integer quantityToAdd;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderDetailId
     * @param customerOrderId
     * @param quantityToAdd
     */
    public OrderDetailQuantityBean(Long orderDetailId, Long customerOrderId, Integer quantityToAdd) {
        this.orderDetailId = orderDetailId;
        this.customerOrderId = customerOrderId;
        this.quantityToAdd = quantityToAdd;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getOrderDetailId() {
        return this.orderDetailId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getCustomerOrderId() {
        return this.customerOrderId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public Integer getQuantityToAdd() {
        return this.quantityToAdd;
    }
}
