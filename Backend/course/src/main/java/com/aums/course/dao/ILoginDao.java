package com.aums.course.dao;

import com.aums.course.models.Employee;

public interface ILoginDao {

	public Employee validateUser(String email);
	
	public boolean checkAdmin(int empId);
	
	public boolean checkTrainer(int empId);
	
}
