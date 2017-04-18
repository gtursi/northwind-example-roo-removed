package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomerOrder is a Querydsl query type for CustomerOrder
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomerOrder extends EntityPathBase<CustomerOrder> {

    private static final long serialVersionUID = 312873809L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomerOrder customerOrder = new QCustomerOrder("customerOrder");

    public final QCity city;

    public final DateTimePath<java.util.Calendar> closeDate = createDateTime("closeDate", java.util.Calendar.class);

    public final QCountry country;

    public final QCustomer customer;

    public final QEmployee employee;

    public final NumberPath<java.math.BigDecimal> freight = createNumber("freight", java.math.BigDecimal.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Calendar> invoiceDate = createDateTime("invoiceDate", java.util.Calendar.class);

    public final DateTimePath<java.util.Calendar> orderDate = createDateTime("orderDate", java.util.Calendar.class);

    public final SetPath<OrderDetail, QOrderDetail> orderDetails = this.<OrderDetail, QOrderDetail>createSet("orderDetails", OrderDetail.class, QOrderDetail.class, PathInits.DIRECT2);

    public final QRegion region;

    public final DateTimePath<java.util.Calendar> requiredDate = createDateTime("requiredDate", java.util.Calendar.class);

    public final StringPath shipAddress = createString("shipAddress");

    public final StringPath shipName = createString("shipName");

    public final DateTimePath<java.util.Calendar> shippedDate = createDateTime("shippedDate", java.util.Calendar.class);

    public final QShipper shipper;

    public final StringPath shipPhone = createString("shipPhone");

    public final StringPath shipPostalCode = createString("shipPostalCode");

    public final EnumPath<Status> status = createEnum("status", Status.class);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QCustomerOrder(String variable) {
        this(CustomerOrder.class, forVariable(variable), INITS);
    }

    public QCustomerOrder(Path<? extends CustomerOrder> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomerOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomerOrder(PathMetadata metadata, PathInits inits) {
        this(CustomerOrder.class, metadata, inits);
    }

    public QCustomerOrder(Class<? extends CustomerOrder> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.city = inits.isInitialized("city") ? new QCity(forProperty("city"), inits.get("city")) : null;
        this.country = inits.isInitialized("country") ? new QCountry(forProperty("country")) : null;
        this.customer = inits.isInitialized("customer") ? new QCustomer(forProperty("customer"), inits.get("customer")) : null;
        this.employee = inits.isInitialized("employee") ? new QEmployee(forProperty("employee"), inits.get("employee")) : null;
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region"), inits.get("region")) : null;
        this.shipper = inits.isInitialized("shipper") ? new QShipper(forProperty("shipper")) : null;
    }

}

