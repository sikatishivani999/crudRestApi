package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee updateEmployee(Employee employee,int id);
	
	Employee getEmployee(int id);
	
	void deleteEmployee(int id);

}
