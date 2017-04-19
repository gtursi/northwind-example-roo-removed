package org.northwind.service.api;
import java.util.List;

import org.northwind.domain.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = CountryService
 TODO Auto-generated class documentation
 *
 */
public interface CountryService extends EntityResolver<Country, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Country
     */
    public abstract Country findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     */
    public abstract void delete(Country country);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Country> save(Iterable<Country> entities);

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
     * @return Country
     */
    public abstract Country save(Country entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Country
     */
    public abstract Country findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Country> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Country> findAll();

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
    public abstract Page<Country> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param customerOrdersToAdd
     * @return Country
     */
    public abstract Country addToCustomerOrders(Country country, Iterable<Long> customerOrdersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param customerOrdersToRemove
     * @return Country
     */
    public abstract Country removeFromCustomerOrders(Country country, Iterable<Long> customerOrdersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param customerOrders
     * @return Country
     */
    public abstract Country setCustomerOrders(Country country, Iterable<Long> customerOrders);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param partiesToAdd
     * @return Country
     */
    public abstract Country addToParties(Country country, Iterable<Long> partiesToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param partiesToRemove
     * @return Country
     */
    public abstract Country removeFromParties(Country country, Iterable<Long> partiesToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param parties
     * @return Country
     */
    public abstract Country setParties(Country country, Iterable<Long> parties);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param regionsToAdd
     * @return Country
     */
    public abstract Country addToRegions(Country country, Iterable<Long> regionsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param regionsToRemove
     * @return Country
     */
    public abstract Country removeFromRegions(Country country, Iterable<Long> regionsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param regions
     * @return Country
     */
    public abstract Country setRegions(Country country, Iterable<Long> regions);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param storesToAdd
     * @return Country
     */
    public abstract Country addToStores(Country country, Iterable<Long> storesToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param storesToRemove
     * @return Country
     */
    public abstract Country removeFromStores(Country country, Iterable<Long> storesToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param stores
     * @return Country
     */
    public abstract Country setStores(Country country, Iterable<Long> stores);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param suppliersToAdd
     * @return Country
     */
    public abstract Country addToSuppliers(Country country, Iterable<Long> suppliersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param suppliersToRemove
     * @return Country
     */
    public abstract Country removeFromSuppliers(Country country, Iterable<Long> suppliersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param suppliers
     * @return Country
     */
    public abstract Country setSuppliers(Country country, Iterable<Long> suppliers);
}
