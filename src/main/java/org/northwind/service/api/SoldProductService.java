package org.northwind.service.api;
import java.util.List;

import org.northwind.domain.SoldProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooService;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = SoldProductService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = SoldProduct.class)
public interface SoldProductService extends EntityResolver<SoldProduct, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return SoldProduct
     */
    public abstract SoldProduct findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProduct
     */
    public abstract void delete(SoldProduct soldProduct);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<SoldProduct> save(Iterable<SoldProduct> entities);

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
     * @return SoldProduct
     */
    public abstract SoldProduct save(SoldProduct entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return SoldProduct
     */
    public abstract SoldProduct findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<SoldProduct> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<SoldProduct> findAll();

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
    public abstract Page<SoldProduct> findAll(GlobalSearch globalSearch, Pageable pageable);
}
