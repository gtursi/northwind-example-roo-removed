package org.northwind.dod;
import javax.persistence.EntityManager;

import org.northwind.domain.dod.CategoryDataOnDemand;
import org.northwind.domain.dod.CustomerOrderDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * = DataOnDemandConfiguration
 TODO Auto-generated class documentation
 *
 */
@TestConfiguration
public class DataOnDemandConfiguration {

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param entityManager
     */
    @Autowired
    public DataOnDemandConfiguration(EntityManager entityManager) {
        setEntityManager(entityManager);
    }
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private EntityManager entityManager;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return EntityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entityManager
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return CategoryDataOnDemand
     */
    @Bean
    public CategoryDataOnDemand categoryDataOnDemand() {
        return new CategoryDataOnDemand(getEntityManager());
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return CustomerOrderDataOnDemand
     */
    @Bean
    public CustomerOrderDataOnDemand customerOrderDataOnDemand() {
        return new CustomerOrderDataOnDemand(getEntityManager());
    }
    
}
