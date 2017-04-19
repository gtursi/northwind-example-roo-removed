package org.northwind.service.api;
import java.util.List;

import org.northwind.domain.Shipper;
import org.northwind.domain.ShipperPhoneFormBean;
import org.northwind.domain.ShipperProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = ShipperService
 TODO Auto-generated class documentation
 *
 */
public interface ShipperService extends EntityResolver<Shipper, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Shipper
     */
    public abstract Shipper findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     */
    public abstract void delete(Shipper shipper);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Shipper> save(Iterable<Shipper> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Shipper
     */
    public abstract Shipper save(Shipper entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Shipper
     */
    public abstract Shipper findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Shipper> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Shipper> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Shipper> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @param customerOrdersToAdd
     * @return Shipper
     */
    public abstract Shipper addToCustomerOrders(Shipper shipper, Iterable<Long> customerOrdersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @param customerOrdersToRemove
     * @return Shipper
     */
    public abstract Shipper removeFromCustomerOrders(Shipper shipper, Iterable<Long> customerOrdersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @param customerOrders
     * @return Shipper
     */
    public abstract Shipper setCustomerOrders(Shipper shipper, Iterable<Long> customerOrders);

    /**
     * TODO Auto-generated method documentation
     *
     * @param companyName
     * @param pageable
     * @return Page
     */
    public abstract Page<Shipper> findByCompanyName(String companyName, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<ShipperProjection> findByPhone(ShipperPhoneFormBean formBean, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param companyName
     * @return Long
     */
    public abstract long countByCompanyName(String companyName);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public abstract long countByPhone(ShipperPhoneFormBean formBean);
}
