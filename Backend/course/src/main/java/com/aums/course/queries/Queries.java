package com.aums.course.queries;

import com.aums.course.constants.AttributeMapper;

public class Queries {
	
	private Queries () {
		
	}
	
	// Login
	public static final String VALIDATE_LOGIN = "SELECT * FROM " + AttributeMapper.EMPLOYEE + " WHERE " + AttributeMapper.EMP_EMAIL_ID + "=?";
	public static final String CHECK_ADMIN = "SELECT COUNT(" + AttributeMapper.ADMIN_ID + ") FROM " + AttributeMapper.ADMIN + " WHERE " + AttributeMapper.ADMIN_ID + "=?";
	public static final String CHECK_TRAINER = "SELECT COUNT(" + AttributeMapper.TRAINER_ID + ") FROM " + AttributeMapper.TRAINER + " WHERE " + AttributeMapper.TRAINER_ID + "=? AND " + AttributeMapper.TRAINER_ACTIVE_FLAG + "='Y'";
	
	// Course
	public static final String GET_ALL_COURSES = "SELECT * FROM " + AttributeMapper.COURSE + " WHERE " + AttributeMapper.COURSE_ACTIVE_FLAG + "='Y'";
	public static final String GET_COURSE_BY_ID = "SELECT * FROM " + AttributeMapper.COURSE + " WHERE " + AttributeMapper.COURSE_ID + "=?";
	
	public static final String GET_COURSES_FOR_ADMIN = "SELECT * FROM " + AttributeMapper.COURSE + " WHERE " + AttributeMapper.COURSE_ADMIN_ID + "=? AND " + AttributeMapper.COURSE_ACTIVE_FLAG + "='Y'";
	public static final String GET_COURSES_FOR_TRAINER = "SELECT * FROM " + AttributeMapper.COURSE + " JOIN " + AttributeMapper.TRAINING + " ON " + AttributeMapper.COURSE + "." + AttributeMapper.COURSE_ID + " = " + AttributeMapper.TRAINING + "." + AttributeMapper.TRAINING_COURSE_ID + " AND " + AttributeMapper.TRAINING + "." + AttributeMapper.TRAINING_TRAINER_ID + " = ?";
	
	public static final String UPDATE_COURSE = "UPDATE " + AttributeMapper.COURSE + " set " + AttributeMapper.COURSE_DESCRIPTION + "=?, " + AttributeMapper.COURSE_LOCATION + "=?, " + AttributeMapper.COURSE_NAME + "=?, " + AttributeMapper.COURSE_PREREQUISITES + "=?, " + AttributeMapper.COURSE_SKILLS + "=?, " + AttributeMapper.COURSE_ACTIVE_FLAG + "='Y' WHERE " + AttributeMapper.COURSE_ID + "=?";
	public static final String DELETE_COURSE = "UPDATE " + AttributeMapper.COURSE + " set " + AttributeMapper.COURSE_ACTIVE_FLAG+ "='N' WHERE " + AttributeMapper.COURSE_ID + "=?";
	public static final String ADD_COURSE = "INSERT INTO " + AttributeMapper.COURSE + " (" + AttributeMapper.COURSE_DESCRIPTION + "," + AttributeMapper.COURSE_LOCATION + "," + AttributeMapper.COURSE_NAME + "," + AttributeMapper.COURSE_PREREQUISITES + "," + AttributeMapper.COURSE_SKILLS + "," + AttributeMapper.COURSE_ADMIN_ID + "," + AttributeMapper.COURSE_ACTIVE_FLAG + ")VALUES(?,?,?,?,?,?,'Y')";
	
	// Trainer
	public static final String ADD_UPDATE_TRAINER = "INSERT INTO " + AttributeMapper.TRAINER + " (" + AttributeMapper.TRAINER_ID + ", " + AttributeMapper.TRAINER_ACTIVE_FLAG + ") VALUES(?, 'Y') ON DUPLICATE KEY UPDATE " + AttributeMapper.TRAINER_ACTIVE_FLAG + "='Y'";
	public static final String ASSIGN_TRAINER = "INSERT INTO " + AttributeMapper.TRAINING + " (" + AttributeMapper.TRAINING_COURSE_ID + "," + AttributeMapper.TRAINING_TRAINER_ID + "," + AttributeMapper.TRAINING_ACTIVE_FLAG + ") values(?,?,'Y')";
	public static final String UNASSIGN_TRAINER = "UPDATE " + AttributeMapper.TRAINING + " set " + AttributeMapper.TRAINING_ACTIVE_FLAG + "='N' WHERE " + AttributeMapper.TRAINING_COURSE_ID + "=? AND " + AttributeMapper.TRAINING_TRAINER_ID + "=?";
	
