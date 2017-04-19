package org.northwind.repository;
import org.northwind.domain.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.springlets.data.domain.GlobalSearch;

/**
 * = CountryRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
public interface CountryRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Country> findAll(GlobalSearch globalSearch, Pageable pageable);
}
