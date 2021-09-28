package com.rubypaper.board.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBmember is a Querydsl query type for Bmember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBmember extends EntityPathBase<Bmember> {

    private static final long serialVersionUID = -862236477L;

    public static final QBmember bmember = new QBmember("bmember");

    public final ListPath<Bboard, QBboard> bboardList = this.<Bboard, QBboard>createList("bboardList", Bboard.class, QBboard.class, PathInits.DIRECT2);

    public final BooleanPath enabled = createBoolean("enabled");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public QBmember(String variable) {
        super(Bmember.class, forVariable(variable));
    }

    public QBmember(Path<? extends Bmember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBmember(PathMetadata metadata) {
        super(Bmember.class, metadata);
    }

}

