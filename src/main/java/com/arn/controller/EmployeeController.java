package com.arn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arn.model.Employee;
import com.arn.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/empregister")
	public String showEmp(Model model) {
		model.addAttribute("emp", new Employee());
		return "EmployeePage";
	}
	
	@PostMapping("/saveemp")
	public String saveEmp(@ModelAttribute Employee emp,
			Model model) {
		Integer id = service.saveEmp(emp);
		String msg =  "Employee' "+ id +" 'saved ";
		model.addAttribute("emp", new Employee());
		model.addAttribute("msg", msg);
		
		return "EmployeePage";
	}
	
	@GetMapping("/emp")
	public String findAll(Model model) {
		List<Employee> list = service.getAll();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	//common  ---> CommonPage.html 
	@GetMapping("/common")
	public String showCommon() {
		return "CommonPage";
	}
	
	//denied  ---> AccessDenied.html
	@GetMapping("/denied")
	public String showDenied() {
		return "AccessDenied";
	}
	
	@GetMapping("/editemp/{id}")
	public String editEmployee(@PathVariable Integer id,
			Model model) {
		
		String page = null;
			Optional<Employee> opt = service.getOne(id);
		if(opt.isPresent()) {
			Employee emp = opt.get();
			model.addAttribute("emp", emp);
			page="EmployeeEdit";
		}else {
			String msg = "Employee '"+ id+"' is not Exist";
			model.addAttribute("msg", msg);
			page="redirect:../emp";
		}
		return page;
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Employee emp
			,Model model) {
		
				service.update(emp);
				String msg = "Employee'"+emp.getId()+"' updated!";
				model.addAttribute("msg", msg);
				
			List<Employee> list = 	service.getAll();
			model.addAttribute("list", list);
			
		return "EmployeeData";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id,Model model) {
		 service.delete(id);
		 String msg = "Employee '"+ id+"' deleted!";
		 model.addAttribute("msg", msg);
		 
		 List<Employee> list = 	service.getAll();
		 model.addAttribute("list", list);
		return "EmployeeData";
	}
}
