package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParty is a Querydsl query type for Party
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParty extends EntityPathBase<Party> {

    private static final long serialVersionUID = -67654361L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParty party = new QParty("party");

    public final StringPath address = createString("address");

    public final QCity city;

    public final QCountry country;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath phone = createString("phone");

    public final StringPath postalCode = createString("postalCode");

    public final QRegion region;

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QParty(String variable) {
        this(Party.class, forVariable(variable), INITS);
    }

    public QParty(Path<? extends Party> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParty(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParty(PathMetadata metadata, PathInits inits) {
        this(Party.class, metadata, inits);
    }

    public QParty(Class<? extends Party> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.city = inits.isInitialized("city") ? new QCity(forProperty("city"), inits.get("city")) : null;
        this.country = inits.isInitialized("country") ? new QCountry(forProperty("country")) : null;
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region"), inits.get("region")) : null;
    }

}

