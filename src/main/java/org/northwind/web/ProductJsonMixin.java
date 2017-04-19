package org.northwind.web;
import java.util.Set;

import org.northwind.domain.Category;
import org.northwind.domain.OrderDetail;
import org.northwind.domain.Product;
import org.northwind.domain.PurchaseOrder;
import org.northwind.domain.Supplier;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * = ProductJsonMixin
 TODO Auto-generated class documentation
 *
 */
public abstract class ProductJsonMixin {

    @JsonIgnore
    private Set<OrderDetail> orderDetails;

    @JsonDeserialize(using = SupplierDeserializer.class)
    private Supplier supplier;

    @JsonDeserialize(using = CategoryDeserializer.class)
    private Category category;

    @JsonIgnore
    private Set<PurchaseOrder> purchaseOrders;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
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
     * @return Set
     */
    public Set<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
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
     * @return Category
     */
    public Category getCategory() {
        return category;
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
     * @return Supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
