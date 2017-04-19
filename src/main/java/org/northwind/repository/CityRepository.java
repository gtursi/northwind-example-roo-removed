package org.northwind.repository;
import org.northwind.domain.City;
import org.northwind.domain.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = CityRepository
 TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public interface CityRepository extends DetachableJpaRepository<City, Long>, CityRepositoryCustom {

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
