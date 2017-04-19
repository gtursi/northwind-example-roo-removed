package org.northwind.web;
import java.util.Set;

import org.northwind.domain.City;
import org.northwind.domain.Country;
import org.northwind.domain.Product;
import org.northwind.domain.Region;
import org.northwind.domain.Supplier;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * = SupplierJsonMixin
 TODO Auto-generated class documentation
 *
 */
public abstract class SupplierJsonMixin {

    @JsonDeserialize(using = CountryDeserializer.class)
    private Country country;

    @JsonDeserialize(using = CityDeserializer.class)
    private City city;

    @JsonDeserialize(using = RegionDeserializer.class)
    private Region region;

    @JsonIgnore
    private Set<Product> products;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param products
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
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
}
