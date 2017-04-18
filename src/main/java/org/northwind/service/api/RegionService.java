package org.northwind.service.api;
import java.util.List;

import org.northwind.domain.Country;
import org.northwind.domain.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooService;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = RegionService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Region.class)
public interface RegionService extends EntityResolver<Region, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Region
     */
    public abstract Region findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     */
    public abstract void delete(Region region);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Region> save(Iterable<Region> entities);

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
     * @return Region
     */
    public abstract Region save(Region entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Region
     */
    public abstract Region findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Region> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Region> findAll();

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
    public abstract Page<Region> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param citiesToAdd
     * @return Region
     */
    public abstract Region addToCities(Region region, Iterable<Long> citiesToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param citiesToRemove
     * @return Region
     */
    public abstract Region removeFromCities(Region region, Iterable<Long> citiesToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param cities
     * @return Region
     */
    public abstract Region setCities(Region region, Iterable<Long> cities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param customerOrdersToAdd
     * @return Region
     */
    public abstract Region addToCustomerOrders(Region region, Iterable<Long> customerOrdersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param customerOrdersToRemove
     * @return Region
     */
    public abstract Region removeFromCustomerOrders(Region region, Iterable<Long> customerOrdersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param customerOrders
     * @return Region
     */
    public abstract Region setCustomerOrders(Region region, Iterable<Long> customerOrders);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param partiesToAdd
     * @return Region
     */
    public abstract Region addToParties(Region region, Iterable<Long> partiesToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param partiesToRemove
     * @return Region
     */
    public abstract Region removeFromParties(Region region, Iterable<Long> partiesToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param parties
     * @return Region
     */
    public abstract Region setParties(Region region, Iterable<Long> parties);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param storesToAdd
     * @return Region
     */
    public abstract Region addToStores(Region region, Iterable<Long> storesToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param storesToRemove
     * @return Region
     */
    public abstract Region removeFromStores(Region region, Iterable<Long> storesToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param stores
     * @return Region
     */
    public abstract Region setStores(Region region, Iterable<Long> stores);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param suppliersToAdd
     * @return Region
     */
    public abstract Region addToSuppliers(Region region, Iterable<Long> suppliersToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param suppliersToRemove
     * @return Region
     */
    public abstract Region removeFromSuppliers(Region region, Iterable<Long> suppliersToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param suppliers
     * @return Region
     */
    public abstract Region setSuppliers(Region region, Iterable<Long> suppliers);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Region> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return Long
     */
    public abstract long countByCountry(Country country);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param pageable
     * @return Page
     */
    public abstract Page<Region> findByCountryIdOrderByDescriptionAsc(Long id, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Long
     */
    public abstract long countByCountryIdOrderByDescriptionAsc(Long id);
}
