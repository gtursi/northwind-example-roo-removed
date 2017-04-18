package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = -1734460931L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomer customer = new QCustomer("customer");

    public final QParty _super;

    //inherited
    public final StringPath address;

    // inherited
    public final QCity city;

    public final StringPath companyName = createString("companyName");

    public final StringPath contactName = createString("contactName");

    public final StringPath contactTitle = createString("contactTitle");

    // inherited
    public final QCountry country;

    public final SetPath<CustomerOrder, QCustomerOrder> customerOrders = this.<CustomerOrder, QCustomerOrder>createSet("customerOrders", CustomerOrder.class, QCustomerOrder.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final StringPath fax = createString("fax");

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath phone;

    //inherited
    public final StringPath postalCode;

    // inherited
    public final QRegion region;

    //inherited
    public final NumberPath<Long> version;

    public QCustomer(String variable) {
        this(Customer.class, forVariable(variable), INITS);
    }

    public QCustomer(Path<? extends Customer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomer(PathMetadata metadata, PathInits inits) {
        this(Customer.class, metadata, inits);
    }

    public QCustomer(Class<? extends Customer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QParty(type, metadata, inits);
        this.address = _super.address;
        this.city = _super.city;
        this.country = _super.country;
        this.id = _super.id;
        this.phone = _super.phone;
        this.postalCode = _super.postalCode;
        this.region = _super.region;
        this.version = _super.version;
    }

}

