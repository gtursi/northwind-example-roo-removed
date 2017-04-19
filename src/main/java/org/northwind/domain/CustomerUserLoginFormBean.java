package org.northwind.domain;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = CustomerUserLoginFormBean
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class CustomerUserLoginFormBean {

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
    @NotNull
    @Size(max = 50)
    private String companyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(max = 100)
    private String contactName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Size(max = 80)
    private String contactTitle;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(max = 80)
    private String email;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(max = 200)
    private String address;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    private City city;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    private Region region;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    private Country country;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(max = 6)
    private String postalCode;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Size(max = 15)
    private String phone;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Size(max = 15)
    private String fax;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(max = 30)
    private String username;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(min = 8, max = 128)
    private String password;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(min = 8, max = 128)
    private String repeatPassword;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerId
     * @param companyName
     * @param contactName
     * @param contactTitle
     * @param email
     * @param address
     * @param city
     * @param region
     * @param country
     * @param postalCode
     * @param phone
     * @param fax
     * @param username
     * @param password
     * @param repeatPassword
     */
    public CustomerUserLoginFormBean(Long customerId, String companyName, String contactName, String contactTitle, String email, String address, City city, Region region, Country country, String postalCode, String phone, String fax, String username, String password, String repeatPassword) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.email = email;
        this.address = address;
        this.city = city;
        this.region = region;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.fax = fax;
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
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
    public String getContactTitle() {
        return this.contactTitle;
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
    public String getAddress() {
        return this.address;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return City
     */
    public City getCity() {
        return this.city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Region
     */
    public Region getRegion() {
        return this.region;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Country
     */
    public Country getCountry() {
        return this.country;
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
    public String getUsername() {
        return this.username;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getRepeatPassword() {
        return this.repeatPassword;
    }
}
