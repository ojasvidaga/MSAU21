package com.aums.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aums.course.models.Employee;
import com.aums.course.services.LoginService;

@RestController
@RequestMapping("api/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@GetMapping("/validateUser/{email}")
	public Employee validateUser(@PathVariable("email") String email) {
		return loginService.validateUser(email);
	}
	
	
}
