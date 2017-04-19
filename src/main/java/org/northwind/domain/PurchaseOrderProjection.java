package org.northwind.domain;
import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = PurchaseOrderProjection
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class PurchaseOrderProjection {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long purchaseOrderId;

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
    @NumberFormat
    private Long employeeId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @DateTimeFormat(style = "M-")
    private Calendar orderDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String employeeName;

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
    private BigDecimal totalCost;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param purchaseOrderId
     * @param productId
     * @param employeeId
     * @param orderDate
     * @param employeeName
     * @param quantity
     * @param totalCost
     */
    public PurchaseOrderProjection(Long purchaseOrderId, Long productId, Long employeeId, Calendar orderDate, String employeeName, Integer quantity, BigDecimal totalCost) {
        this.purchaseOrderId = purchaseOrderId;
        this.productId = productId;
        this.employeeId = employeeId;
        this.orderDate = orderDate;
        this.employeeName = employeeName;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getPurchaseOrderId() {
        return this.purchaseOrderId;
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
     * @return Long
     */
    public Long getEmployeeId() {
        return this.employeeId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getOrderDate() {
        return this.orderDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEmployeeName() {
        return this.employeeName;
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
    public BigDecimal getTotalCost() {
        return this.totalCost;
    }
}
