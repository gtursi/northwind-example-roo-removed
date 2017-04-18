package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = StoreProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class StoreProjection {

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
    private Long countryId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long regionId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long cityId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String name;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String address;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String countryDescription;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String regionDescription;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String cityDescription;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param storeId
     * @param countryId
     * @param regionId
     * @param cityId
     * @param name
     * @param address
     * @param countryDescription
     * @param regionDescription
     * @param cityDescription
     */
    public StoreProjection(Long storeId, Long countryId, Long regionId, Long cityId, String name, String address, String countryDescription, String regionDescription, String cityDescription) {
        this.storeId = storeId;
        this.countryId = countryId;
        this.regionId = regionId;
        this.cityId = cityId;
        this.name = name;
        this.address = address;
        this.countryDescription = countryDescription;
        this.regionDescription = regionDescription;
        this.cityDescription = cityDescription;
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
    public Long getCountryId() {
        return this.countryId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getRegionId() {
        return this.regionId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getCityId() {
        return this.cityId;
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
    public String getAddress() {
        return this.address;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCountryDescription() {
        return this.countryDescription;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getRegionDescription() {
        return this.regionDescription;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCityDescription() {
        return this.cityDescription;
    }
}
