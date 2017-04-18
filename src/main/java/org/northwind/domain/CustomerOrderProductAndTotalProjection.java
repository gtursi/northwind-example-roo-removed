package org.northwind.domain;
import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = CustomerOrderProductAndTotalProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class CustomerOrderProductAndTotalProjection {

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
    private String productName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer quantity;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal total;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productId
     * @param productName
     * @param quantity
     * @param total
     */
    public CustomerOrderProductAndTotalProjection(Long productId, String productName, Integer quantity, BigDecimal total) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.total = total;
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
     * @return String
     */
    public String getProductName() {
        return this.productName;
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
     * @return BigDecimal
     */
    public BigDecimal getTotal() {
        return this.total;
    }
}
