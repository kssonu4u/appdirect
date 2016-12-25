package com.appdirect.web;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.appdirect.entity.Employee;
import com.appdirect.web.controller.EmployeeController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

	@Autowired
	EmployeeController employeeController;

	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee("23", "Gaurav");
		Employee employee1 = employeeController.createNewEmployee(employee);
		Assert.assertEquals(employee.getId(), employee1.getId());
	}

	@Test
	public void testgetAllEmployee() {
		List<Employee> employees = employeeController.getAllEmployees();
		Assert.assertEquals(employees.size(), 3);
	}

	@Test
	public void testgetEmployeeById() {
		Employee employee = employeeController.getEmployeeById("1");
		Assert.assertEquals(employee.getId(), "1");
	}

	@Test
	public void testupdateEmployee() {
		Employee employee = new Employee("1", "Shalini");
		Employee employee1 = employeeController.updateEmployee(employee);
		Assert.assertEquals(employee.getName(), employee1.getName());
	}

	@Test
	public void testdeletEmployee() {
		employeeController.deleteEmployee("23");
		List<Employee> employees = employeeController.getAllEmployees();
		Assert.assertEquals(employees.size(), 2);
	}

}
