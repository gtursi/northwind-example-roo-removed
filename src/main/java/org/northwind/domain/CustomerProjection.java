package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = CustomerProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class CustomerProjection {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long customerId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String companyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String contactName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String email;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String phone;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String fax;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerId
     * @param companyName
     * @param contactName
     * @param email
     * @param phone
     * @param fax
     */
    public CustomerProjection(Long customerId, String companyName, String contactName, String email, String phone, String fax) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.email = email;
        this.phone = phone;
        this.fax = fax;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getCustomerId() {
        return this.customerId;
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
    public String getContactName() {
        return this.contactName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEmail() {
        return this.email;
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
    public String getFax() {
        return this.fax;
    }
}
