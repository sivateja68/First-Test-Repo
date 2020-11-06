package com.arn.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.arn.model.Student;
import com.arn.repository.StudentRepository;
import com.arn.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService,UserDetailsService {

	@Autowired
	private StudentRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;


	@Override
	public Integer saveStudent(Student stu) {
		String pwd = encoder.encode(stu.getPassword());
		stu.setPassword(pwd);
		Integer id = repo.save(stu).getId();
		return id;
	}
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Optional<Student> opt = repo.findByEmail(username);
		if(opt.isEmpty())
			throw new UsernameNotFoundException("Student not Found");
		Student stu = opt.get();
		
		
		return new User(username,stu.getPassword(), stu
				.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toSet()));
	}

}
