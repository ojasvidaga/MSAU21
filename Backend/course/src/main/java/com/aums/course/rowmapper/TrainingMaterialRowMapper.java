package com.aums.course.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import com.aums.course.constants.AttributeMapper;
import com.aums.course.models.TrainingMaterial;

public class TrainingMaterialRowMapper {

	private TrainingMaterialRowMapper() {
		
	}
	
	public static final RowMapper<TrainingMaterial> TrainingMaterialRowMapperLambda = (rs, rowNum) -> {

		TrainingMaterial model = new TrainingMaterial();

		model.setMaterialId(rs.getInt(AttributeMapper.MATERIAL_ID));
		model.setFileId(rs.getInt(AttributeMapper.MATERIAL_FILE_ID));
		model.setFile(rs.getBlob(AttributeMapper.MATERIAL_FILE).getBytes(1, (int)rs.getBlob(AttributeMapper.MATERIAL_FILE).length()));
		model.setFileName(rs.getString(AttributeMapper.MATERIAL_FILE_NAME));
		model.setFileType(rs.getString(AttributeMapper.MATERIAL_FILE_TYPE));
		model.setTrainerId(rs.getInt(AttributeMapper.TRAINING_TRAINER_ID));
		return model;
	};
	
	public static final RowMapper<TrainingMaterial> VersionRowMapperLambda = (rs, rowNum) -> {
		
		TrainingMaterial model = new TrainingMaterial();

		model.setFile(rs.getBlob("material_file").getBytes(1, (int)rs.getBlob("material_file").length()));
		model.setFileName(rs.getString("material_file_name"));
		model.setFileType(rs.getString("material_file_type"));
		model.setUploadedOn(rs.getDate("uploaded_on"));
		model.setDeletedOn(rs.getDate("deleted_on"));
		model.setTrainerName(rs.getString("emp_name"));

		return model;
	};
	
}
