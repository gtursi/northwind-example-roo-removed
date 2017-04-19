package org.northwind.repository;
import org.northwind.domain.Country;
import org.northwind.domain.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.springlets.data.domain.GlobalSearch;

/**
 * = RegionRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
public interface RegionRepositoryCustom {

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
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Region> findAll(GlobalSearch globalSearch, Pageable pageable);
}
