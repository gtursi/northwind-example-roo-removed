package org.northwind.repository;
import org.northwind.domain.City;
import org.northwind.domain.QCity;
import org.northwind.domain.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;

/**
 * = CityRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public class CityRepositoryImpl extends QueryDslRepositorySupportExt<City> implements CityRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    CityRepositoryImpl() {
        super(City.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CREATED_BY = "createdBy";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String MODIFIED_BY = "modifiedBy";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DESCRIPTION = "description";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CREATED_DATE = "createdDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String MODIFIED_DATE = "modifiedDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REGION = "region";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<City> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCity city = QCity.city;
        JPQLQuery<City> query = from(city);
        Path<?>[] paths = new Path<?>[] { city.description, city.region, city.createdDate, city.createdBy, city.modifiedDate, city.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(DESCRIPTION, city.description).map(REGION, city.region).map(CREATED_DATE, city.createdDate).map(CREATED_BY, city.createdBy).map(MODIFIED_DATE, city.modifiedDate).map(MODIFIED_BY, city.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<City> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
        QCity city = QCity.city;
        JPQLQuery<City> query = from(city);
        Assert.notNull(region, "region is required");
        query.where(city.region.eq(region));
        Path<?>[] paths = new Path<?>[] { city.description, city.region, city.createdDate, city.createdBy, city.modifiedDate, city.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(DESCRIPTION, city.description).map(REGION, city.region).map(CREATED_DATE, city.createdDate).map(CREATED_BY, city.createdBy).map(MODIFIED_DATE, city.modifiedDate).map(MODIFIED_BY, city.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, city);
    }
}
