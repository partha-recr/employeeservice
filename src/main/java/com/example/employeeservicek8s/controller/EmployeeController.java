package com.example.employeeservicek8s.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservicek8s.model.Employee;
import com.example.employeeservicek8s.repository.EmployeeRepository;


@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository repository;
	
	@PostMapping("/")
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Employee add: {}", employee);
		return repository.save(employee);
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") String id) {
		LOGGER.info("Employee find: id={}", id);
		return "Hello Root" + id;//repository.findById(id).get();
	}
	
	@GetMapping("/all")
	public Iterable<Employee> findAll() {
		LOGGER.info("Employee find");
		return repository.findAll();
	}
	
	@GetMapping("/department/{departmentId}")
	public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
		LOGGER.info("Employee find: departmentId={}", departmentId);
		return repository.findByDepartmentId(departmentId);
	}
	
	@GetMapping("/organization/{organizationId}")
	public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Employee find: organizationId={}", organizationId);
		return repository.findByOrganizationId(organizationId);
	}
	@GetMapping("/")
	public String health() {
		LOGGER.info("Employee find");
		return "Hello Home Page EMP";
	}
	@GetMapping("/emp")
	public String getStringFromEmployee() {		
		return "GetStringFromEmployee";
	}
}
