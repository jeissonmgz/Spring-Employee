/**
 * 
 */
package com.jeissonmgz.employee.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeissonmgz.employee.model.Employee;
import com.jeissonmgz.employee.repository.EmployeeRepository;
import com.jeissonmgz.employee.service.EmployeeService;

/**
 * @author JMalaver
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
	return (List<Employee>) employeeRepository.findAll();

    }

    @Override
    public Employee create(Employee employee) {
	if (employee.getId() == null)
	    return (Employee) employeeRepository.save(employee);
	return null;
    }

}
