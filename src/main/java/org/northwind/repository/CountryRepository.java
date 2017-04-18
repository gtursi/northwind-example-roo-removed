package org.northwind.repository;
import org.northwind.domain.Country;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = CountryRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Country.class)
@Transactional(readOnly = true)
public interface CountryRepository extends DetachableJpaRepository<Country, Long>, CountryRepositoryCustom {
}
