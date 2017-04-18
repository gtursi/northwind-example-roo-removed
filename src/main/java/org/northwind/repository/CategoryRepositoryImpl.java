package org.northwind.repository;
import org.northwind.domain.Category;
import org.northwind.domain.QCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;

/**
 * = CategoryRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = CategoryRepositoryCustom.class)
@Transactional(readOnly = true)
public class CategoryRepositoryImpl extends QueryDslRepositorySupportExt<Category> implements CategoryRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    CategoryRepositoryImpl() {
        super(Category.class);
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
    public static final String NAME = "name";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Category> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCategory category = QCategory.category;
        JPQLQuery<Category> query = from(category);
        Path<?>[] paths = new Path<?>[] { category.name, category.description, category.createdDate, category.createdBy, category.modifiedDate, category.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, category.name).map(DESCRIPTION, category.description).map(CREATED_DATE, category.createdDate).map(CREATED_BY, category.createdBy).map(MODIFIED_DATE, category.modifiedDate).map(MODIFIED_BY, category.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, category);
    }
}
