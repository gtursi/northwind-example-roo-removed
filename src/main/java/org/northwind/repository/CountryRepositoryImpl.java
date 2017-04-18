package org.northwind.repository;
import org.northwind.domain.Country;
import org.northwind.domain.QCountry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;

/**
 * = CountryRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = CountryRepositoryCustom.class)
@Transactional(readOnly = true)
public class CountryRepositoryImpl extends QueryDslRepositorySupportExt<Country> implements CountryRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    CountryRepositoryImpl() {
        super(Country.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DESCRIPTION = "description";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Country> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCountry country = QCountry.country;
        JPQLQuery<Country> query = from(country);
        Path<?>[] paths = new Path<?>[] { country.description };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(DESCRIPTION, country.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, country);
    }
}
