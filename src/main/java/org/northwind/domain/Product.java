package org.northwind.domain;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

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
 * = Product
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(table = "NW_PRODUCTS")
@RooEquals(isJpaEntity = true)
@Entity
@Table(name = "NW_PRODUCTS")
@EntityFormat
public class Product {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @SequenceGenerator(name = "productGen", sequenceName = "NW_PRODUCTS_PRODUCT_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productGen")
    @Column(name = "PRODUCT_ID")
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
    @JoinColumn(name = "CATEGORY")
    @EntityFormat
    private Category category;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "NAME")
    private String name;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "CODE")
    private String code;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "QUANTITY_PER_UNIT")
    private String quantityPerUnit;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "UNIT_COST")
    @NumberFormat
    private BigDecimal unitCost;

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
    @Column(name = "UNITS_IN_STOCK")
    @NumberFormat
    private Integer unitsInStock;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "REORDER_LEVEL")
    @NumberFormat
    private Integer reorderLevel;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "DISCONTINUED")
    private Boolean discontinued;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "product")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<PurchaseOrder> purchaseOrders = new HashSet<PurchaseOrder>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "product")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPPLIER")
    @EntityFormat
    private Supplier supplier;

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
        if (!(obj instanceof Product)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Product) obj).getId());
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
     * @return Category
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCode() {
        return this.code;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getQuantityPerUnit() {
        return this.quantityPerUnit;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param quantityPerUnit
     */
    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return BigDecimal
     */
    public BigDecimal getUnitCost() {
        return this.unitCost;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param unitCost
     */
    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
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
    public Integer getUnitsInStock() {
        return this.unitsInStock;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param unitsInStock
     */
    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public Integer getReorderLevel() {
        return this.reorderLevel;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reorderLevel
     */
    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Boolean
     */
    public Boolean getDiscontinued() {
        return this.discontinued;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param discontinued
     */
    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<PurchaseOrder> getPurchaseOrders() {
        return this.purchaseOrders;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrders
     */
    public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
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
     * @return Supplier
     */
    public Supplier getSupplier() {
        return this.supplier;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "Product {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", code='" + code + '\'' + ", quantityPerUnit='" + quantityPerUnit + '\'' + ", unitCost='" + unitCost + '\'' + ", unitPrice='" + unitPrice + '\'' + ", unitsInStock='" + unitsInStock + '\'' + ", reorderLevel='" + reorderLevel + '\'' + ", discontinued='" + discontinued + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrdersToAdd
     */
    public void addToPurchaseOrders(Iterable<PurchaseOrder> purchaseOrdersToAdd) {
        Assert.notNull(purchaseOrdersToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (PurchaseOrder item : purchaseOrdersToAdd) {
            this.purchaseOrders.add(item);
            item.setProduct(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrdersToRemove
     */
    public void removeFromPurchaseOrders(Iterable<PurchaseOrder> purchaseOrdersToRemove) {
        Assert.notNull(purchaseOrdersToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (PurchaseOrder item : purchaseOrdersToRemove) {
            this.purchaseOrders.remove(item);
            item.setProduct(null);
        }
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
            item.setProduct(this);
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
            item.setProduct(null);
        }
    }
}
