package org.northwind.service.api;
import java.util.List;

import org.northwind.domain.City;
import org.northwind.domain.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = CityService
 TODO Auto-generated class documentation
 *
 */
public interface CityService extends EntityResolver<City, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return City
     */
    public abstract City findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     */
    public abstract void delete(City city);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<City> save(Iterable<City> entities);

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
     * @return City
     */
    public abstract City save(City entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return City
     */
    public abstract City findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<City> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<City> findAll();

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
    public abstract Page<City> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param customerOrdersToAdd
     * @return City
     */
    public abstract City addToCustomerOrders(City city, Iterable<Long> customerOrdersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param customerOrdersToRemove
     * @return City
     */
    public abstract City removeFromCustomerOrders(City city, Iterable<Long> customerOrdersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param customerOrders
     * @return City
     */
    public abstract City setCustomerOrders(City city, Iterable<Long> customerOrders);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param partiesToAdd
     * @return City
     */
    public abstract City addToParties(City city, Iterable<Long> partiesToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param partiesToRemove
     * @return City
     */
    public abstract City removeFromParties(City city, Iterable<Long> partiesToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param parties
     * @return City
     */
    public abstract City setParties(City city, Iterable<Long> parties);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param storesToAdd
     * @return City
     */
    public abstract City addToStores(City city, Iterable<Long> storesToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param storesToRemove
     * @return City
     */
    public abstract City removeFromStores(City city, Iterable<Long> storesToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param stores
     * @return City
     */
    public abstract City setStores(City city, Iterable<Long> stores);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param suppliersToAdd
     * @return City
     */
    public abstract City addToSuppliers(City city, Iterable<Long> suppliersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param suppliersToRemove
     * @return City
     */
    public abstract City removeFromSuppliers(City city, Iterable<Long> suppliersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param suppliers
     * @return City
     */
    public abstract City setSuppliers(City city, Iterable<Long> suppliers);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<City> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return Long
     */
    public abstract long countByRegion(Region region);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param pageable
     * @return Page
     */
    public abstract Page<City> findByRegionIdOrderByDescriptionAsc(Long id, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Long
     */
    public abstract long countByRegionIdOrderByDescriptionAsc(Long id);
}
