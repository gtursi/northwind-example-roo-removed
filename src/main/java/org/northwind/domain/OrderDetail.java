package org.northwind.domain;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

import io.springlets.format.EntityFormat;

/**
 * = OrderDetail
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(table = "NW_ORDER_DETAILS")
@RooEquals(isJpaEntity = true)
@Entity
@Table(name = "NW_ORDER_DETAILS")
@EntityFormat
public class OrderDetail {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @SequenceGenerator(name = "orderDetailGen", sequenceName = "NW_ORDER_DETAILS_ORDER_DETAIL_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderDetailGen")
    @Column(name = "ORDER_DETAIL_ID")
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
    @JoinColumn(name = "CUSTOMER_ORDER")
    @EntityFormat
    private CustomerOrder customerOrder;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "UNIT_PRICE")
    @NumberFormat
    private BigDecimal unitPrice;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "QUANTITY")
    @NumberFormat
    private Integer quantity;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "DISCOUNT")
    @NumberFormat
    private BigDecimal discount;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT")
    @EntityFormat
    private Product product;

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
        if (!(obj instanceof OrderDetail)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((OrderDetail) obj).getId());
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
     * @return CustomerOrder
     */
    public CustomerOrder getCustomerOrder() {
        return this.customerOrder;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     */
    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param unitPrice
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
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
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getDiscount() {
        return this.discount;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param discount
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Product
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "OrderDetail {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", unitPrice='" + unitPrice + '\'' + ", quantity='" + quantity + '\'' + ", discount='" + discount + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }
}
