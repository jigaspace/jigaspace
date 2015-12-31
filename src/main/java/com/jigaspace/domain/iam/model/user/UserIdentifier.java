package com.jigaspace.domain.iam.model.user;

import com.jigaspace.domain.shared.AbstractValueObject;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

import static java.util.Objects.requireNonNull;

@Embeddable
@Access(AccessType.FIELD)
public class UserIdentifier extends AbstractValueObject {

    public static final String IDENTIFIER_PROPERTY = "identifier";

    private String identifier;

    protected UserIdentifier() {
    }

    public UserIdentifier(String identifier) {
        this.identifier = requireNonNull(identifier);
    }

    public String getIdentifier() {
        return identifier;
    }

}
