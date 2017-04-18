package org.northwind.domain.dod;
import java.math.BigDecimal;

import org.northwind.domain.CustomerOrder;
import org.northwind.domain.OrderDetail;
import org.northwind.domain.Product;
import org.springframework.roo.addon.jpa.annotations.entity.factory.RooJpaEntityFactory;

/**
 * = OrderDetailFactory
 TODO Auto-generated class documentation
 *
 */
@RooJpaEntityFactory(entity = OrderDetail.class)
public class OrderDetailFactory {
	
    /**
     * Creates a new {@link OrderDetail} with the given index.
     * 
     * @param index position of the OrderDetail
     * @return a new transient OrderDetail
     */
    public OrderDetail create(int index) {
        OrderDetail obj = new OrderDetail();
        setCustomerOrder(obj, index);
        setDiscount(obj, index);
        setProduct(obj, index);
        setQuantity(obj, index);
        setUnitPrice(obj, index);
        return obj;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setCustomerOrder(OrderDetail obj, int index) {
        CustomerOrder customerOrder = null;
        obj.setCustomerOrder(customerOrder);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setDiscount(OrderDetail obj, int index) {
        BigDecimal discount = BigDecimal.valueOf(index);
        obj.setDiscount(discount);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setProduct(OrderDetail obj, int index) {
        Product product = null;
        obj.setProduct(product);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setQuantity(OrderDetail obj, int index) {
        Integer quantity = new Integer(index);
        obj.setQuantity(quantity);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setUnitPrice(OrderDetail obj, int index) {
        BigDecimal unitPrice = BigDecimal.valueOf(index);
        obj.setUnitPrice(unitPrice);
    }

}
