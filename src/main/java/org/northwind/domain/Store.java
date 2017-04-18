package org.northwind.domain;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

import io.springlets.format.EntityFormat;

/**
 * = Store
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(table = "NW_STORES")
@RooEquals(isJpaEntity = true)
@Entity
@Table(name = "NW_STORES")
@EntityFormat
public class Store {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @SequenceGenerator(name = "storeGen", sequenceName = "NW_STORES_STORE_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storeGen")
    @Column(name = "STORE_ID")
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
    @JoinColumn(name = "CITY")
    @EntityFormat
    private City city;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION")
    @EntityFormat
    private Region region;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "NAME")
    private String name;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "POSTAL_CODE")
    private String postalCode;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "PHONE")
    private String phone;

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
        if (!(obj instanceof Store)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Store) obj).getId());
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
     * @return City
     */
    public City getCity() {
        return this.city;
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
     * @return Region
     */
    public Region getRegion() {
        return this.region;
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
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
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
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "Store {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", address='" + address + '\'' + ", postalCode='" + postalCode + '\'' + ", phone='" + phone + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }
}
