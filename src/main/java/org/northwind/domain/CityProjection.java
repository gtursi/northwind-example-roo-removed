package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = CityProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class CityProjection {

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
    @NumberFormat
    private Long regionId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String description;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param cityId
     * @param regionId
     * @param description
     */
    public CityProjection(Long cityId, Long regionId, String description) {
        this.cityId = cityId;
        this.regionId = regionId;
        this.description = description;
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
     * @return Long
     */
    public Long getRegionId() {
        return this.regionId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getDescription() {
        return this.description;
    }
}
