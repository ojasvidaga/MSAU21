package com.aums.course.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import com.aums.course.constants.AttributeMapper;
import com.aums.course.models.Employee;

public class TrainingRowMapper {
	
	private TrainingRowMapper () {
		
	}
	
	public static final RowMapper<Employee> TrainingRowMapperLambda = (rs,rowNum) -> {
		
		Employee model = new Employee();
	
		model.setEmpId(rs.getInt(AttributeMapper.EMP_ID));
		model.setEmpEmail(rs.getString(AttributeMapper.EMP_EMAIL_ID));
		model.setEmpName(rs.getString(AttributeMapper.EMP_NAME));
		model.setEmpDesignation(rs.getString(AttributeMapper.EMP_DESIGNATION));
		model.setEmpLocation(rs.getString(AttributeMapper.EMP_LOCATION));
		model.setEmpImage(rs.getBlob(AttributeMapper.EMP_IMG));
		
		return model;
		
	};
	
	public static final RowMapper<Employee> TrainerRowMapperLambda = (rs, rowNum) -> {

		Employee model = new Employee();

		model.setEmpId(rs.getInt(AttributeMapper.EMP_ID));
		model.setEmpEmail(rs.getString(AttributeMapper.EMP_EMAIL_ID));
		model.setEmpName(rs.getString(AttributeMapper.EMP_NAME));

		return model;
	};
	
}
