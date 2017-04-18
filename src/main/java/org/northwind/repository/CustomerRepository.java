package org.northwind.repository;
import org.northwind.domain.Customer;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = CustomerRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Customer.class)
@Transactional(readOnly = true)
public interface CustomerRepository extends DetachableJpaRepository<Customer, Long>, CustomerRepositoryCustom {
}
