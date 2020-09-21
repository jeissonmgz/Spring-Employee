package com.jeissonmgz.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeissonmgz.employee.model.Employee;
import com.jeissonmgz.employee.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<?> index() {
	try {
	    return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.OK);
	} catch (Exception ex) {
	    return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody(required = true) Employee employee) {
	try {
	    return new ResponseEntity<Employee>(employeeService.create(employee), HttpStatus.CREATED);
	} catch (Exception ex) {
	    System.out.println(ex.getMessage() + " - " + employee);
	    return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

    }
}