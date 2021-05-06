package com.aums.course.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aums.course.models.Course;
import com.aums.course.queries.Queries;
import com.aums.course.rowmapper.CourseRowMapper;

@SpringBootTest()
public class CourseDaoTest {
	
	@Mock
    private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
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
	public void getAllCourse() throws Exception {
			when(jdbcTemplate.query(Queries.GET_ALL_COURSES, CourseRowMapper.CourseRowMapperLambda ))
	          .thenReturn(courses);
	         List<Course> courses = (List<Course>) courseDao.getAllCourses();
	         assertEquals(2, courses.size());
	}
	
	@Test
	public void getCourseById() throws Exception {
		
		when(jdbcTemplate.queryForObject(Queries.GET_COURSE_BY_ID, CourseRowMapper.CourseRowMapperLambda, 1 )).thenReturn(course1);
		
		Course courseFound = (Course) courseDao.getCourseById(1);
		assertEquals(course1, courseFound);
	}
	
	@Test
	public void addCourse() throws Exception {
		
		when(jdbcTemplate.update(Queries.ADD_COURSE, course1.getCourseDescription(), course1.getCourseLocation(), course1.getCourseName(), course1.getCoursePrerequisites(), course1.getCourseSkills(), course1.getCourseAdminId())).thenReturn(1);
		
		String courseFound = courseDao.addCourse(course1);
		assertThat(courseFound).isNotNull();
		assertEquals("Course Added Successfully", courseFound);
		
	}
	
	@Test
	public void updateCourse() throws Exception {
		
		when(jdbcTemplate.update(Queries.UPDATE_COURSE, course1.getCourseDescription(), course1.getCourseLocation(), course1.getCourseName(), course1.getCoursePrerequisites(), course1.getCourseSkills(), course1.getCourseId())).thenReturn(1);
		
		String courseFound = courseDao.updateCourse(course1);
		assertThat(courseFound).isNotNull();
		assertEquals("Course Updated Successfully", courseFound);
		
	}
	
	@Test
	public void deleteCourse() throws Exception {
		
		when(jdbcTemplate.update(Queries.DELETE_COURSE, 1)).thenReturn(1);
		
		String courseFound = courseDao.deleteCourse(1);
		assertThat(courseFound).isNotNull();
		assertEquals("Course Deleted Successfully", courseFound);
	}

	@Test
	public void getCourseForAdmin() throws Exception {
		
		when(jdbcTemplate.query(Queries.GET_COURSES_FOR_ADMIN, CourseRowMapper.CourseRowMapperLambda, 2)).thenReturn(courses);

		List<Course> recdCourses = (List<Course>) courseDao.getCourseForAdmin(2);
		assertThat(recdCourses).isNotNull();
		assertEquals(2, recdCourses.size());
	}
	
	@Test
	public void getCourseForTrainer() throws Exception {
		
		when(jdbcTemplate.query(Queries.GET_COURSES_FOR_TRAINER, CourseRowMapper.CourseRowMapperLambda, 1)).thenReturn(courses);
		List<Course> recdCourses = (List<Course>) courseDao.getCourseForTrainer(1);
		assertThat(recdCourses).isNotNull();
		assertEquals(2, recdCourses.size());
	}

}
