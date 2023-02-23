package com.atmostadam.cats.jbpm.configuration;

import com.atmostadam.cats.api.configuration.CatWebClientProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;


@PropertySource("classpath:application.properties")
@EnableConfigurationProperties(CatWebClientProperties.class)
@Configuration
public class CatJbpmConfiguration {
    private static final String DEFAULT_GROUP = "com.atmostadam.cats";
    private static final String DEFAULT_ARTIFACT = "cats-kjar";
    private static final String DEFAULT_VERSION = "0.0.42";

    @Bean(name = "buildProperties")
    public BuildProperties buildProperties() {
        Properties properties = new Properties();
        properties.setProperty("group", DEFAULT_GROUP);
        properties.setProperty("artifact", DEFAULT_ARTIFACT);
        properties.setProperty("version", DEFAULT_VERSION);
        return new BuildProperties(properties);
    }
}
