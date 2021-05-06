package com.aums.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aums.course.dao.CourseDao;
import com.aums.course.models.Course;

@Service
public class CourseService implements ICourseService {

	@Autowired
	CourseDao courseDao;
	
	@Override
	public List<Course> getAllCourses() {
		return courseDao.getAllCourses();
	}
	
	@Override
	public Course getCourseById(int id) {
		return courseDao.getCourseById(id);
	}
	
	@Override
	public List<Course> getCourseForAdmin(int id) {
		return courseDao.getCourseForAdmin(id);
	}
	
	@Override
	public List<Course> getCourseForTrainer(int id) {
		return courseDao.getCourseForTrainer(id);
	}
	
	@Override
	public String updateCourse(Course course) {	
		return courseDao.updateCourse(course);
	}
	
	@Override
	public String deleteCourse(int id) {
		return courseDao.deleteCourse(id);
	}
	
	@Override
	public String addCourse(Course course) {
		return courseDao.addCourse(course);
	}
	
}
