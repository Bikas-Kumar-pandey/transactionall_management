package com.transactional.eventListner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController {
    @Autowired
    private UsherPublisher usherPublisher;

    @GetMapping("/")
    public String entry(){
        return "Application Up and Running";
    }
    @GetMapping("/user/{name}/{type}")
    public User userPublisher(@PathVariable("name") String name,@PathVariable ("type")boolean type){
        User user = new User();
        user.setName(name);
        user.setAdmin(type);
        user.setStatus("Active");
        usherPublisher.userPublisher(user);
        return user;

    }



}
