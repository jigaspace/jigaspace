package com.jigaspace.domain.shared;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DomainRepository<T extends AggregateEntity> extends JpaRepository<T, Long> {
}
