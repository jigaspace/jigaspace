package com.jigaspace.infrastructure.bootstrap;

import com.jigaspace.domain.shared.events.BootstrapEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();

        if (applicationContext.getParent() == null) {
            event.getApplicationContext().publishEvent(new BootstrapEvent(applicationContext));
        }
    }
}
