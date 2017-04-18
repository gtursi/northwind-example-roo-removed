package org.northwind.domain.dod;
import java.util.Calendar;

import org.northwind.domain.Category;
import org.springframework.roo.addon.jpa.annotations.entity.factory.RooJpaEntityFactory;

/**
 * = CategoryFactory
 TODO Auto-generated class documentation
 *
 */
@RooJpaEntityFactory(entity = Category.class)
public class CategoryFactory {
	
    /**
     * Creates a new {@link Category} with the given index.
     * 
     * @param index position of the Category
     * @return a new transient Category
     */
    public Category create(int index) {
        Category obj = new Category();
        setCreatedBy(obj, index);
        setCreatedDate(obj, index);
        setDescription(obj, index);
        setModifiedBy(obj, index);
        setModifiedDate(obj, index);
        setName(obj, index);
        return obj;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setCreatedBy(Category obj, int index) {
        String createdBy = "createdBy_" + index;
        obj.setCreatedBy(createdBy);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setCreatedDate(Category obj, int index) {
        Calendar createdDate = Calendar.getInstance();
        obj.setCreatedDate(createdDate);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setDescription(Category obj, int index) {
        String description = "description_" + index;
        obj.setDescription(description);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setModifiedBy(Category obj, int index) {
        String modifiedBy = "modifiedBy_" + index;
        obj.setModifiedBy(modifiedBy);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setModifiedDate(Category obj, int index) {
        Calendar modifiedDate = Calendar.getInstance();
        obj.setModifiedDate(modifiedDate);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @param index
     */
    public void setName(Category obj, int index) {
        String name = "name_" + index;
        obj.setName(name);
    }

}
