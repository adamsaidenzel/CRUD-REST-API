package net.denzel.RESTful.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import net.denzel.RESTful.exception.ResourceNotFoundException;
import net.denzel.RESTful.model.Employee;
import net.denzel.RESTful.repository.EmployeeRepository;
import net.denzel.RESTful.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll(); 
	}


	@Override
	public Employee getEmployeeById(long id) {
		/*
		 * Optional<Employee> employee = employeeRepository.findById(id);
		 * if(employee.isPresent()) { return employee.get(); }else { throw new
		 * ResourceNotFoundException("Employee", "Id", id); }
		 */
		
		return employeeRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Employee", "Id", id));
		
		
		
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		//we need to check weather employee with given id is exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id));
		
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		//save existing employee to database
		employeeRepository.save(existingEmployee);
		
		return null;
	}


	@Override
	public void deleteEmployee(long id) {
		
		//check whether the employee exist in db or not
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
		
	}
	

}
