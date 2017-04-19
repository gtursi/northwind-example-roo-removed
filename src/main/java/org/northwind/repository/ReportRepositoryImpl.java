package org.northwind.repository;
import org.northwind.domain.QReport;
import org.northwind.domain.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;

/**
 * = ReportRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public class ReportRepositoryImpl extends QueryDslRepositorySupportExt<Report> implements ReportRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    ReportRepositoryImpl() {
        super(Report.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String TYPE = "type";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Report> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QReport report = QReport.report;
        JPQLQuery<Report> query = from(report);
        Path<?>[] paths = new Path<?>[] { report.type };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(TYPE, report.type);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, report);
    }
}
