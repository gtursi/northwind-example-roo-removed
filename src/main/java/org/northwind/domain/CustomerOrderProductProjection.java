package org.northwind.domain;
import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = CustomerOrderProductProjection
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class CustomerOrderProductProjection {

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
    @NumberFormat
    private Long employeeId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long customerId;

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
    private Status status;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String employeeName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String customerCompanyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @DateTimeFormat(style = "M-")
    private Calendar shippedDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal freight;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerOrderId
     * @param productId
     * @param employeeId
     * @param customerId
     * @param orderDate
     * @param status
     * @param employeeName
     * @param customerCompanyName
     * @param shippedDate
     * @param freight
     */
    public CustomerOrderProductProjection(Long customerOrderId, Long productId, Long employeeId, Long customerId, Calendar orderDate, Status status, String employeeName, String customerCompanyName, Calendar shippedDate, BigDecimal freight) {
        this.customerOrderId = customerOrderId;
        this.productId = productId;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
        this.employeeName = employeeName;
        this.customerCompanyName = customerCompanyName;
        this.shippedDate = shippedDate;
        this.freight = freight;
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
     * @return Long
     */
    public Long getEmployeeId() {
        return this.employeeId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getCustomerId() {
        return this.customerId;
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
     * @return Status
     */
    public Status getStatus() {
        return this.status;
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
     * @return String
     */
    public String getCustomerCompanyName() {
        return this.customerCompanyName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getShippedDate() {
        return this.shippedDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getFreight() {
        return this.freight;
    }
}
