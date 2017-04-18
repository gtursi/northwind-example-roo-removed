package org.northwind.repository;
import org.northwind.domain.SoldProduct;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = SoldProductRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = SoldProduct.class)
@Transactional(readOnly = true)
public interface SoldProductRepository extends DetachableJpaRepository<SoldProduct, Long>, SoldProductRepositoryCustom {
}
