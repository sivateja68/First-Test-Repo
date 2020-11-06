package com.arn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arn.model.Employee;
import com.arn.repository.EmployeeRepository;
import com.arn.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmp(Employee emp) {
		return repo.save(emp).getId();
	}

	@Override
	public void update(Employee emp) {
		repo.save(emp);
	}

	@Override
	public void delete(Integer id) {
			repo.deleteById(id);
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> list = repo.findAll();
		return list;
	}

	@Override
	public Optional<Employee> getOne(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		return opt;
	}

	@Override
	public boolean isExist(Integer id) {
		boolean exist = repo.existsById(id);
		return exist;
	}

}
