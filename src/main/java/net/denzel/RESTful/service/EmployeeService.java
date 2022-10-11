package net.denzel.RESTful.service;

import java.util.List;

import net.denzel.RESTful.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee,long id);
	void deleteEmployee(long id);
	

}
