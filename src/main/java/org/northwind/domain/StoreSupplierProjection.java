package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = StoreSupplierProjection
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class StoreSupplierProjection {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long storeId;

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
    private String name;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param storeId
     * @param supplierId
     * @param name
     */
    public StoreSupplierProjection(Long storeId, Long supplierId, String name) {
        this.storeId = storeId;
        this.supplierId = supplierId;
        this.name = name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getStoreId() {
        return this.storeId;
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
    public String getName() {
        return this.name;
    }
}
