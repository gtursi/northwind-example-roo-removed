package org.northwind.repository;
import org.northwind.domain.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.springlets.data.domain.GlobalSearch;

/**
 * = ReportRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
public interface ReportRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Report> findAll(GlobalSearch globalSearch, Pageable pageable);
}
