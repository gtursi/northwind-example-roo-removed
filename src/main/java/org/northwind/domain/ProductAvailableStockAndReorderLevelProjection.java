package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = ProductAvailableStockAndReorderLevelProjection
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class ProductAvailableStockAndReorderLevelProjection {

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
    private Integer avalaibleStock;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer reorderLevel;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productId
     * @param name
     * @param avalaibleStock
     * @param reorderLevel
     */
    public ProductAvailableStockAndReorderLevelProjection(Long productId, String name, Integer avalaibleStock, Integer reorderLevel) {
        this.productId = productId;
        this.name = name;
        this.avalaibleStock = avalaibleStock;
        this.reorderLevel = reorderLevel;
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
    public Integer getAvalaibleStock() {
        return this.avalaibleStock;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public Integer getReorderLevel() {
        return this.reorderLevel;
    }
}
