package org.northwind.repository;
import org.northwind.domain.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;

import io.springlets.data.domain.GlobalSearch;

/**
 * = CountryRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = Country.class)
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
