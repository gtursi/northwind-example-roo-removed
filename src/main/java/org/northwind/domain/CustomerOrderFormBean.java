package org.northwind.domain;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = CustomerOrderFormBean
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class CustomerOrderFormBean {

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
    @DateTimeFormat(style = "M-")
    private Calendar orderDateStart;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @DateTimeFormat(style = "M-")
    private Calendar orderDateEnd;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerId
     * @param employeeId
     * @param orderDateStart
     * @param orderDateEnd
     */
    public CustomerOrderFormBean(Long customerId, Long employeeId, Calendar orderDateStart, Calendar orderDateEnd) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.orderDateStart = orderDateStart;
        this.orderDateEnd = orderDateEnd;
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
     * @return Calendar
     */
    public Calendar getOrderDateStart() {
        return this.orderDateStart;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getOrderDateEnd() {
        return this.orderDateEnd;
    }
}
