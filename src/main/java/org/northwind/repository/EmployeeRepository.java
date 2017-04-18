package org.northwind.repository;
import org.northwind.domain.Employee;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = EmployeeRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Employee.class)
@Transactional(readOnly = true)
public interface EmployeeRepository extends DetachableJpaRepository<Employee, Long>, EmployeeRepositoryCustom {
}
