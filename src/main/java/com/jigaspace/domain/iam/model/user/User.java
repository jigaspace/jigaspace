package com.jigaspace.domain.iam.model.user;

import com.jigaspace.domain.iam.model.role.RoleIdentifier;
import com.jigaspace.domain.shared.AbstractAggregateEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.AttributeOverride;
import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends AbstractAggregateEntity {

    @Embedded
    @AttributeOverride(name = UserIdentifier.IDENTIFIER_PROPERTY, column = @Column(nullable = false, unique = true))
    private UserIdentifier identifier;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private Boolean enabled;

    @CollectionTable(name = "jiga_user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role_identifier")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<RoleIdentifier> roles = new HashSet<>();

    protected User() {
    }

    protected User(Builder builder) {
        this.identifier = requireNonNull(builder.identifier);
        this.email = requireNonNull(builder.email);
        this.firstname = requireNonNull(builder.firstname);
        this.lastname = requireNonNull(builder.lastname);

        if (builder.fullname != null) {
            this.fullname = builder.fullname;
        } else {
            this.fullname = String.format("%s %s", firstname, lastname);
        }

        if (builder.enabled != null) {
            this.enabled = builder.enabled;
        } else {
            this.enabled = Boolean.TRUE;
        }

        this.roles.addAll(builder.roles);
    }

    public UserIdentifier getIdentifier() {
        return identifier;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void disable() {
        checkState(isEnabled());
        enabled = Boolean.FALSE;
    }

    public void enable() {
        checkState(isDisabled());
        enabled = Boolean.TRUE;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public Boolean isDisabled() {
        return !enabled;
    }

    public Set<RoleIdentifier> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

    public static class Builder {

        private UserIdentifier identifier;

        private String email;

        private String firstname;

        private String lastname;

        private String fullname;

        private Boolean enabled;

        private Set<RoleIdentifier> roles = new HashSet<>();

        public Builder withIdentifier(UserIdentifier identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder withFullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder withEnabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder addRole(RoleIdentifier role) {
            this.roles.add(role);
            return this;
        }

        public Builder addRoles(Set<RoleIdentifier> roles) {
            this.roles.addAll(roles);
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
