/**
 * 
 */
package com.jeissonmgz.employee.service;

import java.util.List;

import com.jeissonmgz.employee.model.Employee;

/**
 * @author JMalaver
 *
 */
public interface EmployeeService {

    public List<Employee> findAll();

    public Employee create(Employee employee);

}
