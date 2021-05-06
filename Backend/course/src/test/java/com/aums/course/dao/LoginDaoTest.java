package com.aums.course.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aums.course.models.Course;
import com.aums.course.models.Employee;
import com.aums.course.queries.Queries;
import com.aums.course.rowmapper.CourseRowMapper;
import com.aums.course.rowmapper.LoginRowMapper;
import com.aums.course.services.LoginService;

@SpringBootTest()
public class LoginDaoTest {
	
	@Mock
    private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
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
		when(jdbcTemplate.queryForObject(Queries.VALIDATE_LOGIN, LoginRowMapper.LoginRowMapperLambda, "omkar.ravindraraykar@accoliteindia.com")).thenReturn(emp);
		assertEquals(emp,loginDao.validateUser("omkar.ravindraraykar@accoliteindia.com"));
	}
	
	@Test
	public void checkAdmin() {
		when(jdbcTemplate.queryForObject(Queries.CHECK_ADMIN, Integer.class, 1)).thenReturn(1);
		assertEquals(true,loginDao.checkAdmin(1));
	}
	
	@Test
	public void checkTrainer() {
		when(jdbcTemplate.queryForObject(Queries.CHECK_TRAINER, Integer.class, 1)).thenReturn(1);
		assertEquals(true,loginDao.checkTrainer(1));
	}
	
}
