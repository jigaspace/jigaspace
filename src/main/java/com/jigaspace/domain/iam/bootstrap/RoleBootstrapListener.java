package com.jigaspace.domain.iam.bootstrap;

import com.google.common.collect.Lists;
import com.jigaspace.domain.iam.model.role.Role;
import com.jigaspace.domain.iam.model.role.RoleIdentifier;
import com.jigaspace.domain.iam.model.role.RoleRepository;
import com.jigaspace.domain.iam.model.user.User;
import com.jigaspace.domain.iam.model.user.UserIdentifier;
import com.jigaspace.domain.iam.model.user.UserRepository;
import com.jigaspace.domain.shared.events.BootstrapEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class RoleBootstrapListener implements ApplicationListener<BootstrapEvent>, Ordered {
    public static final RoleIdentifier USER = new RoleIdentifier("ROLE_USER");
    public static final RoleIdentifier ADMIN = new RoleIdentifier("ROLE_ADMIN");

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(BootstrapEvent event) {
        if (roleRepository.count() > 0) {
            return;
        }
        Role user = new Role(USER, "Application User");
        Role admin = new Role(ADMIN, "Application Admin");

        roleRepository.save(Lists.newArrayList(user, admin));
        roleRepository.flush();

        User user1 = new User.Builder()
                .withFirstname("John")
                .withLastname("Smith")
                .withEmail("john@google.com")
                .withEnabled(true)
                .withIdentifier(new UserIdentifier("john@google.com"))
                .addRole(ADMIN)
                .build();
        userRepository.save(user1);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
