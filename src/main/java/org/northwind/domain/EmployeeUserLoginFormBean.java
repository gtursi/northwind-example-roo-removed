package org.northwind.domain;
import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = EmployeeUserLoginFormBean
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class EmployeeUserLoginFormBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long employeeId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(max = 50)
    private String firstName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(max = 120)
    private String lastName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(max = 120)
    private String title;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @DateTimeFormat(style = "M-")
    private Calendar birthDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @DateTimeFormat(style = "M-")
    private Calendar hireDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(max = 50)
    private String extension;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(max = 3500)
    private String notes;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private Employee supervisor;

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
     * @param employeeId
     * @param firstName
     * @param lastName
     * @param title
     * @param birthDate
     * @param hireDate
     * @param extension
     * @param notes
     * @param supervisor
     * @param address
     * @param city
     * @param region
     * @param country
     * @param postalCode
     * @param phone
     * @param username
     * @param password
     * @param repeatPassword
     */
    public EmployeeUserLoginFormBean(Long employeeId, String firstName, String lastName, String title, Calendar birthDate, Calendar hireDate, String extension, String notes, Employee supervisor, String address, City city, Region region, Country country, String postalCode, String phone, String username, String password, String repeatPassword) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.extension = extension;
        this.notes = notes;
        this.supervisor = supervisor;
        this.address = address;
        this.city = city;
        this.region = region;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getEmployeeId() {
        return this.employeeId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getBirthDate() {
        return this.birthDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getHireDate() {
        return this.hireDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getExtension() {
        return this.extension;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getNotes() {
        return this.notes;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Employee
     */
    public Employee getSupervisor() {
        return this.supervisor;
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
