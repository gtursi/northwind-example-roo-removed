package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = CountryProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class CountryProjection {

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
     * @param countryId
     * @param description
     */
    public CountryProjection(Long countryId, String description) {
        this.countryId = countryId;
        this.description = description;
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
