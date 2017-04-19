package org.northwind.web;
import java.util.Set;

import org.northwind.domain.City;
import org.northwind.domain.Country;
import org.northwind.domain.Customer;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Employee;
import org.northwind.domain.OrderDetail;
import org.northwind.domain.Region;
import org.northwind.domain.Shipper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * = CustomerOrderJsonMixin
 TODO Auto-generated class documentation
 *
 */
public abstract class CustomerOrderJsonMixin {

    @JsonIgnore
    private Set<OrderDetail> orderDetails;

    @JsonDeserialize(using = CountryDeserializer.class)
    private Country country;

    @JsonDeserialize(using = ShipperDeserializer.class)
    private Shipper shipper;

    @JsonDeserialize(using = CityDeserializer.class)
    private City city;

    @JsonDeserialize(using = EmployeeDeserializer.class)
    private Employee employee;

    @JsonDeserialize(using = RegionDeserializer.class)
    private Region region;

    @JsonDeserialize(using = CustomerDeserializer.class)
    private Customer customer;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetails
     */
    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return City
     */
    public City getCity() {
        return city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Region
     */
    public Region getRegion() {
        return region;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Shipper
     */
    public Shipper getShipper() {
        return shipper;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     */
    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }
}
