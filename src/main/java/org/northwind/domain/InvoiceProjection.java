package org.northwind.domain;
import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = InvoiceProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class InvoiceProjection {

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
    private Long shipCountryId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long shipRegionId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long shipCityId;

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
    private Long customerCountryId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long customerRegionId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long customerCityId;

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
    private Long shippedId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @DateTimeFormat(style = "M-")
    private Calendar invoiceDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String shipName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String shipAddress;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String shipCountryDescription;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String shipRegionDescription;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String shipCityDescription;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String shipPostalCode;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String customerCompanyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String customerCountryDescription;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String customerRegionDescription;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String customerCityDescription;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String customerPostalCode;

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
    @DateTimeFormat(style = "M-")
    private Calendar shippedDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String employeeName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String shipperCompanyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal freight;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal subtotal;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal total;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerOrderId
     * @param shipCountryId
     * @param shipRegionId
     * @param shipCityId
     * @param customerId
     * @param customerCountryId
     * @param customerRegionId
     * @param customerCityId
     * @param employeeId
     * @param shippedId
     * @param invoiceDate
     * @param shipName
     * @param shipAddress
     * @param shipCountryDescription
     * @param shipRegionDescription
     * @param shipCityDescription
     * @param shipPostalCode
     * @param customerCompanyName
     * @param customerCountryDescription
     * @param customerRegionDescription
     * @param customerCityDescription
     * @param customerPostalCode
     * @param orderDate
     * @param shippedDate
     * @param employeeName
     * @param shipperCompanyName
     * @param freight
     * @param subtotal
     * @param total
     */
    public InvoiceProjection(Long customerOrderId, Long shipCountryId, Long shipRegionId, Long shipCityId, Long customerId, Long customerCountryId, Long customerRegionId, Long customerCityId, Long employeeId, Long shippedId, Calendar invoiceDate, String shipName, String shipAddress, String shipCountryDescription, String shipRegionDescription, String shipCityDescription, String shipPostalCode, String customerCompanyName, String customerCountryDescription, String customerRegionDescription, String customerCityDescription, String customerPostalCode, Calendar orderDate, Calendar shippedDate, String employeeName, String shipperCompanyName, BigDecimal freight, BigDecimal subtotal, BigDecimal total) {
        this.customerOrderId = customerOrderId;
        this.shipCountryId = shipCountryId;
        this.shipRegionId = shipRegionId;
        this.shipCityId = shipCityId;
        this.customerId = customerId;
        this.customerCountryId = customerCountryId;
        this.customerRegionId = customerRegionId;
        this.customerCityId = customerCityId;
        this.employeeId = employeeId;
        this.shippedId = shippedId;
        this.invoiceDate = invoiceDate;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCountryDescription = shipCountryDescription;
        this.shipRegionDescription = shipRegionDescription;
        this.shipCityDescription = shipCityDescription;
        this.shipPostalCode = shipPostalCode;
        this.customerCompanyName = customerCompanyName;
        this.customerCountryDescription = customerCountryDescription;
        this.customerRegionDescription = customerRegionDescription;
        this.customerCityDescription = customerCityDescription;
        this.customerPostalCode = customerPostalCode;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.employeeName = employeeName;
        this.shipperCompanyName = shipperCompanyName;
        this.freight = freight;
        this.subtotal = subtotal;
        this.total = total;
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
    public Long getShipCountryId() {
        return this.shipCountryId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getShipRegionId() {
        return this.shipRegionId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getShipCityId() {
        return this.shipCityId;
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
    public Long getCustomerCountryId() {
        return this.customerCountryId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getCustomerRegionId() {
        return this.customerRegionId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getCustomerCityId() {
        return this.customerCityId;
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
    public Long getShippedId() {
        return this.shippedId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getInvoiceDate() {
        return this.invoiceDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getShipName() {
        return this.shipName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getShipAddress() {
        return this.shipAddress;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getShipCountryDescription() {
        return this.shipCountryDescription;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getShipRegionDescription() {
        return this.shipRegionDescription;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getShipCityDescription() {
        return this.shipCityDescription;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getShipPostalCode() {
        return this.shipPostalCode;
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
     * @return String
     */
    public String getCustomerCountryDescription() {
        return this.customerCountryDescription;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCustomerRegionDescription() {
        return this.customerRegionDescription;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCustomerCityDescription() {
        return this.customerCityDescription;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCustomerPostalCode() {
        return this.customerPostalCode;
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
     * @return Calendar
     */
    public Calendar getShippedDate() {
        return this.shippedDate;
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
    public String getShipperCompanyName() {
        return this.shipperCompanyName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getFreight() {
        return this.freight;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getSubtotal() {
        return this.subtotal;
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
