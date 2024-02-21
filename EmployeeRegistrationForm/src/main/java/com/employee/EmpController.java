package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpController {
	@Autowired
	private employeeRepository repo;
	
	@GetMapping("")
	//it return homepage of application
	public String viewHomePage() {
		return "index";
	}
	@GetMapping("/register")
	public String showSignUpForm(Model model ) {
		//????????
		model.addAttribute("emp", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process-register")
	public String processRegistration(User emp) {
		repo.save(emp);
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList() {
		return "users";
	}
	
}
