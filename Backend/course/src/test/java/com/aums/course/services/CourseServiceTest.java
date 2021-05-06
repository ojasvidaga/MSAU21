package com.aums.course.services;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.aums.course.dao.CourseDao;
import com.aums.course.models.Course;

@SpringBootTest()
public class CourseServiceTest {

	@InjectMocks
	private CourseService courseService;

	@Mock
	private CourseDao courseDao;

	Course course1 = new Course();
	Course course2 = new Course();
	List<Course> courses = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		
	
		course1.setCourseId(1);
		course1.setCourseAdminId(1);
		course1.setCourseDescription("Front End Library");
		course1.setCourseLocation("Bangalore");
		course1.setCourseName("React JS");
		course1.setCoursePrerequisites("JavaScript");
		course1.setCourseSkills("FrontEnd");
		
		course2.setCourseId(2);
		course2.setCourseAdminId(1);
		course2.setCourseDescription("Back End Framework");
		course2.setCourseLocation("Mumbai");
		course2.setCourseName("Spring MVC");
		course2.setCoursePrerequisites("Java");
		course2.setCourseSkills("APIs");
		
		courses.add(course1);
		courses.add(course2);
		
	}
	
	@Test
	public void getAllCourses() {
		Mockito.when(courseDao.getAllCourses()).thenReturn(courses);
		assertEquals(courses,courseService.getAllCourses());
	}

	@Test
	public void getCourseById() {
		Mockito.when(courseDao.getCourseById(1)).thenReturn(course1);
		assertEquals(course1,courseService.getCourseById(1));
	}

	@Test
	public void getCourseForAdmin() {
		Mockito.when(courseDao.getCourseForAdmin(1)).thenReturn(courses);
		assertEquals(courses,courseService.getCourseForAdmin(1));
	}

	@Test
	public void getCourseForTrainer() {
		Mockito.when(courseDao.getCourseForTrainer(1)).thenReturn(courses);
		assertEquals(courses,courseService.getCourseForTrainer(1));
	}

	@Test
	public void updateCourse() {
		Mockito.when(courseDao.updateCourse(course1)).thenReturn("Course Updated Successfully");
		assertEquals("Course Updated Successfully",courseService.updateCourse(course1));
	}

	@Test
	public void deleteCourse() {
		Mockito.when(courseDao.deleteCourse(1)).thenReturn("Course Deleted Successfully");
		assertEquals("Course Deleted Successfully",courseService.deleteCourse(1));
	}

	@Test
	public void addCourse() {
		Mockito.when(courseDao.addCourse(course1)).thenReturn("Course Added Successfully");
		assertEquals("Course Added Successfully",courseService.addCourse(course1));
	}

}
