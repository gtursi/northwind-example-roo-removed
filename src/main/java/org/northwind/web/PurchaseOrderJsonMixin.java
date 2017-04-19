package org.northwind.web;
import org.northwind.domain.Employee;
import org.northwind.domain.Product;
import org.northwind.domain.PurchaseOrder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * = PurchaseOrderJsonMixin
 TODO Auto-generated class documentation
 *
 */
public abstract class PurchaseOrderJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = ProductDeserializer.class)
    private Product product;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = EmployeeDeserializer.class)
    private Employee employee;

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
     * @return Product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}
