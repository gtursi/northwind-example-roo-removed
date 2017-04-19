package org.northwind.domain;

import io.springlets.format.EntityFormat;

/**
 * = ShipperPhoneFormBean
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class ShipperPhoneFormBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String phone;

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
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
