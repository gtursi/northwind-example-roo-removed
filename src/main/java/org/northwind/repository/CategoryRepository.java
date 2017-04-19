package org.northwind.repository;
import org.northwind.domain.Category;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = CategoryRepository
 TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public interface CategoryRepository extends DetachableJpaRepository<Category, Long>, CategoryRepositoryCustom {
}
