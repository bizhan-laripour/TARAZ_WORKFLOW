package com.taraz.workflow.config;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaConfig {

    @Bean
    public ProcessEngine processEngine() {
        return ProcessEngines.getDefaultProcessEngine();
    }
}
