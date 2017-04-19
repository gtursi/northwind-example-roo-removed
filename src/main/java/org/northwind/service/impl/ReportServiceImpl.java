package org.northwind.service.impl;
import java.util.List;

import org.northwind.domain.Report;
import org.northwind.repository.ReportRepository;
import org.northwind.service.api.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.domain.GlobalSearch;

/**
 * = ReportServiceImpl
 TODO Auto-generated class documentation
 *
 */
@Service
@Transactional(readOnly = true)
public class ReportServiceImpl implements ReportService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ReportRepository reportRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param reportRepository
     */
    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository) {
        setReportRepository(reportRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ReportRepository
     */
    public ReportRepository getReportRepository() {
        return reportRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reportRepository
     */
    public void setReportRepository(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param report
     */
    @Transactional
    public void delete(Report report) {
        getReportRepository().delete(report);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Report> save(Iterable<Report> entities) {
        return getReportRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Report> toDelete = getReportRepository().findAll(ids);
        getReportRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Report
     */
    @Transactional
    public Report save(Report entity) {
        return getReportRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Report
     */
    public Report findOne(Long id) {
        return getReportRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Report
     */
    public Report findOneForUpdate(Long id) {
        return getReportRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Report> findAll(Iterable<Long> ids) {
        return getReportRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Report> findAll() {
        return getReportRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getReportRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Report> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getReportRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Report> getEntityType() {
        return Report.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
