package org.northwind.repository;
import org.northwind.domain.Employee;
import org.northwind.domain.Product;
import org.northwind.domain.PurchaseOrder;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = PurchaseOrderRepository
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = PurchaseOrder.class)
@Transactional(readOnly = true)
public interface PurchaseOrderRepository extends DetachableJpaRepository<PurchaseOrder, Long>, PurchaseOrderRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return Long
     */
    public abstract long countByProduct(Product product);

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     * @return Long
     */
    public abstract long countByEmployee(Employee employee);
}
