package org.northwind.domain;
import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = CustomerOrderProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class CustomerOrderProjection {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long orderId;

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
    private Status status;

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
     * @param orderId
     * @param employeeId
     * @param customerId
     * @param orderDate
     * @param employeeName
     * @param customerCompanyName
     * @param status
     * @param shippedDate
     * @param freight
     */
    public CustomerOrderProjection(Long orderId, Long employeeId, Long customerId, Calendar orderDate, String employeeName, String customerCompanyName, Status status, Calendar shippedDate, BigDecimal freight) {
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.employeeName = employeeName;
        this.customerCompanyName = customerCompanyName;
        this.status = status;
        this.shippedDate = shippedDate;
        this.freight = freight;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getOrderId() {
        return this.orderId;
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
     * @return Status
     */
    public Status getStatus() {
        return this.status;
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
