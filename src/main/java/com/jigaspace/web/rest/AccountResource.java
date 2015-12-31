package com.jigaspace.web.rest;

import com.jigaspace.domain.iam.model.user.User;
import com.jigaspace.domain.iam.model.user.UserIdentifier;
import com.jigaspace.domain.iam.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountResource {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user/{id:[0-9]+}", method = RequestMethod.GET)
    public ResponseEntity<User> user(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userRepository.findOne(id));
    }

    @RequestMapping(value = "/user/identifier/{identifier:.+}", method = RequestMethod.GET)
    public ResponseEntity<User> user(@PathVariable("identifier") String identifier) {
        System.out.println(identifier);
        return ResponseEntity.ok(userRepository.findByIdentifier(new UserIdentifier(identifier)));
    }
}
