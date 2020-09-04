package com.springCrudWebTest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springCrudWebTest.demo.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
