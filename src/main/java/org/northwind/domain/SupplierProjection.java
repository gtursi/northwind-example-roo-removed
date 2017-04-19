package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = SupplierProjection
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class SupplierProjection {

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
    private String contactTitle;

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
     * TODO Auto-generated attribute documentation
     *
     */
    private String postalCode;

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
     * TODO Auto-generated attribute documentation
     *
     */
    private String web;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param supplierId
     * @param countryId
     * @param regionId
     * @param cityId
     * @param companyName
     * @param contactName
     * @param contactTitle
     * @param address
     * @param countryDescription
     * @param regionDescription
     * @param cityDescription
     * @param postalCode
     * @param phone
     * @param fax
     * @param web
     */
    public SupplierProjection(Long supplierId, Long countryId, Long regionId, Long cityId, String companyName, String contactName, String contactTitle, String address, String countryDescription, String regionDescription, String cityDescription, String postalCode, String phone, String fax, String web) {
        this.supplierId = supplierId;
        this.countryId = countryId;
        this.regionId = regionId;
        this.cityId = cityId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.address = address;
        this.countryDescription = countryDescription;
        this.regionDescription = regionDescription;
        this.cityDescription = cityDescription;
        this.postalCode = postalCode;
        this.phone = phone;
        this.fax = fax;
        this.web = web;
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
    public String getContactTitle() {
        return this.contactTitle;
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

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getPostalCode() {
        return this.postalCode;
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

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getWeb() {
        return this.web;
    }
}
