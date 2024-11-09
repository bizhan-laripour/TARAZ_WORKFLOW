package com.taraz.workflow.controller;


import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/execute")
    public ResponseEntity<?> execute() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder processBuilder = processEngine.getRuntimeService().createProcessInstanceByKey("first_bpmn_id");
        String item = "computer";
        processBuilder.setVariable("itemName", item);
        processBuilder.businessKey("execute-endpoint");
        processBuilder.executeWithVariablesInReturn();
        return ResponseEntity.ok("BPMN Execution Completed");
    }

    @GetMapping("/script")
    public ResponseEntity<?> script() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder processBuilder = processEngine.getRuntimeService().createProcessInstanceByKey("initialize_user_object");
        processBuilder.executeWithVariablesInReturn();
        return ResponseEntity.ok("BPMN Execution Completed");
    }

}
