package com.appdirect.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.appdirect.entity.Employee;

/**
 * @author saurav Repository for performing CRUD operations
 *
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	/**
	 * @return employee by id
	 */
	Employee findById(String id);

}
