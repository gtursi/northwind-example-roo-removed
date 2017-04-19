package org.northwind.web;
import org.northwind.domain.City;
import org.northwind.domain.Country;
import org.northwind.domain.Party;
import org.northwind.domain.Region;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * = PartyJsonMixin
 TODO Auto-generated class documentation
 *
 */
public abstract class PartyJsonMixin {

    @JsonDeserialize(using = CountryDeserializer.class)
    private Country country;

    @JsonDeserialize(using = CityDeserializer.class)
    private City city;

    @JsonDeserialize(using = RegionDeserializer.class)
    private Region region;

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
