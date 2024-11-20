package com.taraz.workflow.service;

import org.springframework.stereotype.Component;

@Component
public class UserDepartmentService {

    public String getDepartment(){
        System.out.println("coming from getUserDepartment method of service");
        return "IT department";
    }
}
