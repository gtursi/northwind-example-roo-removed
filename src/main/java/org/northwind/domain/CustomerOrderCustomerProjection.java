package org.northwind.domain;
import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = CustomerOrderCustomerProjection
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class CustomerOrderCustomerProjection {

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
    private String employeeName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @DateTimeFormat(style = "M-")
    private Calendar fromDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @DateTimeFormat(style = "M-")
    private Calendar thruDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String customerCompanyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal total;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param employeeId
     * @param customerId
     * @param employeeName
     * @param fromDate
     * @param thruDate
     * @param customerCompanyName
     * @param total
     */
    public CustomerOrderCustomerProjection(Long employeeId, Long customerId, String employeeName, Calendar fromDate, Calendar thruDate, String customerCompanyName, BigDecimal total) {
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.employeeName = employeeName;
        this.fromDate = fromDate;
        this.thruDate = thruDate;
        this.customerCompanyName = customerCompanyName;
        this.total = total;
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
     * @return String
     */
    public String getEmployeeName() {
        return this.employeeName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getFromDate() {
        return this.fromDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getThruDate() {
        return this.thruDate;
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
     * @return BigDecimal
     */
    public BigDecimal getTotal() {
        return this.total;
    }
}
