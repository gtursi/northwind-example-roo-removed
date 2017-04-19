package org.northwind.web;
import java.util.Set;

import org.northwind.domain.City;
import org.northwind.domain.Country;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Party;
import org.northwind.domain.Region;
import org.northwind.domain.Store;
import org.northwind.domain.Supplier;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * = RegionJsonMixin
 TODO Auto-generated class documentation
 *
 */
public abstract class RegionJsonMixin {

    @JsonDeserialize(using = CountryDeserializer.class)
    private Country country;

    @JsonIgnore
    private Set<CustomerOrder> customerOrders;

    @JsonIgnore
    private Set<City> cities;

    @JsonIgnore
    private Set<Supplier> suppliers;

    @JsonIgnore
    private Set<Store> stores;

    @JsonIgnore
    private Set<Party> parties;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<City> getCities() {
        return cities;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param cities
     */
    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrders
     */
    public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Party> getParties() {
        return parties;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param parties
     */
    public void setParties(Set<Party> parties) {
        this.parties = parties;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Store> getStores() {
        return stores;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param stores
     */
    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param suppliers
     */
    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
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
}
