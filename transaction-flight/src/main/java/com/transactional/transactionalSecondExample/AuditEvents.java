package com.transactional.transactionalSecondExample;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AuditEvents<T> extends ApplicationEvent {


    private T data;
    public AuditEvents(T event) {
        super(event);
        this.data=event;
    }
}
