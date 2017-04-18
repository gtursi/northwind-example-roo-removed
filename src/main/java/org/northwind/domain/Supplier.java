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
 * = Supplier
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(table = "NW_SUPPLIERS")
@RooEquals(isJpaEntity = true)
@Entity
@Table(name = "NW_SUPPLIERS")
@EntityFormat
public class Supplier {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @SequenceGenerator(name = "supplierGen", sequenceName = "NW_SUPPLIERS_SUPPLIER_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplierGen")
    @Column(name = "SUPPLIER_ID")
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
    @Column(name = "COMPANY_NAME")
    private String companyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "CONTACT_NAME")
    private String contactName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "CONTACT_TITLE")
    private String contactTitle;

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
    @Column(name = "FAX")
    private String fax;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "WEB")
    private String web;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "supplier")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Product> products = new HashSet<Product>();

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
        if (!(obj instanceof Supplier)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Supplier) obj).getId());
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
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
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
     * @param contactTitle
     */
    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
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
    public String getFax() {
        return this.fax;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getWeb() {
        return this.web;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param web
     */
    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Product> getProducts() {
        return this.products;
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
     * @return String
     */
    public String toString() {
        return "Supplier {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", companyName='" + companyName + '\'' + ", contactName='" + contactName + '\'' + ", contactTitle='" + contactTitle + '\'' + ", address='" + address + '\'' + ", postalCode='" + postalCode + '\'' + ", phone='" + phone + '\'' + ", fax='" + fax + '\'' + ", web='" + web + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productsToAdd
     */
    public void addToProducts(Iterable<Product> productsToAdd) {
        Assert.notNull(productsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Product item : productsToAdd) {
            this.products.add(item);
            item.setSupplier(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productsToRemove
     */
    public void removeFromProducts(Iterable<Product> productsToRemove) {
        Assert.notNull(productsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Product item : productsToRemove) {
            this.products.remove(item);
            item.setSupplier(null);
        }
    }
}
