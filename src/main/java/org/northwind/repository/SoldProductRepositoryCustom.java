package org.northwind.repository;
import org.northwind.domain.SoldProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.springlets.data.domain.GlobalSearch;

/**
 * = SoldProductRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
public interface SoldProductRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<SoldProduct> findAll(GlobalSearch globalSearch, Pageable pageable);
}
