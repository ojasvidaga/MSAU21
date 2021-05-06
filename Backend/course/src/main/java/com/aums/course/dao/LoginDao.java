package com.aums.course.dao;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aums.course.models.Employee;
import com.aums.course.queries.Queries;
import com.aums.course.rowmapper.LoginRowMapper;

@Repository
public class LoginDao implements ILoginDao {

	@Autowired
	public JdbcTemplate jdbcTemplate;
		
	public Employee validateUser(String email) {
		return jdbcTemplate.queryForObject(Queries.VALIDATE_LOGIN, LoginRowMapper.LoginRowMapperLambda, email);
	}
	
	public boolean checkAdmin(int empId) {
		int count = jdbcTemplate.queryForObject(Queries.CHECK_ADMIN, Integer.class, empId);
		return count>0;
	}
	
	public boolean checkTrainer(int empId) {
		int count = jdbcTemplate.queryForObject(Queries.CHECK_TRAINER, Integer.class, empId);
		return count>0;
	}
}
