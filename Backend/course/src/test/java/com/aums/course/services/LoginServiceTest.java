package com.aums.course.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.aums.course.dao.LoginDao;
import com.aums.course.models.Employee;


@SpringBootTest()
public class LoginServiceTest {

	@InjectMocks
	private LoginService loginService;

	@Mock
	private LoginDao loginDao;
	
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
		Mockito.when(loginDao.validateUser("omkar.ravindraraykar@accoliteindia.com")).thenReturn(emp);
		assertEquals(emp,loginService.validateUser("omkar.ravindraraykar@accoliteindia.com"));
		
		Mockito.when(loginDao.checkAdmin(1)).thenReturn(true);
		assertEquals(emp,loginService.validateUser("omkar.ravindraraykar@accoliteindia.com"));
		
		Mockito.when(loginDao.checkTrainer(1)).thenReturn(true);
		assertEquals(emp,loginService.validateUser("omkar.ravindraraykar@accoliteindia.com"));
		
	}

	
	
}
