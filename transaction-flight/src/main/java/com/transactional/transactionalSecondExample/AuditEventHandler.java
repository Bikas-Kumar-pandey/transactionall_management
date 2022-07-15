package com.transactional.transactionalSecondExample;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AuditEventHandler {
@SneakyThrows
@EventListener
@Async
    public void auditEvent(AuditEvents<LogData> auditEvents){
        //3rs Api call

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(auditEvents.getData()));
    }
}
