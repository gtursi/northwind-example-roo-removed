package org.northwind.web;
import java.util.Set;

import org.northwind.domain.Country;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Party;
import org.northwind.domain.Region;
import org.northwind.domain.Store;
import org.northwind.domain.Supplier;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * = CountryJsonMixin
 TODO Auto-generated class documentation
 *
 */
public abstract class CountryJsonMixin {

    @JsonIgnore
    private Set<CustomerOrder> customerOrders;

    @JsonIgnore
    private Set<Region> regions;

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
    public Set<Region> getRegions() {
        return regions;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param regions
     */
    public void setRegions(Set<Region> regions) {
        this.regions = regions;
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
}
