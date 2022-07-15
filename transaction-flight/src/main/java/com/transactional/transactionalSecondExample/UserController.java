package com.transactional.transactionalSecondExample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuditEventPublisher publisher;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        publisher.publishEvent("User save Successfully with user " + user.getUserName());
        return "User save Successfully !! ";
    }
}
