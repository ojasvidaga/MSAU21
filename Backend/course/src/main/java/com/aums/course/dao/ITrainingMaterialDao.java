package com.aums.course.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.web.multipart.MultipartFile;

import com.aums.course.models.TrainingMaterial;

public interface ITrainingMaterialDao {
	
	public String addFiles(MultipartFile[] filesArr, int materialId) throws IOException, SQLException ;
	
	public int getTrainingId(int courseId,int trainerId);
	
	public String deleteFile(int materialId);
	
	public List<TrainingMaterial> getFilesByTrainingId(int materialId);

	List<TrainingMaterial> getVersions(int courseId);
	
}
