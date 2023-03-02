package com.atmostadam.cats.jbpm.test;

import lombok.Getter;
import org.kie.api.event.process.ProcessEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class CatProcessEvent {
    Logger logger = LoggerFactory.getLogger(CatProcessEventListener.class);
    private final EventType type;
    private final ProcessEvent event;

    public CatProcessEvent(EventType type, ProcessEvent event) {
        this.type = type;
        this.event = event;
        logger.info("JBPM Event [{}]: [{}]", type, event);
    }

    public String getProcessName() {
        return event.getProcessInstance().getProcessId();
    }

    public enum EventType {
        BEFORE_PROCESS_STARTED,
        AFTER_PROCESS_STARTED,
        BEFORE_PROCESS_COMPLETED,
        AFTER_PROCESS_COMPLETED,
        BEFORE_NODE_TRIGGERED,
        AFTER_NODE_TRIGGERED,
        BEFORE_NODE_LEFT,
        AFTER_NODE_LEFT,
        BEFORE_VARIABLE_CHANGED,
        AFTER_VARIABLE_CHANGED
    }
}
