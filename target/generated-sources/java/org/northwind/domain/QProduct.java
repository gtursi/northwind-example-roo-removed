package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -107883792L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final QCategory category;

    public final StringPath code = createString("code");

    public final BooleanPath discontinued = createBoolean("discontinued");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final SetPath<OrderDetail, QOrderDetail> orderDetails = this.<OrderDetail, QOrderDetail>createSet("orderDetails", OrderDetail.class, QOrderDetail.class, PathInits.DIRECT2);

    public final SetPath<PurchaseOrder, QPurchaseOrder> purchaseOrders = this.<PurchaseOrder, QPurchaseOrder>createSet("purchaseOrders", PurchaseOrder.class, QPurchaseOrder.class, PathInits.DIRECT2);

    public final StringPath quantityPerUnit = createString("quantityPerUnit");

    public final NumberPath<Integer> reorderLevel = createNumber("reorderLevel", Integer.class);

    public final QSupplier supplier;

    public final NumberPath<java.math.BigDecimal> unitCost = createNumber("unitCost", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> unitPrice = createNumber("unitPrice", java.math.BigDecimal.class);

    public final NumberPath<Integer> unitsInStock = createNumber("unitsInStock", Integer.class);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
        this.supplier = inits.isInitialized("supplier") ? new QSupplier(forProperty("supplier"), inits.get("supplier")) : null;
    }

}

