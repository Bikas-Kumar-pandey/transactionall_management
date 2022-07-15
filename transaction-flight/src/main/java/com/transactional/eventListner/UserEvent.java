package com.transactional.eventListner;


import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {
    private User user;
    private final boolean admin;


    public UserEvent(Object obj, User user) {
        super(obj);
        this.user = user;
        this.admin=user.isAdmin();

    }

    public User getUser(){
        return user;
    }
    public boolean isAdmin(){
        return admin;
    }
}
