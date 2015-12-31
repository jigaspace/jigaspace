package com.jigaspace.domain.iam.model.user;

import com.jigaspace.domain.shared.DomainRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;

public interface UserRepository extends DomainRepository<User> {
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true"))
    User findByIdentifier(UserIdentifier identifier);
}
