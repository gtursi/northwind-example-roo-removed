package org.northwind.repository;
import org.northwind.domain.QSoldProduct;
import org.northwind.domain.SoldProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;

/**
 * = SoldProductRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public class SoldProductRepositoryImpl extends QueryDslRepositorySupportExt<SoldProduct> implements SoldProductRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    SoldProductRepositoryImpl() {
        super(SoldProduct.class);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<SoldProduct> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QSoldProduct soldProduct = QSoldProduct.soldProduct;
        JPQLQuery<SoldProduct> query = from(soldProduct);
        Path<?>[] paths = new Path<?>[] {  };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper();
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, soldProduct);
    }
}
