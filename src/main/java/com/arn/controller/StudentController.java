package com.arn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.arn.model.Student;
import com.arn.service.IStudentService;

@Controller

public class StudentController {

	@Autowired
	private IStudentService service;
	
	@GetMapping("/register")
	public String showReg(Model model) {
		model.addAttribute("stu", new Student());
		return "StudentRegister";
	}
	
	@PostMapping("/create")
	public String saveStu(
			@ModelAttribute Student stu,
			Model model
			) 
	{
		Integer id = service.saveStudent(stu);
		String msg =  "Student'"+ id+"'saved ";
		model.addAttribute("stu", new Student());
		model.addAttribute("msg", msg);
		return "StudentRegister";
	}
	//emp     ---> EmployeePage.html  
	

}
