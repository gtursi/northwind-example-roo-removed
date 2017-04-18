package org.northwind.domain;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import org.springframework.util.Assert;

import io.springlets.format.EntityFormat;

/**
 * = Employee
 TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(table = "NW_EMPLOYEES")
@Entity
@Table(name = "NW_EMPLOYEES")
@EntityFormat
public class Employee extends Party {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "FIRST_NAME")
    private String firstName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "LAST_NAME")
    private String lastName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar birthDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar hireDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "EXTENSION")
    private String extension;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "PHOTO")
    private String photo;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "NOTES")
    private String notes;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "employee")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<PurchaseOrder> purchaseOrders = new HashSet<PurchaseOrder>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "employee")
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
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @param birthDate
     */
    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
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
     * @param hireDate
     */
    public void setHireDate(Calendar hireDate) {
        this.hireDate = hireDate;
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
     * @param extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getPhoto() {
        return this.photo;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
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
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<PurchaseOrder> getPurchaseOrders() {
        return this.purchaseOrders;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrders
     */
    public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
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
        return "Employee {" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", title='" + title + '\'' + ", birthDate='" + birthDate + '\'' + ", hireDate='" + hireDate + '\'' + ", extension='" + extension + '\'' + ", photo='" + photo + '\'' + ", notes='" + notes + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrdersToAdd
     */
    public void addToPurchaseOrders(Iterable<PurchaseOrder> purchaseOrdersToAdd) {
        Assert.notNull(purchaseOrdersToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (PurchaseOrder item : purchaseOrdersToAdd) {
            this.purchaseOrders.add(item);
            item.setEmployee(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrdersToRemove
     */
    public void removeFromPurchaseOrders(Iterable<PurchaseOrder> purchaseOrdersToRemove) {
        Assert.notNull(purchaseOrdersToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (PurchaseOrder item : purchaseOrdersToRemove) {
            this.purchaseOrders.remove(item);
            item.setEmployee(null);
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
            item.setEmployee(this);
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
            item.setEmployee(null);
        }
    }
}
