package com.atmostadam.cats.jbpm.configuration;

import com.atmostadam.cats.jbpm.service.CatJbpmService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = "com.atmostadam.cats")
@TestConfiguration
public class CatJbpmTestConfiguration {
}
