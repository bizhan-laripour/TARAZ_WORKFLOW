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
    public ResponseEntity<?> execute(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder processBuilder = processEngine.getRuntimeService().createProcessInstanceByKey("first_bpmn_id");
        processBuilder.executeWithVariablesInReturn();
        return ResponseEntity.ok("OK");
    }

}
