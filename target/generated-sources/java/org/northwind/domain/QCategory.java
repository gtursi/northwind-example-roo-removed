package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 2004842269L;

    public static final QCategory category = new QCategory("category");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Calendar> createdDate = createDateTime("createdDate", java.util.Calendar.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Calendar> modifiedDate = createDateTime("modifiedDate", java.util.Calendar.class);

    public final StringPath name = createString("name");

    public final SetPath<Product, QProduct> products = this.<Product, QProduct>createSet("products", Product.class, QProduct.class, PathInits.DIRECT2);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }

}

