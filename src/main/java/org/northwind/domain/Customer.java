package org.northwind.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import org.springframework.util.Assert;

import io.springlets.format.EntityFormat;

/**
 * = Customer
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(table = "NW_CUSTOMERS")
@Entity
@Table(name = "NW_CUSTOMERS")
@EntityFormat
public class Customer extends Party {

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
    @Column(name = "FAX")
    private String fax;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "customer")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<CustomerOrder> customerOrders = new HashSet<CustomerOrder>();

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
    public String getEmail() {
        return this.email;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return String
     */
    public String toString() {
        return "Customer {" + "companyName='" + companyName + '\'' + ", contactName='" + contactName + '\'' + ", contactTitle='" + contactTitle + '\'' + ", fax='" + fax + '\'' + ", email='" + email + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
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
            item.setCustomer(this);
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
            item.setCustomer(null);
        }
    }

}
