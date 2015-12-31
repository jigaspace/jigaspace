package com.jigaspace.domain.iam.model.role;

import com.jigaspace.domain.shared.DomainRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;

import static org.hibernate.jpa.QueryHints.*;

public interface RoleRepository extends DomainRepository<Role> {

    @QueryHints(@QueryHint(name = HINT_CACHEABLE, value = "true"))
    Role findByIdentifier(RoleIdentifier identifier);
}
