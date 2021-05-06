package com.aums.course.constants;

public class AttributeMapper {
	
	private AttributeMapper () {
		
	}
	
	//TABLES
	public static final String EMPLOYEE = "employee";
	public static final String ADMIN = "system_admin";
	public static final String TRAINER = "trainer";
	public static final String COURSE = "course";
	public static final String TRAINING = "training";
	public static final String MATERIAL= "training_material";
	
	//Employee
	public static final String EMP_ID= "emp_id";
	public static final String EMP_EMAIL_ID = "emp_email_id";
	public static final String EMP_NAME = "emp_name";
	public static final String EMP_DESIGNATION = "emp_designation";
	public static final String EMP_LOCATION = "emp_location";
	public static final String EMP_IMG = "emp_img";
	public static final String EMP_LAST_MODIFIER_ID = "last_modifier_id";
	public static final String EMP_LAST_MODIFIED_TM = "last_modified_tm";
	
	//Course
	public static final String COURSE_ID = "course_id";
	public static final String COURSE_DESCRIPTION = "course_description";
	public static final String COURSE_LOCATION = "course_location";
	public static final String COURSE_NAME = "course_name";
	public static final String COURSE_PREREQUISITES = "course_prerequisites";
	public static final String COURSE_SKILLS = "course_skills";
	public static final String COURSE_ADMIN_ID = "course_admin_id";
	public static final String COURSE_LAST_MODIFIER_ID = "last_modifier_id";
	public static final String COURSE_LAST_MODIFIED_TM = "last_modified_tm";
	public static final String COURSE_ACTIVE_FLAG = "course_active_flag";

	// Admin
	public static final String ADMIN_ID = "admin_id";
	public static final String ADMIN_LAST_MODIFIER_ID = "last_modifier_id";
	public static final String ADMIN_LAST_MODIFIED_TM = "last_modified_tm";
	
	//Trainer
	public static final String TRAINER_ID = "trainer_id";
	public static final String TRAINER_ACTIVE_FLAG = "active_flag";
	public static final String TRAINER_LAST_MODIFIER_ID = "last_modifier_id";
	public static final String TRAINER_LAST_MODIFIED_TM = "last_modified_tm";
	
	//Training
	public static final String TRAINING_ID = "training_id";
	public static final String TRAINING_COURSE_ID = "course_id";
	public static final String TRAINING_TRAINER_ID = "trainer_id";
	public static final String TRAINING_FEEDBACK = "training_feedback";
	public static final String TRAINING_LAST_MODIFIER_ID = "last_modifier_id";
	public static final String TRAINING_LAST_MODIFIED_TM = "last_modified_tm";
	public static final String TRAINING_ACTIVE_FLAG = "training_active_flag";
	
	//TrainingMaterial
	public static final String MATERIAL_FILE_ID = "file_id";
	public static final String MATERIAL_ID = "material_id";
	public static final String MATERIAL_FILE = "material_file";
	public static final String MATERIAL_FILE_NAME = "material_file_name";
	public static final String MATERIAL_FILE_TYPE = "material_file_type";
	public static final String MATERIAL_ACTIVE_FLAG = "active_flag";
	public static final String MATERIAL_LAST_MODIFIER_ID = "last_modifier_id";
	public static final String MATERIAL_LAST_MODIFIED_TM = "last_modified_tm";
	
}
