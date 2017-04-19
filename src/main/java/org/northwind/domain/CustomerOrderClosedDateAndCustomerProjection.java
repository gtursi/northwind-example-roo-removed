package org.northwind.domain;
import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = CustomerOrderClosedDateAndCustomerProjection
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class CustomerOrderClosedDateAndCustomerProjection {

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
    private Calendar closedDate;

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
     * @param customerId
     * @param closedDate
     * @param customerCompanyName
     * @param total
     */
    public CustomerOrderClosedDateAndCustomerProjection(Long customerId, Calendar closedDate, String customerCompanyName, BigDecimal total) {
        this.customerId = customerId;
        this.closedDate = closedDate;
        this.customerCompanyName = customerCompanyName;
        this.total = total;
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
    public Calendar getClosedDate() {
        return this.closedDate;
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
