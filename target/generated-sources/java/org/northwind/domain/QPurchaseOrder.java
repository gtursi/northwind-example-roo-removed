package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPurchaseOrder is a Querydsl query type for PurchaseOrder
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPurchaseOrder extends EntityPathBase<PurchaseOrder> {

    private static final long serialVersionUID = 1132678158L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPurchaseOrder purchaseOrder = new QPurchaseOrder("purchaseOrder");

    public final QEmployee employee;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Calendar> orderDate = createDateTime("orderDate", java.util.Calendar.class);

    public final QProduct product;

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final NumberPath<java.math.BigDecimal> unitCost = createNumber("unitCost", java.math.BigDecimal.class);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QPurchaseOrder(String variable) {
        this(PurchaseOrder.class, forVariable(variable), INITS);
    }

    public QPurchaseOrder(Path<? extends PurchaseOrder> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPurchaseOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPurchaseOrder(PathMetadata metadata, PathInits inits) {
        this(PurchaseOrder.class, metadata, inits);
    }

    public QPurchaseOrder(Class<? extends PurchaseOrder> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employee = inits.isInitialized("employee") ? new QEmployee(forProperty("employee"), inits.get("employee")) : null;
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

