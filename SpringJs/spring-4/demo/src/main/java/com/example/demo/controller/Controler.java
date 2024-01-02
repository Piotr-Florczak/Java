package com.example.demo.controller;


import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@RestController
public class Controler {

    EmployeeRepository employeeRepository;
    public  Controler(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping("/test")
    public String testEndpoint()
    {
        return "Works! :)";
    }
    @GetMapping("/Manager")
    public String managerTestEndpoint()
    {
        return "Manager-Works! :)";
    }
    @GetMapping("/findAll")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
