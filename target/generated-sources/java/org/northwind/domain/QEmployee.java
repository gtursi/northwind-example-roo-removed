package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployee is a Querydsl query type for Employee
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmployee extends EntityPathBase<Employee> {

    private static final long serialVersionUID = -1147166515L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployee employee = new QEmployee("employee");

    public final QParty _super;

    //inherited
    public final StringPath address;

    public final DateTimePath<java.util.Calendar> birthDate = createDateTime("birthDate", java.util.Calendar.class);

    // inherited
    public final QCity city;

    // inherited
    public final QCountry country;

    public final SetPath<CustomerOrder, QCustomerOrder> customerOrders = this.<CustomerOrder, QCustomerOrder>createSet("customerOrders", CustomerOrder.class, QCustomerOrder.class, PathInits.DIRECT2);

    public final StringPath extension = createString("extension");

    public final StringPath firstName = createString("firstName");

    public final DateTimePath<java.util.Calendar> hireDate = createDateTime("hireDate", java.util.Calendar.class);

    //inherited
    public final NumberPath<Long> id;

    public final StringPath lastName = createString("lastName");

    public final StringPath notes = createString("notes");

    //inherited
    public final StringPath phone;

    public final StringPath photo = createString("photo");

    //inherited
    public final StringPath postalCode;

    public final SetPath<PurchaseOrder, QPurchaseOrder> purchaseOrders = this.<PurchaseOrder, QPurchaseOrder>createSet("purchaseOrders", PurchaseOrder.class, QPurchaseOrder.class, PathInits.DIRECT2);

    // inherited
    public final QRegion region;

    public final StringPath title = createString("title");

    //inherited
    public final NumberPath<Long> version;

    public QEmployee(String variable) {
        this(Employee.class, forVariable(variable), INITS);
    }

    public QEmployee(Path<? extends Employee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmployee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmployee(PathMetadata metadata, PathInits inits) {
        this(Employee.class, metadata, inits);
    }

    public QEmployee(Class<? extends Employee> type, PathMetadata metadata, PathInits inits) {
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

