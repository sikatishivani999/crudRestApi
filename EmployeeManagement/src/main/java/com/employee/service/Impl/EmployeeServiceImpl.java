package com.employee.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepositry;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepositry employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepositry employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	@Override
	public List<Employee> getAllEmployee(){
		return employeeRepo.findAll();
	}
	
	@Override
	public Employee getEmployee(int id) {
		return employeeRepo.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Employee", "Id", id));
	}
	
	@Override
	public Employee updateEmployee(Employee employee, int id) {
		
		Employee extistsingEmployee = employeeRepo.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Employee", "Id", id));
		
		extistsingEmployee.setName(employee.getName());
		extistsingEmployee.setEmail(employee.getEmail());
		extistsingEmployee.setContact(employee.getContact());
		
		employeeRepo.save(extistsingEmployee);
		
		return extistsingEmployee;
	}
	
	
	@Override
	public void deleteEmployee(int id) {
		
		// check whether a employee exist in a DB or not
		employeeRepo.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Employee", "Id", id));
		employeeRepo.deleteById(id);
	}
	
	
	
}
