package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCountry is a Querydsl query type for Country
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCountry extends EntityPathBase<Country> {

    private static final long serialVersionUID = 1159421335L;

    public static final QCountry country = new QCountry("country");

    public final SetPath<CustomerOrder, QCustomerOrder> customerOrders = this.<CustomerOrder, QCustomerOrder>createSet("customerOrders", CustomerOrder.class, QCustomerOrder.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<Party, QParty> parties = this.<Party, QParty>createSet("parties", Party.class, QParty.class, PathInits.DIRECT2);

    public final SetPath<Region, QRegion> regions = this.<Region, QRegion>createSet("regions", Region.class, QRegion.class, PathInits.DIRECT2);

    public final SetPath<Store, QStore> stores = this.<Store, QStore>createSet("stores", Store.class, QStore.class, PathInits.DIRECT2);

    public final SetPath<Supplier, QSupplier> suppliers = this.<Supplier, QSupplier>createSet("suppliers", Supplier.class, QSupplier.class, PathInits.DIRECT2);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QCountry(String variable) {
        super(Country.class, forVariable(variable));
    }

    public QCountry(Path<? extends Country> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCountry(PathMetadata metadata) {
        super(Country.class, metadata);
    }

}

