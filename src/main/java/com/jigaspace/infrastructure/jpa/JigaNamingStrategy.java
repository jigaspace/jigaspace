package com.jigaspace.infrastructure.jpa;

import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * Own naming strategy.
 *
 * Just adds 'jiga_' prefix to all tables
 */
public class JigaNamingStrategy extends ImprovedNamingStrategy {

    private static final String TABLE_PREFIX = "jiga_";

    @Override
    public String classToTableName(String className) {
        return super.classToTableName(TABLE_PREFIX + className);
    }
}
