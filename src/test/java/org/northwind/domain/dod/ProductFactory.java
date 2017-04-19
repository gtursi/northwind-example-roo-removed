package org.northwind.domain.dod;
import java.math.BigDecimal;

import org.northwind.domain.Category;
import org.northwind.domain.Product;
import org.northwind.domain.Supplier;

/**
 * = ProductFactory
 TODO Auto-generated class documentation
 *
 */
public class ProductFactory {
	
    /**
     * Creates a new {@link Product} with the given index.
     * 
     * @param index position of the Product
     * @return a new transient Product
     */
    public Product create(int index) {
        Product obj = new Product();
        setCategory(obj, index);
        setCode(obj, index);
        setDiscontinued(obj, index);
        setName(obj, index);
        setQuantityPerUnit(obj, index);
        setReorderLevel(obj, index);
        setSupplier(obj, index);
        setUnitCost(obj, index);
        setUnitPrice(obj, index);
        setUnitsInStock(obj, index);
        return obj;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setCategory(Product obj, int index) {
        Category category = null;
        obj.setCategory(category);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setCode(Product obj, int index) {
        String code = "code_" + index;
        obj.setCode(code);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setDiscontinued(Product obj, int index) {
        Boolean discontinued = Boolean.TRUE;
        obj.setDiscontinued(discontinued);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setName(Product obj, int index) {
        String name = "name_" + index;
        obj.setName(name);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setQuantityPerUnit(Product obj, int index) {
        String quantityPerUnit = "quantityPerUnit_" + index;
        obj.setQuantityPerUnit(quantityPerUnit);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setReorderLevel(Product obj, int index) {
        Integer reorderLevel = new Integer(index);
        obj.setReorderLevel(reorderLevel);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setSupplier(Product obj, int index) {
        Supplier supplier = null;
        obj.setSupplier(supplier);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setUnitCost(Product obj, int index) {
        BigDecimal unitCost = BigDecimal.valueOf(index);
        obj.setUnitCost(unitCost);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setUnitPrice(Product obj, int index) {
        BigDecimal unitPrice = BigDecimal.valueOf(index);
        obj.setUnitPrice(unitPrice);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setUnitsInStock(Product obj, int index) {
        Integer unitsInStock = new Integer(index);
        obj.setUnitsInStock(unitsInStock);
    }

}
