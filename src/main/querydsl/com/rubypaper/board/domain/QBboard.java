package com.rubypaper.board.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBboard is a Querydsl query type for Bboard
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBboard extends EntityPathBase<Bboard> {

    private static final long serialVersionUID = -1561706595L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBboard bboard = new QBboard("bboard");

    public final QBmember bmember;

    public final NumberPath<Long> cnt = createNumber("cnt", Long.class);

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath title = createString("title");

    public QBboard(String variable) {
        this(Bboard.class, forVariable(variable), INITS);
    }

    public QBboard(Path<? extends Bboard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBboard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBboard(PathMetadata metadata, PathInits inits) {
        this(Bboard.class, metadata, inits);
    }

    public QBboard(Class<? extends Bboard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.bmember = inits.isInitialized("bmember") ? new QBmember(forProperty("bmember")) : null;
    }

}

