/**
 * 
 */
package com.jeissonmgz.employee.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.jeissonmgz.employee.model.DocumentType;
import com.jeissonmgz.employee.model.Employee;
import com.jeissonmgz.employee.repository.EmployeeRepository;
import com.jeissonmgz.employee.service.EmployeeService;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
	@Bean
	public EmployeeService employeeService() {
	    return new EmployeeServiceImpl();
	}
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {

	Employee pepitoPerez = new Employee();
	pepitoPerez.setDocumentType(DocumentType.CEDULA);
	pepitoPerez.setDocumentNumber("123");
	pepitoPerez.setName("Peipito");
	pepitoPerez.setLastName("Perez");

	List<Employee> allEmployees = Arrays.asList(pepitoPerez);

	Mockito.when(employeeRepository.findAll()).thenReturn(allEmployees);
    }

    @Test
    public void whenListEmployee_thenEmployeeShouldBeFound() {
	List<Employee> found = employeeService.findAll();
	assertThat(found.size()).isEqualTo(1);
    }

}