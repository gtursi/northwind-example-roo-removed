package org.northwind.repository;
import org.northwind.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.springlets.data.domain.GlobalSearch;

/**
 * = EmployeeRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
public interface EmployeeRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Employee> findAll(GlobalSearch globalSearch, Pageable pageable);
}
