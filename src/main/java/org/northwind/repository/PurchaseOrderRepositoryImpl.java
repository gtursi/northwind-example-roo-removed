package org.northwind.repository;
import org.northwind.domain.Employee;
import org.northwind.domain.Product;
import org.northwind.domain.PurchaseOrder;
import org.northwind.domain.QPurchaseOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;

/**
 * = PurchaseOrderRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public class PurchaseOrderRepositoryImpl extends QueryDslRepositorySupportExt<PurchaseOrder> implements PurchaseOrderRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    PurchaseOrderRepositoryImpl() {
        super(PurchaseOrder.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String UNIT_COST = "unitCost";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ORDER_DATE = "orderDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String QUANTITY = "quantity";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String EMPLOYEE = "employee";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PRODUCT = "product";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<PurchaseOrder> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QPurchaseOrder purchaseOrder = QPurchaseOrder.purchaseOrder;
        JPQLQuery<PurchaseOrder> query = from(purchaseOrder);
        Path<?>[] paths = new Path<?>[] { purchaseOrder.employee, purchaseOrder.product, purchaseOrder.unitCost, purchaseOrder.quantity, purchaseOrder.orderDate };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(EMPLOYEE, purchaseOrder.employee).map(PRODUCT, purchaseOrder.product).map(UNIT_COST, purchaseOrder.unitCost).map(QUANTITY, purchaseOrder.quantity).map(ORDER_DATE, purchaseOrder.orderDate);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, purchaseOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<PurchaseOrder> findByEmployee(Employee employee, GlobalSearch globalSearch, Pageable pageable) {
        QPurchaseOrder purchaseOrder = QPurchaseOrder.purchaseOrder;
        JPQLQuery<PurchaseOrder> query = from(purchaseOrder);
        Assert.notNull(employee, "employee is required");
        query.where(purchaseOrder.employee.eq(employee));
        Path<?>[] paths = new Path<?>[] { purchaseOrder.employee, purchaseOrder.product, purchaseOrder.unitCost, purchaseOrder.quantity, purchaseOrder.orderDate };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(EMPLOYEE, purchaseOrder.employee).map(PRODUCT, purchaseOrder.product).map(UNIT_COST, purchaseOrder.unitCost).map(QUANTITY, purchaseOrder.quantity).map(ORDER_DATE, purchaseOrder.orderDate);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, purchaseOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<PurchaseOrder> findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable) {
        QPurchaseOrder purchaseOrder = QPurchaseOrder.purchaseOrder;
        JPQLQuery<PurchaseOrder> query = from(purchaseOrder);
        Assert.notNull(product, "product is required");
        query.where(purchaseOrder.product.eq(product));
        Path<?>[] paths = new Path<?>[] { purchaseOrder.employee, purchaseOrder.product, purchaseOrder.unitCost, purchaseOrder.quantity, purchaseOrder.orderDate };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(EMPLOYEE, purchaseOrder.employee).map(PRODUCT, purchaseOrder.product).map(UNIT_COST, purchaseOrder.unitCost).map(QUANTITY, purchaseOrder.quantity).map(ORDER_DATE, purchaseOrder.orderDate);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, purchaseOrder);
    }
}