	public static final String GET_TRAINERS_BY_COURSE = "SELECT e.* FROM " + AttributeMapper.EMPLOYEE +" e, " + AttributeMapper.TRAINING +" t, " + AttributeMapper.TRAINER +" tr where e." + AttributeMapper.EMP_ID +"=t." + AttributeMapper.TRAINING_TRAINER_ID +" and tr." + AttributeMapper.TRAINER_ACTIVE_FLAG +"='Y' and tr." + AttributeMapper.TRAINER_ID +"=t." + AttributeMapper.TRAINING_TRAINER_ID +" and t." + AttributeMapper.TRAINING_COURSE_ID +"=? and "+AttributeMapper.TRAINING_ACTIVE_FLAG+"='Y'";
	
	public static final String VALIDATE_TRAINER = "SELECT COUNT(" + AttributeMapper.TRAINING_ID + ") FROM " + AttributeMapper.TRAINING + " WHERE " + AttributeMapper.TRAINING_TRAINER_ID + "=? AND " + AttributeMapper.TRAINING_ACTIVE_FLAG + "='Y'";
	public static final String  UPDATE_TRAINER_STATUS = "UPDATE " + AttributeMapper.TRAINER + " set " + AttributeMapper.TRAINER_ACTIVE_FLAG + "='N' WHERE " + AttributeMapper.TRAINER_ID + "=?";
	
	// Training Material
	public static final String GET_TRAINING_ID = "SELECT " + AttributeMapper.TRAINING_ID + " FROM " + AttributeMapper.TRAINING + " WHERE " + AttributeMapper.TRAINING_COURSE_ID + "=? AND " + AttributeMapper.TRAINING_TRAINER_ID + "=?";
	public static final String ADD_FILES_BY_TRAINING = "INSERT INTO " + AttributeMapper.MATERIAL + " (" + AttributeMapper.MATERIAL_ID + ", " + AttributeMapper.MATERIAL_FILE + ", " + AttributeMapper.MATERIAL_FILE_NAME + ", " + AttributeMapper.MATERIAL_FILE_TYPE + ", " + AttributeMapper.MATERIAL_ACTIVE_FLAG + ", uploaded_on)values(?,?,?,?,'Y',NOW())";
	public static final String DELETE_FILES_BY_TRAINING = "UPDATE " + AttributeMapper.MATERIAL + " set " + AttributeMapper.MATERIAL_ACTIVE_FLAG + "='N', deleted_on=NOW() WHERE " + AttributeMapper.MATERIAL_FILE_ID + "=?";
	public static final String GET_FILES_BY_TRAINING = "SELECT tm.*, t." + AttributeMapper.TRAINING_TRAINER_ID + " FROM " + AttributeMapper.MATERIAL + " tm, " + AttributeMapper.TRAINING + " t where tm." + AttributeMapper.MATERIAL_ID + "=? AND tm." + AttributeMapper.MATERIAL_ACTIVE_FLAG + "='Y' and tm." + AttributeMapper.MATERIAL_ID + "=t." + AttributeMapper.TRAINING_ID + "";
	
	// Utility
	public static final String GET_ALL_EMPLOYEES = "SELECT "+ AttributeMapper.EMP_ID +","+ AttributeMapper.EMP_NAME +","+ AttributeMapper.EMP_EMAIL_ID +" FROM " + AttributeMapper.EMPLOYEE + "";
	
	// Versions
	public static final String GET_VERSIONS = "SELECT tm.material_file, tm.material_file_name, tm.material_file_type, tm.uploaded_on, tm.deleted_on, e.emp_name  FROM training_material tm, training t, employee e WHERE tm.material_id=t.training_id and t.trainer_id=e.emp_id and t.course_id=?";
}
