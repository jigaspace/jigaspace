package com.jigaspace.domain.shared;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements PersistentEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public boolean isManaged() {
        return this.id != null;
    }
}
