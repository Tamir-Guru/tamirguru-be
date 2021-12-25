package com.dota.tamirguru.core.config;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.dialect.PostgreSQL94Dialect;

@SuppressWarnings("java:S110")
public class PostgreSQL94CustomDialect extends PostgreSQL94Dialect {

    public PostgreSQL94CustomDialect() {
        super();
        this.registerHibernateType(2003, StringArrayType.class.getName());
    }

}