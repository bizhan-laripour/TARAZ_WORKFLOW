package com.taraz.workflow.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.stereotype.Service;

@Service
public class BpmnService {

    private final ProcessEngine processEngine;

    public BpmnService(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    public ProcessInstantiationBuilder createProcessInstantiation(String processDefinitionKey) {
        return processEngine.getRuntimeService().createProcessInstanceByKey(processDefinitionKey);
    }
}
