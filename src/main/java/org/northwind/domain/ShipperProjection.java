package org.northwind.domain;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.roo.addon.dto.annotations.RooEntityProjection;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;

import io.springlets.format.EntityFormat;

/**
 * = ShipperProjection
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean(settersByDefault = false)
@RooToString
@RooEquals
@RooEntityProjection(entity = Shipper.class, fields = { "id", "companyName", "phone" })
@EntityFormat
public class ShipperProjection {

    private Long id;

    private String companyName;

    private String phone;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param id
     * @param companyName
     * @param phone
     */
    public ShipperProjection(Long id, String companyName, String phone) {
        this.id = id;
        this.companyName = companyName;
        this.phone = phone;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof ShipperProjection)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ShipperProjection rhs = (ShipperProjection) obj;
        return new EqualsBuilder().append(companyName, rhs.companyName).append(id, rhs.id).append(phone, rhs.phone).isEquals();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public int hashCode() {
        return new HashCodeBuilder().append(companyName).append(id).append(phone).toHashCode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "ShipperProjection {" + "id='" + id + '\'' + ", companyName='" + companyName + '\'' + ", phone='" + phone + '\'' + "}" + super.toString();
    }
}
