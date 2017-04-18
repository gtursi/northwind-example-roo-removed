package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = InventoryProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class InventoryProjection {

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
    private String name;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer unitsInStock;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer assignedStock;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer availableStock;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer reorderLevel;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer replenishStock;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productId
     * @param name
     * @param unitsInStock
     * @param assignedStock
     * @param availableStock
     * @param reorderLevel
     * @param replenishStock
     */
    public InventoryProjection(Long productId, String name, Integer unitsInStock, Integer assignedStock, Integer availableStock, Integer reorderLevel, Integer replenishStock) {
        this.productId = productId;
        this.name = name;
        this.unitsInStock = unitsInStock;
        this.assignedStock = assignedStock;
        this.availableStock = availableStock;
        this.reorderLevel = reorderLevel;
        this.replenishStock = replenishStock;
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
    public String getName() {
        return this.name;
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
     * @return Integer
     */
    public Integer getAssignedStock() {
        return this.assignedStock;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public Integer getAvailableStock() {
        return this.availableStock;
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
     * @return Integer
     */
    public Integer getReplenishStock() {
        return this.replenishStock;
    }
}
