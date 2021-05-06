package com.aums.course.dao;

import java.util.List;

import com.aums.course.models.Course;

public interface ICourseDao {

	public List<Course> getAllCourses();
	
	public Course getCourseById(int id);
	
	public List<Course> getCourseForAdmin(int id);
	
	public List<Course> getCourseForTrainer(int id);
	
	public String updateCourse(Course course);
	
	public String deleteCourse(int id);
	
	public String addCourse(Course course);

}
