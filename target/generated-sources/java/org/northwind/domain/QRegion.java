package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRegion is a Querydsl query type for Region
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRegion extends EntityPathBase<Region> {

    private static final long serialVersionUID = -2036671277L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRegion region = new QRegion("region");

    public final SetPath<City, QCity> cities = this.<City, QCity>createSet("cities", City.class, QCity.class, PathInits.DIRECT2);

    public final QCountry country;

    public final SetPath<CustomerOrder, QCustomerOrder> customerOrders = this.<CustomerOrder, QCustomerOrder>createSet("customerOrders", CustomerOrder.class, QCustomerOrder.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<Party, QParty> parties = this.<Party, QParty>createSet("parties", Party.class, QParty.class, PathInits.DIRECT2);

    public final SetPath<Store, QStore> stores = this.<Store, QStore>createSet("stores", Store.class, QStore.class, PathInits.DIRECT2);

    public final SetPath<Supplier, QSupplier> suppliers = this.<Supplier, QSupplier>createSet("suppliers", Supplier.class, QSupplier.class, PathInits.DIRECT2);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QRegion(String variable) {
        this(Region.class, forVariable(variable), INITS);
    }

    public QRegion(Path<? extends Region> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRegion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRegion(PathMetadata metadata, PathInits inits) {
        this(Region.class, metadata, inits);
    }

    public QRegion(Class<? extends Region> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.country = inits.isInitialized("country") ? new QCountry(forProperty("country")) : null;
    }

}

