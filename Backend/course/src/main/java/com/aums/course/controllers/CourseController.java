package com.aums.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aums.course.models.Course;
import com.aums.course.services.CourseService;

@RestController
@RequestMapping("api/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/all")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable("id") int id) {
		return courseService.getCourseById(id);
	}
	
	@GetMapping("/admin/{id}")
	public List<Course> getCourseForAdmin(@PathVariable("id") int id) {
		return courseService.getCourseForAdmin(id);
	}
	
	@GetMapping("/trainer/{id}")
	public List<Course> getCourseForTrainer(@PathVariable("id") int id) {
		return courseService.getCourseForTrainer(id);
	}
	
	@PostMapping("/updateCourse")
	public String updateCourse(@RequestBody Course course){
		return courseService.updateCourse(course);
	}
	
	@PostMapping("/deleteCourse")
	public String deleteCourse(@RequestBody Course course){
		return courseService.deleteCourse(course.getCourseId());
	}
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestBody Course course){
		return courseService.addCourse(course);
	}
	
}
