package org.northwind.domain.dod;

import java.math.BigDecimal;
import java.util.Calendar;

import org.northwind.domain.City;
import org.northwind.domain.Country;
import org.northwind.domain.Customer;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Employee;
import org.northwind.domain.Region;
import org.northwind.domain.Shipper;
import org.northwind.domain.Status;

/**
 * = CustomerOrderFactory
 TODO Auto-generated class documentation
 *
 */
public class CustomerOrderFactory {
	
   /**
     * Creates a new {@link CustomerOrder} with the given index.
     * 
     * @param index position of the CustomerOrder
     * @return a new transient CustomerOrder
     */
    public CustomerOrder create(int index) {
        CustomerOrder obj = new CustomerOrder();
        setCity(obj, index);
        setCloseDate(obj, index);
        setCountry(obj, index);
        setCustomer(obj, index);
        setEmployee(obj, index);
        setFreight(obj, index);
        setInvoiceDate(obj, index);
        setOrderDate(obj, index);
        setRegion(obj, index);
        setRequiredDate(obj, index);
        setShipAddress(obj, index);
        setShipName(obj, index);
        setShipPhone(obj, index);
        setShipPostalCode(obj, index);
        setShippedDate(obj, index);
        setShipper(obj, index);
        setStatus(obj, index);
        return obj;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setCity(CustomerOrder obj, int index) {
        City city = null;
        obj.setCity(city);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setCloseDate(CustomerOrder obj, int index) {
        Calendar closeDate = Calendar.getInstance();
        obj.setCloseDate(closeDate);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setCountry(CustomerOrder obj, int index) {
        Country country = null;
        obj.setCountry(country);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setCustomer(CustomerOrder obj, int index) {
        Customer customer = null;
        obj.setCustomer(customer);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setEmployee(CustomerOrder obj, int index) {
        Employee employee = null;
        obj.setEmployee(employee);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setFreight(CustomerOrder obj, int index) {
        BigDecimal freight = BigDecimal.valueOf(index);
        obj.setFreight(freight);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setInvoiceDate(CustomerOrder obj, int index) {
        Calendar invoiceDate = Calendar.getInstance();
        obj.setInvoiceDate(invoiceDate);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setOrderDate(CustomerOrder obj, int index) {
        Calendar orderDate = Calendar.getInstance();
        obj.setOrderDate(orderDate);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setRegion(CustomerOrder obj, int index) {
        Region region = null;
        obj.setRegion(region);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setRequiredDate(CustomerOrder obj, int index) {
        Calendar requiredDate = Calendar.getInstance();
        obj.setRequiredDate(requiredDate);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setShipAddress(CustomerOrder obj, int index) {
        String shipAddress = "shipAddress_" + index;
        obj.setShipAddress(shipAddress);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setShipName(CustomerOrder obj, int index) {
        String shipName = "shipName_" + index;
        obj.setShipName(shipName);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setShipPhone(CustomerOrder obj, int index) {
        String shipPhone = "shipPhone_" + index;
        obj.setShipPhone(shipPhone);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setShipPostalCode(CustomerOrder obj, int index) {
        String shipPostalCode = "shipPostalCode_" + index;
        obj.setShipPostalCode(shipPostalCode);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setShippedDate(CustomerOrder obj, int index) {
        Calendar shippedDate = Calendar.getInstance();
        obj.setShippedDate(shippedDate);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setShipper(CustomerOrder obj, int index) {
        Shipper shipper = null;
        obj.setShipper(shipper);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setStatus(CustomerOrder obj, int index) {
        Status status = Status.class.getEnumConstants()[0];
        obj.setStatus(status);
    }

}
