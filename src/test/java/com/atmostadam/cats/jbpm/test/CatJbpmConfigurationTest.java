package com.atmostadam.cats.jbpm.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

@ComponentScan(basePackages = {"com.atmostadam.cats.jbpm", "com.atmostadam.cats.kjar"})
@TestConfiguration
public class CatJbpmConfigurationTest {
    @Value("${build.properties.group:com.atmostadam.cats}")
    private String group;

    @Value("${build.properties.artifact:cats-kjar}")
    private String artifact;

    @Value("${build.properties.version:0.0.10}")
    private String version;

    @Bean(name = "buildProperties")
    @ConditionalOnMissingBean(name = "buildProperties")
    @ConfigurationProperties(prefix = "build.properties")
    public BuildProperties buildProperties() {
        Properties properties = new Properties();
        properties.setProperty("group", group);
        properties.setProperty("artifact", artifact);
        properties.setProperty("version", version);
        return new BuildProperties(properties);
    }
}
