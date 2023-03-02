package com.atmostadam.cats.jbpm.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.kie.api.event.process.*;

@Getter
@AllArgsConstructor
public class CatProcessEvent {
    private EventType type;
    private ProcessEvent event;
    private Long processId;

    public CatProcessEvent(EventType type, ProcessStartedEvent event) {
        this(type, event, event.getProcessInstance().getId());
    }

    public CatProcessEvent(EventType type, ProcessCompletedEvent event) {
        this(type, event, event.getProcessInstance().getId());
    }

    public CatProcessEvent(EventType type, ProcessNodeTriggeredEvent event) {
        this(type, event, event.getProcessInstance().getId());
    }

    public CatProcessEvent(EventType type, ProcessNodeLeftEvent event) {
        this(type, event, event.getProcessInstance().getId());
    }

    public CatProcessEvent(EventType type, ProcessVariableChangedEvent event) {
        this(type, event, event.getProcessInstance().getId());
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
