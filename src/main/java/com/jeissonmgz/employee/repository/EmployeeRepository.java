/**
 * 
 */
package com.jeissonmgz.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.jeissonmgz.employee.model.Employee;

/**
 * @author JMalaver
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
