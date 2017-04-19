package org.northwind.repository;
import org.northwind.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.springlets.data.domain.GlobalSearch;

/**
 * = CategoryRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
public interface CategoryRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Category> findAll(GlobalSearch globalSearch, Pageable pageable);
}
