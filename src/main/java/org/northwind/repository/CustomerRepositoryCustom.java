package org.northwind.repository;
import org.northwind.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.springlets.data.domain.GlobalSearch;

/**
 * = CustomerRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
public interface CustomerRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Customer> findAll(GlobalSearch globalSearch, Pageable pageable);
}
