package com.aums.course.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import com.aums.course.models.TrainingMaterial;
import com.aums.course.services.TrainingMaterialService;

@SpringBootTest()
public class TrainingMaterialControllerTest {

	@InjectMocks
	private TrainingMaterialController trainingMaterialController;

	@Mock
	private TrainingMaterialService trainingMaterialService;

	
	TrainingMaterial trainingMaterial = new TrainingMaterial();
	List<TrainingMaterial> list = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		trainingMaterial.setFileId(1);
		trainingMaterial.setFileName("abc");
		trainingMaterial.setFileType("application/pdf");
		trainingMaterial.setMaterialId(1);
		trainingMaterial.setTrainerId(1);
		
		list.add(trainingMaterial);
		list.add(trainingMaterial);
	}
	
	@Test
	public void addFiles() throws Exception {
		MultipartFile[] file = null;
		
		Mockito.when(trainingMaterialService.addFiles(file, 1, 1)).thenReturn("File Added Successfully!");
		assertEquals("File Added Successfully!",trainingMaterialController.addFiles(file, 1, 1));
	}
	
	@Test
	public void getFilesByTrainingId() {
		Mockito.when(trainingMaterialService.getFilesByTrainingId(1, 1)).thenReturn(list);
		assertEquals(list,trainingMaterialController.getFilesByTrainingId(1, 1));
	}
	
	@Test
	public void getVersions() {
		Mockito.when(trainingMaterialService.getVersions(1)).thenReturn(list);
		assertEquals(list,trainingMaterialController.getVersions(1));
	}
	
	@Test
	public void deleteFile() {
		Mockito.when(trainingMaterialService.deleteFile(33)).thenReturn("File Deleted");
		assertEquals("File Deleted",trainingMaterialController.deleteFile(33));

	}
	
	
	
}
