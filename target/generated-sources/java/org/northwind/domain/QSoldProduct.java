package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSoldProduct is a Querydsl query type for SoldProduct
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSoldProduct extends EntityPathBase<SoldProduct> {

    private static final long serialVersionUID = -20039940L;

    public static final QSoldProduct soldProduct = new QSoldProduct("soldProduct");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QSoldProduct(String variable) {
        super(SoldProduct.class, forVariable(variable));
    }

    public QSoldProduct(Path<? extends SoldProduct> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSoldProduct(PathMetadata metadata) {
        super(SoldProduct.class, metadata);
    }

}

