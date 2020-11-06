package com.arn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
