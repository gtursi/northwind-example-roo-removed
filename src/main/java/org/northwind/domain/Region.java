package org.northwind.domain;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import org.springframework.util.Assert;

import io.springlets.format.EntityFormat;

/**
 * = Region
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(table = "NW_REGIONS")
@RooEquals(isJpaEntity = true)
@Entity
@Table(name = "NW_REGIONS")
@EntityFormat
public class Region {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @SequenceGenerator(name = "regionGen", sequenceName = "NW_REGIONS_REGION_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regionGen")
    @Column(name = "REGION_ID")
    private Long id;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY")
    @EntityFormat
    private Country country;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "region")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<City> cities = new HashSet<City>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "region")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Party> parties = new HashSet<Party>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "region")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<CustomerOrder> customerOrders = new HashSet<CustomerOrder>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "region")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Store> stores = new HashSet<Store>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "region")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Supplier> suppliers = new HashSet<Supplier>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * This `equals` implementation is specific for JPA entities and uses
     * the entity identifier for it, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // instanceof is false if the instance is null
        if (!(obj instanceof Region)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Region) obj).getId());
    }

    /**
     * This `hashCode` implementation is specific for JPA entities and uses a fixed `int` value to be able
     * to identify the entity in collections after a new id is assigned to the entity, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @return Integer
     */
    public int hashCode() {
        return 31;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getVersion() {
        return this.version;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
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
     * @param country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<City> getCities() {
        return this.cities;
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
    public Set<Party> getParties() {
        return this.parties;
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
    public Set<CustomerOrder> getCustomerOrders() {
        return this.customerOrders;
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
    public Set<Store> getStores() {
        return this.stores;
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
        return this.suppliers;
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
     * @return String
     */
    public String toString() {
        return "Region {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", description='" + description + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param citiesToAdd
     */
    public void addToCities(Iterable<City> citiesToAdd) {
        Assert.notNull(citiesToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (City item : citiesToAdd) {
            this.cities.add(item);
            item.setRegion(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param citiesToRemove
     */
    public void removeFromCities(Iterable<City> citiesToRemove) {
        Assert.notNull(citiesToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (City item : citiesToRemove) {
            this.cities.remove(item);
            item.setRegion(null);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param partiesToAdd
     */
    public void addToParties(Iterable<Party> partiesToAdd) {
        Assert.notNull(partiesToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Party item : partiesToAdd) {
            this.parties.add(item);
            item.setRegion(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param partiesToRemove
     */
    public void removeFromParties(Iterable<Party> partiesToRemove) {
        Assert.notNull(partiesToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Party item : partiesToRemove) {
            this.parties.remove(item);
            item.setRegion(null);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrdersToAdd
     */
    public void addToCustomerOrders(Iterable<CustomerOrder> customerOrdersToAdd) {
        Assert.notNull(customerOrdersToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (CustomerOrder item : customerOrdersToAdd) {
            this.customerOrders.add(item);
            item.setRegion(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrdersToRemove
     */
    public void removeFromCustomerOrders(Iterable<CustomerOrder> customerOrdersToRemove) {
        Assert.notNull(customerOrdersToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (CustomerOrder item : customerOrdersToRemove) {
            this.customerOrders.remove(item);
            item.setRegion(null);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storesToAdd
     */
    public void addToStores(Iterable<Store> storesToAdd) {
        Assert.notNull(storesToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Store item : storesToAdd) {
            this.stores.add(item);
            item.setRegion(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storesToRemove
     */
    public void removeFromStores(Iterable<Store> storesToRemove) {
        Assert.notNull(storesToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Store item : storesToRemove) {
            this.stores.remove(item);
            item.setRegion(null);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param suppliersToAdd
     */
    public void addToSuppliers(Iterable<Supplier> suppliersToAdd) {
        Assert.notNull(suppliersToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Supplier item : suppliersToAdd) {
            this.suppliers.add(item);
            item.setRegion(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param suppliersToRemove
     */
    public void removeFromSuppliers(Iterable<Supplier> suppliersToRemove) {
        Assert.notNull(suppliersToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Supplier item : suppliersToRemove) {
            this.suppliers.remove(item);
            item.setRegion(null);
        }
    }
}
