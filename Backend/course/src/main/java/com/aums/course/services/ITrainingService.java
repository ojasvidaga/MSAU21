package com.aums.course.services;

import java.util.List;

import javax.mail.MessagingException;

import com.aums.course.models.Email;
import com.aums.course.models.Employee;

public interface ITrainingService {

	public String assignTrainers(int courseId, int employeeId);
	
	public String unassignTrainers(int courseId, int trainerId);
	
	public List<Employee> getTrainersByCourseId(int courseId);

	public List<Employee> getAllEmployees();

	public String sendMail(Email obj) throws MessagingException;
	
}
