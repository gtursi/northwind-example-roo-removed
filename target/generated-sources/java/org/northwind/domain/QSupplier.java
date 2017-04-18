package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSupplier is a Querydsl query type for Supplier
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSupplier extends EntityPathBase<Supplier> {

    private static final long serialVersionUID = 291025899L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSupplier supplier = new QSupplier("supplier");

    public final StringPath address = createString("address");

    public final QCity city;

    public final StringPath companyName = createString("companyName");

    public final StringPath contactName = createString("contactName");

    public final StringPath contactTitle = createString("contactTitle");

    public final QCountry country;

    public final StringPath fax = createString("fax");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath phone = createString("phone");

    public final StringPath postalCode = createString("postalCode");

    public final SetPath<Product, QProduct> products = this.<Product, QProduct>createSet("products", Product.class, QProduct.class, PathInits.DIRECT2);

    public final QRegion region;

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public final StringPath web = createString("web");

    public QSupplier(String variable) {
        this(Supplier.class, forVariable(variable), INITS);
    }

    public QSupplier(Path<? extends Supplier> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSupplier(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSupplier(PathMetadata metadata, PathInits inits) {
        this(Supplier.class, metadata, inits);
    }

    public QSupplier(Class<? extends Supplier> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.city = inits.isInitialized("city") ? new QCity(forProperty("city"), inits.get("city")) : null;
        this.country = inits.isInitialized("country") ? new QCountry(forProperty("country")) : null;
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region"), inits.get("region")) : null;
    }

}

