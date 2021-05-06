package com.aums.course.dao;

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
import org.springframework.web.multipart.MultipartFile;

import com.aums.course.models.TrainingMaterial;
import com.aums.course.queries.Queries;
import com.aums.course.rowmapper.TrainingMaterialRowMapper;
import com.mysql.cj.jdbc.Blob;

@SpringBootTest()
public class TrainingMaterialDaoTest {

	
	@InjectMocks
	private TrainingMaterialDao trainingMaterialDao;

	@Mock
    private JdbcTemplate jdbcTemplate;

	
	TrainingMaterial trainingMaterial = new TrainingMaterial();
	List<TrainingMaterial> list = new ArrayList<>();
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	
	@BeforeEach
	public void init() {
		byte[] CDRIVES = hexStringToByteArray("e04fd020ea3a6910a2d808002b30309d");
		trainingMaterial.setFileId(1);
		trainingMaterial.setFileName("abc");
		trainingMaterial.setFileType("application/pdf");
		trainingMaterial.setMaterialId(1);
		trainingMaterial.setTrainerId(1);
		
		trainingMaterial.setFile(CDRIVES);
		
		list.add(trainingMaterial);
		list.add(trainingMaterial);
	}

	@Test
	public void addFiles() throws Exception {
		MultipartFile[] file = null;
		byte[] test = null;
		when(jdbcTemplate.update(Queries.ADD_FILES_BY_TRAINING, 1, new javax.sql.rowset.serial.SerialBlob(test), file.length+"", file.length+"")).thenReturn(1);
		assertEquals("File Added Successfully",trainingMaterialDao.addFiles(file,1));
	}

	@Test
	public void getTrainingId() {
		when(jdbcTemplate.queryForObject(Queries.GET_TRAINING_ID ,Integer.class,1,1)).thenReturn(1);
		assertEquals(1,trainingMaterialDao.getTrainingId(1,1));
	}

	@Test
	public void deleteFile() {
		when(jdbcTemplate.update(Queries.DELETE_FILES_BY_TRAINING, 1)).thenReturn(1);
		assertEquals("File deleted!",trainingMaterialDao.deleteFile(1));
	}

	@Test
	public void getFilesByTrainingId() {
		when(jdbcTemplate.query(Queries.GET_FILES_BY_TRAINING, TrainingMaterialRowMapper.TrainingMaterialRowMapperLambda, 1)).thenReturn(list);
		assertEquals(list,trainingMaterialDao.getFilesByTrainingId(1));
	}

	@Test
	public void getVersions() {
		when(jdbcTemplate.query(Queries.GET_VERSIONS, TrainingMaterialRowMapper.VersionRowMapperLambda, 1)).thenReturn(list);
		assertEquals(list,trainingMaterialDao.getVersions(1));
	}
	
	
}
