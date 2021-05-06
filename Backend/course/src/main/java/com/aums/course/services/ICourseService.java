package com.aums.course.services;

import java.util.List;

import com.aums.course.models.Course;

public interface ICourseService {

	public List<Course> getAllCourses();
	
	public Course getCourseById(int id);
	
	public List<Course> getCourseForAdmin(int id);
	
	public List<Course> getCourseForTrainer(int id);
	
	public String updateCourse(Course course);
	
	public String deleteCourse(int id);
	
	public String addCourse(Course course);
}
