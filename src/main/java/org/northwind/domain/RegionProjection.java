package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = RegionProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class RegionProjection {

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
    private Long countryId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String description;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param regionId
     * @param countryId
     * @param description
     */
    public RegionProjection(Long regionId, Long countryId, String description) {
        this.regionId = regionId;
        this.countryId = countryId;
        this.description = description;
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
    public Long getCountryId() {
        return this.countryId;
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
