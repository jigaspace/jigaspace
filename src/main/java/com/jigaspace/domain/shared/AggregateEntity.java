package com.jigaspace.domain.shared;

public interface AggregateEntity extends PersistentEntity {

    Integer getEntityVersion();
}
