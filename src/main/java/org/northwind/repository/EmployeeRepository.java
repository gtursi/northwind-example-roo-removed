package org.northwind.repository;
import org.northwind.domain.Employee;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = EmployeeRepository
 TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public interface EmployeeRepository extends DetachableJpaRepository<Employee, Long>, EmployeeRepositoryCustom {
}
