/**
 * 
 */
package com.jeissonmgz.employee.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.jeissonmgz.employee.model.DocumentType;
import com.jeissonmgz.employee.model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void givenSetOfEmployees_whenFindAll_thenReturnAllEmployees() {
	Employee alex = createTestEmployee("987", "alex");
	Employee ron = createTestEmployee("765", "ron");
	Employee bob = createTestEmployee("321", "bob");

	entityManager.persist(alex);
	entityManager.persist(bob);
	entityManager.persist(ron);
	entityManager.flush();

	List<Employee> allEmployees = (List<Employee>) employeeRepository.findAll();

	assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(),
		bob.getName());
    }

    private Employee createTestEmployee(String documentNumber, String name) {
	Employee employee = new Employee();
	employee.setDocumentType(DocumentType.CEDULA);
	employee.setDocumentNumber(documentNumber);
	employee.setName(name);
	employee.setLastName("Perez");
	return employee;
    }
}