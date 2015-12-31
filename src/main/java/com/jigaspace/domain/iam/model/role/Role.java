package com.jigaspace.domain.iam.model.role;

import com.jigaspace.domain.shared.AbstractAggregateEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.AttributeOverride;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import static java.util.Objects.requireNonNull;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends AbstractAggregateEntity {

    @Embedded
    @AttributeOverride(name = RoleIdentifier.IDENTIFIER_PROPERTY, column = @Column(nullable = false, unique = true))
    private RoleIdentifier identifier;

    @Column(nullable = false)
    private String name;

    protected Role() {
    }

    public Role(RoleIdentifier identifier, String name) {
        this.identifier = requireNonNull(identifier);
        this.name = requireNonNull(name);
    }

    public RoleIdentifier getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }
}
