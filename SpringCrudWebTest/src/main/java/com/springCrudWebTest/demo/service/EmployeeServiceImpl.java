package com.springCrudWebTest.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springCrudWebTest.demo.model.Employee;
import com.springCrudWebTest.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteEmployee(int id) {
		this.employeeRepository.deleteById(id);
		
	}

}
