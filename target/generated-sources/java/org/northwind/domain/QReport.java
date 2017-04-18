package org.northwind.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReport is a Querydsl query type for Report
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReport extends EntityPathBase<Report> {

    private static final long serialVersionUID = -2036397293L;

    public static final QReport report = new QReport("report");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath type = createString("type");

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QReport(String variable) {
        super(Report.class, forVariable(variable));
    }

    public QReport(Path<? extends Report> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReport(PathMetadata metadata) {
        super(Report.class, metadata);
    }

}

