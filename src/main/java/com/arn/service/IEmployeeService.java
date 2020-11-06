package com.arn.service;

import java.util.List;
import java.util.Optional;

import com.arn.model.Employee;


public interface IEmployeeService {
	
	Integer saveEmp(Employee emp);
	
	void update(Employee emp);
	
	void delete(Integer id);
	
	List<Employee> getAll();
	
	Optional<Employee> getOne(Integer id);
	
	boolean isExist(Integer id);
	

}
