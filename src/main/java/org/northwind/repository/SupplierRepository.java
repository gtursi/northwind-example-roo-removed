package org.northwind.repository;
import org.northwind.domain.City;
import org.northwind.domain.Country;
import org.northwind.domain.Region;
import org.northwind.domain.Supplier;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = SupplierRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Supplier.class)
@Transactional(readOnly = true)
public interface SupplierRepository extends DetachableJpaRepository<Supplier, Long>, SupplierRepositoryCustom {

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
     * @param city
     * @return Long
     */
    public abstract long countByCity(City city);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return Long
     */
    public abstract long countByRegion(Region region);
}
