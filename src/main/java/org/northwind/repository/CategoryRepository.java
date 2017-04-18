package org.northwind.repository;
import org.northwind.domain.Category;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = CategoryRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Category.class)
@Transactional(readOnly = true)
public interface CategoryRepository extends DetachableJpaRepository<Category, Long>, CategoryRepositoryCustom {
}
