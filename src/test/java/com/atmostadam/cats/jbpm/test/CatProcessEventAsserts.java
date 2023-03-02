package com.atmostadam.cats.jbpm.test;

import org.kie.api.event.process.ProcessStartedEvent;

import static com.atmostadam.cats.jbpm.test.CatProcessEvent.EventType.AFTER_PROCESS_STARTED;
import static com.atmostadam.cats.jbpm.test.CatProcessEvent.EventType.BEFORE_PROCESS_STARTED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public final class CatProcessEventAsserts {
    private CatProcessEventAsserts() { }

    public static final void assertBeforeProcessStarted(CatProcessEventListener listener, String processName) {
        CatProcessEvent event = listener.nextEvent();
        assertThat(event.getEvent(), instanceOf(ProcessStartedEvent.class));
        assertThat(event.getType(), equalTo(BEFORE_PROCESS_STARTED));
        assertThat(event.getProcessName(), equalTo(processName));
    }

    public static final void assertAfterProcessStarted(CatProcessEventListener listener, String processName) {
        CatProcessEvent event = listener.nextEvent();
        assertThat(event.getEvent(), instanceOf(ProcessStartedEvent.class));
        assertThat(event.getType(), equalTo(AFTER_PROCESS_STARTED));
        assertThat(event.getProcessName(), equalTo(processName));
    }

    public static final void assertBeforeProcessCompleted() {

    }

    public static final void assertAfterProcessCompleted() {

    }

    public static final void assertBeforeNodeTriggered() {

    }

    public static final void assertAfterNodeTriggered() {

    }

    public static final void assertBeforeNodeLeft() {

    }

    public static final void assertAfterNodeLeft() {

    }

    public static final void assertBeforeVariableChanged() {

    }

    public static final void assertAfterVariableChanged() {

    }
}
