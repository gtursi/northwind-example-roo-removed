package org.northwind.domain;
import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = OrderDetailProjection
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class OrderDetailProjection {

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
    @NumberFormat
    private Long customerOrderId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long productId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String productName;

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
    @NumberFormat
    private BigDecimal unitPrice;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal discount;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal total;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderDetailId
     * @param customerOrderId
     * @param productId
     * @param productName
     * @param quantity
     * @param unitPrice
     * @param discount
     * @param total
     */
    public OrderDetailProjection(Long orderDetailId, Long customerOrderId, Long productId, String productName, Integer quantity, BigDecimal unitPrice, BigDecimal discount, BigDecimal total) {
        this.orderDetailId = orderDetailId;
        this.customerOrderId = customerOrderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.total = total;
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
     * @return Long
     */
    public Long getProductId() {
        return this.productId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getProductName() {
        return this.productName;
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
     * @return BigDecimal
     */
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getDiscount() {
        return this.discount;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getTotal() {
        return this.total;
    }
}
