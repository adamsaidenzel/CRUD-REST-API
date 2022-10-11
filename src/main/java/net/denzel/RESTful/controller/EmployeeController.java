package net.denzel.RESTful.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import net.denzel.RESTful.model.Employee;
import net.denzel.RESTful.repository.EmployeeRepository;
import net.denzel.RESTful.service.EmployeeService;

@RestController
@RequestMapping("/denzel/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody  Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		
	}
	
	
	//build create employees REST API
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//build get employee by id REST API
	//http://loclalhost:8080/denzel/employees/id
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long  employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
		
		
	}
	
	//build update employee REST API
	//http://localhost:8080/denzel/employees
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
		
	}
	//build delete employee REST API
	//http://localhost:8080/denzel/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted Sucessfully!.", HttpStatus.OK);
		
	}
}
	
	