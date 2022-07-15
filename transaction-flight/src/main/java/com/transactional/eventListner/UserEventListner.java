package com.transactional.eventListner;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListner {//implements ApplicationListener<UserEvent> {

//condition="#root.args[0].admin"
    @EventListener(condition = "#root.args[0].admin")
    public void handleEventEvent(UserEvent event){
        System.out.println("Listener getting ::: "+event.getUser().getName());
        System.out.println("Listener getting ::: "+event.getUser().getStatus());
    }


}
