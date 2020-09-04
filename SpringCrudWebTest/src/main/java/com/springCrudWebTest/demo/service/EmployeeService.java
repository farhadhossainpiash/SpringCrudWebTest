package com.springCrudWebTest.demo.service;

import java.util.List;

import com.springCrudWebTest.demo.model.Employee;

public interface EmployeeService {
 List<Employee> getAllEmployees();
 void saveEmployee(Employee employee);
 Employee getEmployeeById(int id);
 void deleteEmployee(int id);
}
