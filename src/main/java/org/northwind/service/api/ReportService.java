package org.northwind.service.api;
import java.util.List;

import org.northwind.domain.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooService;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = ReportService
 TODO Auto-generated class documentation
 *
 */
@RooService(entity = Report.class)
public interface ReportService extends EntityResolver<Report, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Report
     */
    public abstract Report findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param report
     */
    public abstract void delete(Report report);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Report> save(Iterable<Report> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Report
     */
    public abstract Report save(Report entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Report
     */
    public abstract Report findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Report> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Report> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Report> findAll(GlobalSearch globalSearch, Pageable pageable);
}
