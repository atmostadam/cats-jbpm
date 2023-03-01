package com.atmostadam.cats.jbpm.test;

import org.kie.api.event.process.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;

import java.util.LinkedList;
import java.util.List;

import static com.atmostadam.cats.jbpm.test.CatProcessEventListener.Direction.AFTER;
import static com.atmostadam.cats.jbpm.test.CatProcessEventListener.Direction.BEFORE;

public class CatProcessEventListener implements ProcessEventListener {
    Logger logger = LoggerFactory.getLogger(CatProcessEventListener.class);
    List<Pair<Direction, ? extends ProcessEvent>> events = new LinkedList<>();

    @Override
    public void beforeProcessStarted(ProcessStartedEvent event) {
        events.add(Pair.of(BEFORE, event));
    }

    @Override
    public void afterProcessStarted(ProcessStartedEvent event) {
        events.add(Pair.of(AFTER, event));
    }

    @Override
    public void beforeProcessCompleted(ProcessCompletedEvent event) {
        events.add(Pair.of(BEFORE, event));
    }

    @Override
    public void afterProcessCompleted(ProcessCompletedEvent event) {
        events.add(Pair.of(AFTER, event));
    }

    @Override
    public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
        events.add(Pair.of(BEFORE, event));
    }

    @Override
    public void afterNodeTriggered(ProcessNodeTriggeredEvent event) {
        events.add(Pair.of(AFTER, event));
    }

    @Override
    public void beforeNodeLeft(ProcessNodeLeftEvent event) {
        events.add(Pair.of(BEFORE, event));
    }

    @Override
    public void afterNodeLeft(ProcessNodeLeftEvent event) {
        events.add(Pair.of(AFTER, event));
    }

    @Override
    public void beforeVariableChanged(ProcessVariableChangedEvent event) {
        events.add(Pair.of(BEFORE, event));
    }

    @Override
    public void afterVariableChanged(ProcessVariableChangedEvent event) {
        events.add(Pair.of(AFTER, event));
    }

    @Override
    public void beforeSLAViolated(SLAViolatedEvent event) {
        ProcessEventListener.super.beforeSLAViolated(event);
        events.add(Pair.of(BEFORE, event));
    }

    @Override
    public void afterSLAViolated(SLAViolatedEvent event) {
        ProcessEventListener.super.afterSLAViolated(event);
        events.add(Pair.of(AFTER, event));
    }

    @Override
    public void onSignal(SignalEvent event) {
        ProcessEventListener.super.onSignal(event);
    }

    @Override
    public void onMessage(MessageEvent event) {
        ProcessEventListener.super.onMessage(event);
    }

    @Override
    public void onAsyncNodeScheduledEvent(ProcessAsyncNodeScheduledEvent event) {
        ProcessEventListener.super.onAsyncNodeScheduledEvent(event);
    }

    public enum Direction { // TODO: Use EventType corresponding to method name
        BEFORE,
        AFTER
    }
}
