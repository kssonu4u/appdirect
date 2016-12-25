package com.appdirect.service;

import java.util.List;

import com.appdirect.entity.Employee;

/**
 * @author saurav service defining all the CRUD operations on Employee
 *
 */
public interface EmployeeService {

	/**
	 * @return all the employees
	 */
	List<Employee> getAllEmployees();

	/**
	 * @return employee by id
	 */
	Employee getEmployeeById(String id);

	/**
	 * @param employee
	 * @return crate new employee in database
	 */
	Employee createNewEmployee(Employee employee);

	/**
	 * @param employee
	 * @return update employee in database
	 */
	Employee updateEmployee(Employee employee);

	/**
	 * @param employee
	 *            delete employee in database
	 */
	void deleteEmployee(Employee employee);

}
