package org.northwind.domain;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import org.springframework.util.Assert;

import io.springlets.format.EntityFormat;

/**
 * = CustomerOrder
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(table = "NW_CUSTOMER_ORDERS")
@RooEquals(isJpaEntity = true)
@Entity
@Table(name = "NW_CUSTOMER_ORDERS")
@EntityFormat
public class CustomerOrder {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @SequenceGenerator(name = "customerOrderGen", sequenceName = "NW_CUSTOMER_ORDERS_CUSTOMER_ORDER_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerOrderGen")
    @Column(name = "CUSTOMER_ORDER_ID")
    private Long id;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY")
    @EntityFormat
    private City city;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY")
    @EntityFormat
    private Country country;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER")
    @EntityFormat
    private Customer customer;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar orderDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "REQUIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar requiredDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "SHIPPED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar shippedDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "FREIGHT")
    @NumberFormat
    private BigDecimal freight;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "SHIP_NAME")
    private String shipName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "SHIP_ADDRESS")
    private String shipAddress;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "SHIP_POSTAL_CODE")
    private String shipPostalCode;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "SHIP_PHONE")
    private String shipPhone;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "INVOICE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar invoiceDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "CLOSE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar closeDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "customerOrder")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE")
    @EntityFormat
    private Employee employee;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION")
    @EntityFormat
    private Region region;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHIPPER")
    @EntityFormat
    private Shipper shipper;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * This `equals` implementation is specific for JPA entities and uses
     * the entity identifier for it, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // instanceof is false if the instance is null
        if (!(obj instanceof CustomerOrder)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((CustomerOrder) obj).getId());
    }

    /**
     * This `hashCode` implementation is specific for JPA entities and uses a fixed `int` value to be able
     * to identify the entity in collections after a new id is assigned to the entity, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @return Integer
     */
    public int hashCode() {
        return 31;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getVersion() {
        return this.version;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return City
     */
    public City getCity() {
        return this.city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Country
     */
    public Country getCountry() {
        return this.country;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Customer
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
     * @param orderDate
     */
    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getRequiredDate() {
        return this.requiredDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param requiredDate
     */
    public void setRequiredDate(Calendar requiredDate) {
        this.requiredDate = requiredDate;
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
     * @param shippedDate
     */
    public void setShippedDate(Calendar shippedDate) {
        this.shippedDate = shippedDate;
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
     * @param freight
     */
    public void setFreight(BigDecimal freight) {
        this.freight = freight;
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
     * @param shipName
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
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
     * @param shipAddress
     */
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
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
     * @param shipPostalCode
     */
    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
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
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getShipPhone() {
        return this.shipPhone;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipPhone
     */
    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
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
     * @param invoiceDate
     */
    public void setInvoiceDate(Calendar invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getCloseDate() {
        return this.closeDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param closeDate
     */
    public void setCloseDate(Calendar closeDate) {
        this.closeDate = closeDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetails
     */
    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Employee
     */
    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Region
     */
    public Region getRegion() {
        return this.region;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Shipper
     */
    public Shipper getShipper() {
        return this.shipper;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     */
    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "CustomerOrder {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", orderDate='" + orderDate + '\'' + ", requiredDate='" + requiredDate + '\'' + ", shippedDate='" + shippedDate + '\'' + ", freight='" + freight + '\'' + ", shipName='" + shipName + '\'' + ", shipAddress='" + shipAddress + '\'' + ", shipPostalCode='" + shipPostalCode + '\'' + ", shipPhone='" + shipPhone + '\'' + ", invoiceDate='" + invoiceDate + '\'' + ", closeDate='" + closeDate + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetailsToAdd
     */
    public void addToOrderDetails(Iterable<OrderDetail> orderDetailsToAdd) {
        Assert.notNull(orderDetailsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (OrderDetail item : orderDetailsToAdd) {
            this.orderDetails.add(item);
            item.setCustomerOrder(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetailsToRemove
     */
    public void removeFromOrderDetails(Iterable<OrderDetail> orderDetailsToRemove) {
        Assert.notNull(orderDetailsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (OrderDetail item : orderDetailsToRemove) {
            this.orderDetails.remove(item);
            item.setCustomerOrder(null);
        }
    }
}
