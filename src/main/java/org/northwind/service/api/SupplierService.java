package org.northwind.service.api;
import java.util.List;

import org.northwind.domain.City;
import org.northwind.domain.Country;
import org.northwind.domain.Region;
import org.northwind.domain.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooService;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = SupplierService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Supplier.class)
public interface SupplierService extends EntityResolver<Supplier, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Supplier
     */
    public abstract Supplier findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     */
    public abstract void delete(Supplier supplier);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Supplier> save(Iterable<Supplier> entities);

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
     * @return Supplier
     */
    public abstract Supplier save(Supplier entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Supplier
     */
    public abstract Supplier findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Supplier> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Supplier> findAll();

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
    public abstract Page<Supplier> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param productsToAdd
     * @return Supplier
     */
    public abstract Supplier addToProducts(Supplier supplier, Iterable<Long> productsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param productsToRemove
     * @return Supplier
     */
    public abstract Supplier removeFromProducts(Supplier supplier, Iterable<Long> productsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param products
     * @return Supplier
     */
    public abstract Supplier setProducts(Supplier supplier, Iterable<Long> products);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Supplier> findByCity(City city, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Supplier> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Supplier> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return Long
     */
    public abstract long countByCity(City city);

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
     * @param region
     * @return Long
     */
    public abstract long countByRegion(Region region);
}
