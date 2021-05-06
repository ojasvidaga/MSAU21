package com.aums.course.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.aums.course.models.Employee;
import com.aums.course.services.LoginService;

@SpringBootTest()
public class LoginControllerTest {
	
	@InjectMocks
	private LoginController loginController;

	@Mock
	private LoginService loginService;
	
	Employee emp = new Employee();
	
	@BeforeEach
	public void init() {
		
		emp.setEmpId(1);
		emp.setEmpEmail("omkar.ravindraraykar@accoliteindia.com");
		emp.setEmpDesignation("SDE");
		emp.setEmpLocation("Mumbai");
		emp.setEmpName("Omkar Raykar");
	}
	
	@Test
	public void validateUser() {
		Mockito.when(loginService.validateUser("omkar.ravindraraykar@accoliteindia.com")).thenReturn(emp);
		assertEquals(emp,loginController.validateUser("omkar.ravindraraykar@accoliteindia.com"));
	}

}
