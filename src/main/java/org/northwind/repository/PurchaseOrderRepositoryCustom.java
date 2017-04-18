package org.northwind.repository;
import org.northwind.domain.Employee;
import org.northwind.domain.Product;
import org.northwind.domain.PurchaseOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;

import io.springlets.data.domain.GlobalSearch;

/**
 * = PurchaseOrderRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = PurchaseOrder.class)
public interface PurchaseOrderRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<PurchaseOrder> findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<PurchaseOrder> findByEmployee(Employee employee, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<PurchaseOrder> findAll(GlobalSearch globalSearch, Pageable pageable);
}
