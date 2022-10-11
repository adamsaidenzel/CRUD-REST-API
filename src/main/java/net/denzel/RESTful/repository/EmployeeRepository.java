package net.denzel.RESTful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.denzel.RESTful.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
