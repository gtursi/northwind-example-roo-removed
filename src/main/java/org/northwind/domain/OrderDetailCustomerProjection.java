package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = OrderDetailCustomerProjection
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class OrderDetailCustomerProjection {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long orderDetailId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String customerName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private Status status;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer quantity;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String productName;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderDetailId
     * @param customerName
     * @param status
     * @param quantity
     * @param productName
     */
    public OrderDetailCustomerProjection(Long orderDetailId, String customerName, Status status, Integer quantity, String productName) {
        this.orderDetailId = orderDetailId;
        this.customerName = customerName;
        this.status = status;
        this.quantity = quantity;
        this.productName = productName;
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
     * @return String
     */
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Status
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public Integer getQuantity() {
        return this.quantity;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getProductName() {
        return this.productName;
    }
}
