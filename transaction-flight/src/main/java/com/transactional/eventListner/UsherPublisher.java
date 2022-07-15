package com.transactional.eventListner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UsherPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public String userPublisher(User user){
        UserEvent userEvent =new UserEvent(this,user);
        applicationEventPublisher.publishEvent(userEvent);
        return "Event Publisher";
    }
}
