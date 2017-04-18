package org.northwind.domain;
import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = ProductOrdersProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class ProductOrdersProjection {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long productId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long categoryId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long supplierId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String code;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String name;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String supplierCompanyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal unitCost;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal unitPrice;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String quantityPerUnit;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private Boolean discontinued;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long purchaseOrdersCount;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long orderDetailsCount;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productId
     * @param categoryId
     * @param supplierId
     * @param code
     * @param name
     * @param supplierCompanyName
     * @param unitCost
     * @param unitPrice
     * @param quantityPerUnit
     * @param discontinued
     * @param purchaseOrdersCount
     * @param orderDetailsCount
     */
    public ProductOrdersProjection(Long productId, Long categoryId, Long supplierId, String code, String name, String supplierCompanyName, BigDecimal unitCost, BigDecimal unitPrice, String quantityPerUnit, Boolean discontinued, Long purchaseOrdersCount, Long orderDetailsCount) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.code = code;
        this.name = name;
        this.supplierCompanyName = supplierCompanyName;
        this.unitCost = unitCost;
        this.unitPrice = unitPrice;
        this.quantityPerUnit = quantityPerUnit;
        this.discontinued = discontinued;
        this.purchaseOrdersCount = purchaseOrdersCount;
        this.orderDetailsCount = orderDetailsCount;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getProductId() {
        return this.productId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getCategoryId() {
        return this.categoryId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getSupplierId() {
        return this.supplierId;
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
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getSupplierCompanyName() {
        return this.supplierCompanyName;
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
     * @return BigDecimal
     */
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
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
     * @return Boolean
     */
    public Boolean getDiscontinued() {
        return this.discontinued;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getPurchaseOrdersCount() {
        return this.purchaseOrdersCount;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getOrderDetailsCount() {
        return this.orderDetailsCount;
    }
}
