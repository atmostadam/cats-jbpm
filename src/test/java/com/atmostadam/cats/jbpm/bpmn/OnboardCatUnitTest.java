package com.atmostadam.cats.jbpm.bpmn;

import com.atmostadam.cats.jbpm.process.CatJbpmWorkItemHandler;
import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.process.ProcessInstance;

public class OnboardCatUnitTest extends JbpmJUnitBaseTestCase {
    public OnboardCatUnitTest() {
        super(false, false);
    }

    @Test
    void onboardCat() {
        createRuntimeManager("onboard_cat.bpmn2");

        RuntimeEngine runtimeEngine = getRuntimeEngine();

        KieSession ksession = runtimeEngine.getKieSession();

        CatJbpmWorkItemHandler handler = new CatJbpmWorkItemHandler(ksession);

        ksession.getWorkItemManager().registerWorkItemHandler("CatTask", handler);

        ProcessInstance processInstance = ksession.startProcess("onboard_cat");


        assertProcessInstanceNotActive(processInstance.getId(), ksession);


        assertNodeTriggered(processInstance.getId(),
                "Start",
                "Microchip Number Lookup",
                "Register New Cat",
                "Find Foster With Availability",
                "List Cat on Petfinder",
                "List Cat on Adopt-a-Pet",
                "End");
    }
}
