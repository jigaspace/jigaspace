package com.jigaspace.domain.shared.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

public class BootstrapEvent extends ApplicationEvent {
    public BootstrapEvent(ApplicationContext applicationContext) {
        super(applicationContext);
    }
}
