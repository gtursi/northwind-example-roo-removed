package org.northwind.repository;
import org.northwind.domain.Report;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = ReportRepository
 TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public interface ReportRepository extends DetachableJpaRepository<Report, Long>, ReportRepositoryCustom {
}
