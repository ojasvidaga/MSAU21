package com.aums.course.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aums.course.dao.TrainingMaterialDao;
import com.aums.course.models.TrainingMaterial;

@Service
public class TrainingMaterialService implements ITrainingMaterialService {

	@Autowired
	TrainingMaterialDao trainingMaterialDao;
	
	@Override
	public String addFiles(MultipartFile[] filesArr, int courseId, int trainerId) throws IOException, SerialException, SQLException {
		return trainingMaterialDao.addFiles(filesArr, trainingMaterialDao.getTrainingId(courseId, trainerId));
	}
	
	@Override
	public String deleteFile(int fileId) {
		return trainingMaterialDao.deleteFile(fileId);
	}
	
	@Override
	public List<TrainingMaterial> getFilesByTrainingId(int courseId, int trainerId) {
		return trainingMaterialDao.getFilesByTrainingId(trainingMaterialDao.getTrainingId(courseId, trainerId));
	}

	@Override
	public List<TrainingMaterial> getVersions(int courseId) {
		return trainingMaterialDao.getVersions(courseId);
	}
}
