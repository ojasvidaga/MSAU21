package com.aums.course.rowmapper;

import org.springframework.jdbc.core.RowMapper;


import com.aums.course.constants.AttributeMapper;
import com.aums.course.models.Course;

public class CourseRowMapper {
	
	private CourseRowMapper() {
		
	}
	
	public static final RowMapper<Course> CourseRowMapperLambda = (rs, rowNum) -> {

		Course model = new Course();

		model.setCourseId(rs.getInt(AttributeMapper.COURSE_ID));
		model.setCourseDescription(rs.getString(AttributeMapper.COURSE_DESCRIPTION));
		model.setCourseLocation(rs.getString(AttributeMapper.COURSE_LOCATION));
		model.setCourseName(rs.getString(AttributeMapper.COURSE_NAME));
		model.setCoursePrerequisites(rs.getString(AttributeMapper.COURSE_PREREQUISITES));
		model.setCourseSkills(rs.getString(AttributeMapper.COURSE_SKILLS));
		model.setCourseAdminId(rs.getInt(AttributeMapper.COURSE_ADMIN_ID));
		
		return model;
		
	};
}
