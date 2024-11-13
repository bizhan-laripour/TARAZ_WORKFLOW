package com.taraz.workflow.controller;


import com.taraz.workflow.service.BpmnService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final BpmnService bpmnService;

    public HomeController(BpmnService bpmnService) {
        this.bpmnService = bpmnService;
    }

    @GetMapping("/execute")
    public ResponseEntity<?> execute() {
        ProcessInstantiationBuilder processBuilder = bpmnService.createProcessInstantiation("first_bpmn_id");
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
        processBuilder.businessKey("script-endpoint");
        processBuilder.executeWithVariablesInReturn();
        return ResponseEntity.ok("BPMN Execution Completed");
    }

}
