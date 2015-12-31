package com.jigaspace.domain.shared;

import com.jigaspace.domain.shared.events.Event;
import com.jigaspace.domain.shared.events.EventPublisher;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class AbstractAggregateEntity extends AbstractEntity implements AggregateEntity {

    @Version
    private Integer entityVersion;

    @Override
    public Integer getEntityVersion() {
        return entityVersion;
    }

    protected void publish(Event event) {
        EventPublisher.publish(event);
    }
}
