package org.northwind.domain;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = CustomerOrderStatusProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class CustomerOrderStatusProjection {

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
     * @param status
     * @param orderDate
     * @param customerCompanyName
     */
    public CustomerOrderStatusProjection(Long orderId, Status status, Calendar orderDate, String customerCompanyName) {
        this.orderId = orderId;
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
