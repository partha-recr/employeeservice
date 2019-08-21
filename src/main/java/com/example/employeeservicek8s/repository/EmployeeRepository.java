package com.example.employeeservicek8s.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.employeeservicek8s.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	List<Employee> findByDepartmentId(Long departmentId);
	List<Employee> findByOrganizationId(Long organizationId);
	
}
