package org.northwind.domain;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = CustomerOrderStatusAndEmployeeProjection
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class CustomerOrderStatusAndEmployeeProjection {

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
    private Long customerId;

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
    private Status status;

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
    private String customerCompanyName;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderId
     * @param customerId
     * @param employeeId
     * @param status
     * @param orderDate
     * @param customerCompanyName
     */
    public CustomerOrderStatusAndEmployeeProjection(Long orderId, Long customerId, Long employeeId, Status status, Calendar orderDate, String customerCompanyName) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.status = status;
        this.orderDate = orderDate;
        this.customerCompanyName = customerCompanyName;
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
    public Long getCustomerId() {
        return this.customerId;
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
    public Calendar getOrderDate() {
        return this.orderDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCustomerCompanyName() {
        return this.customerCompanyName;
    }
}
