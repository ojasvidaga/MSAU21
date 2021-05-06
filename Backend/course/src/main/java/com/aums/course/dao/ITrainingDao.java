package com.aums.course.dao;

import java.util.List;

import com.aums.course.models.Employee;

public interface ITrainingDao {

	public String addOrUpdateTrainer(int employeeId);
	
	public String assignTrainers(int courseId,int employeeId);
	
	public String unassignTrainers(int courseId,int trainerId);
	
	public int validateTrainer(int trainerId);
	
	public String updateTrainerStatus(int trainerId);
	
	public List<Employee> getTrainersByCourseId(int courseId);

	public List<Employee> getAllEmployees();
	
}
