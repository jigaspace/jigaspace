package com.jigaspace.domain.iam.model.role;

import com.jigaspace.domain.shared.AbstractValueObject;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

import static java.util.Objects.requireNonNull;

@Embeddable
@Access(AccessType.FIELD)
public class RoleIdentifier extends AbstractValueObject {

    public static final String IDENTIFIER_PROPERTY = "identifier";

    private String identifier;

    protected RoleIdentifier() {
    }

    public RoleIdentifier(String identifier) {
        this.identifier = requireNonNull(identifier);
    }

    public String getIdentifier() {
        return identifier;
    }
}
