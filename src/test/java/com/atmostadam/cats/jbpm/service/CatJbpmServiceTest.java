package com.atmostadam.cats.jbpm.service;

import com.atmostadam.cats.api.model.in.CatRequest;
import com.atmostadam.cats.api.model.out.CatResponse;
import com.atmostadam.cats.jbpm.test.CatJbpmConfigurationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static com.atmostadam.cats.test.data.CatTestData.staticCatRequest;
import static com.atmostadam.cats.test.data.CatTestData.staticCatResponse;

//@SpringJUnitConfig({CatJbpmConfigurationTest.class})
class CatJbpmServiceTest {
    //@Autowired
    CatJbpmService service;

    @Test
    void testFireAllRules() throws Exception {
        CatRequest catRequest = staticCatRequest();
        CatResponse catResponse = staticCatResponse();

    }
}
