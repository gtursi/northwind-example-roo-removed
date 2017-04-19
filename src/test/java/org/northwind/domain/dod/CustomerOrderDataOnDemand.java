package org.northwind.domain.dod;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.northwind.domain.CustomerOrder;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * = CustomerOrderDataOnDemand
 TODO Auto-generated class documentation
 *
 */
@Configurable
public class CustomerOrderDataOnDemand {

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param entityManager
     */
    public CustomerOrderDataOnDemand(EntityManager entityManager) {
        this(entityManager, 10);
    }

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param entityManager
     * @param size
     */
    public CustomerOrderDataOnDemand(EntityManager entityManager, int size) {
        setEntityManager(entityManager);
        setSize(size);
    }

    /**
     * Random generator for the entities index.
     * 
     */
    private Random rnd = new SecureRandom();
    
    /**
     * List of created entities.
     * 
     */
    private List<CustomerOrder> data;
    
    /**
     * EntityManager to persist the entities.
     * 
     */
    private EntityManager entityManager;
    
    /**
     * Number of elements to create and persist.
     * 
     */
    private int size;
    
    /**
     * Factory to create entity instances.
     * 
     */
    private CustomerOrderFactory factory = new CustomerOrderFactory();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Random
     */
    public Random getRnd() {
        return rnd;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param rnd
     */
    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public List<CustomerOrder> getData() {
        return data;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param data
     */
    public void setData(List<CustomerOrder> data) {
        this.data = data;
    }
    
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
     * @return Integer
     */
    public int getSize() {
        return size;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return CustomerOrderFactory
     */
    public CustomerOrderFactory getFactory() {
        return factory;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param factory
     */
    public void setFactory(CustomerOrderFactory factory) {
        this.factory = factory;
    }
    
    /**
     * Creates a new transient CustomerOrder in a random index out of the initial list of the created entities,
     * with an index greater than {@link CustomerOrderDataOnDemand#getSize()} - 1.
     * 
     * @return CustomerOrder the generated transient {@link CustomerOrder}
     */
    public CustomerOrder getNewRandomTransientCustomerOrder() {
        int randomIndex = getSize() + getRnd().nextInt(Integer.MAX_VALUE - getSize());
        return getFactory().create(randomIndex);
    }
    
    /**
     * Returns a generated and persisted {@link CustomerOrder} in a given index.
     * 
     * @param index the position of the {@link CustomerOrder} to return
     * @return CustomerOrder the specific {@link CustomerOrder}
     */
    public CustomerOrder getSpecificCustomerOrder(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (getData().size() - 1)) {
            index = getData().size() - 1;
        }
        return getData().get(index);
    }
    
    /**
     * Returns a generated and persisted {@link CustomerOrder} in a random index.
     * 
     * @return CustomerOrder a random {@link CustomerOrder}
     */
    public CustomerOrder getRandomCustomerOrder() {
        init();
        return getData().get(getRnd().nextInt(getData().size()));
    }
    
    /**
     * Creates the initial list of generated entities.
     * 
     */
    public void init() {
        int from = 0;
        int to = 10;
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<CustomerOrder> cq = cb.createQuery(CustomerOrder.class);
        Root<CustomerOrder> rootEntry = cq.from(CustomerOrder.class);
        CriteriaQuery<CustomerOrder> all = cq.select(rootEntry);
        TypedQuery<CustomerOrder> allQuery = 
            getEntityManager().createQuery(all).setFirstResult(from).setMaxResults(to);
        setData(allQuery.getResultList());
        if (getData() == null) {
            throw new IllegalStateException(
                "Find entries implementation for 'CustomerOrder' illegally returned null");
        }
        if (!getData().isEmpty()) {
            return;
        }
        
        setData(new ArrayList<CustomerOrder>());
        for (int i = from; i < to; i++) {
            CustomerOrder obj = getFactory().create(i);
            try {
                getEntityManager().persist(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter
                      .hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".")
                    .append(cv.getPropertyPath()).append(": ").append(cv.getMessage())
                    .append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            getEntityManager().flush();
            getData().add(obj);
        }
    }

}
