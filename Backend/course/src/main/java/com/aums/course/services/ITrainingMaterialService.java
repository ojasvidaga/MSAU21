package com.aums.course.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.web.multipart.MultipartFile;

import com.aums.course.models.TrainingMaterial;

public interface ITrainingMaterialService {

	public String addFiles(MultipartFile[] filesArr, int courseId, int trainerId) throws IOException, SQLException;
	
	public String deleteFile(int materialId);
	
	public List<TrainingMaterial> getFilesByTrainingId(int courseId, int trainerId);

	List<TrainingMaterial> getVersions(int courseId);
	
}
