package com.aums.course.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.aums.course.dao.TrainingDao;
import com.aums.course.models.Email;
import com.aums.course.models.Employee;
import com.aums.course.models.Training;

@SpringBootTest()
public class TrainingServiceTest {

	@InjectMocks
	private TrainingService trainingService;

	@Mock
	private TrainingDao trainingDao;
	
	Training obj = new Training();
	Employee emp = new Employee();
	List<Employee> list = new ArrayList<>();
	Email mail = new Email();
	
	@BeforeEach
	public void init() {
		obj.setCourseId(1);
		obj.setFeedback("Great");
		obj.setTrainerId(1);
		obj.setTrainingId(1);
		
		emp.setEmpId(1);
		emp.setEmpEmail("omkar.ravindraraykar@accoliteindia.com");
		emp.setEmpDesignation("SDE");
		emp.setEmpLocation("Mumbai");
		emp.setEmpName("Omkar Raykar");
		
		mail.setMailRecepient("omkar.ravindraraykar@accoliteindia.com");
		mail.setMailSubject("Accolite Mail System");
		mail.setCourseDescription("desc");
		mail.setCourseLocation("Goa");
		mail.setCourseName("React");
		mail.setCoursePrerequisites("Prerequisites");
		mail.setCourseSkills("Skills");
		mail.setTrainerName("Omkar");
		
		list.add(emp);
		list.add(emp);
	}

	@Test
	public void assignTrainers() {
		Mockito.when(trainingDao.addOrUpdateTrainer(1)).thenReturn("Employee Added/Updated Successfully!!");
		assertEquals("Trainer Assigned Successfully!!", trainingService.assignTrainers(1,2));
		
		Mockito.when(trainingDao.assignTrainers(1,2)).thenReturn("Trainer Assigned Successfully!!");
		assertEquals("Trainer Assigned Successfully!!", trainingService.assignTrainers(1,2));
	}

	@Test
	public void unassignTrainers_1() {
		Mockito.when(trainingDao.unassignTrainers(1,2)).thenReturn("Trainer Assigned Successfully!!");
		
		
		Mockito.when(trainingDao.validateTrainer(2)).thenReturn(0);
		
		assertEquals("Trainer Assigned Successfully!!", trainingService.assignTrainers(1,2));
		
	}
	
	@Test
	public void unassignTrainers_2() {
		Mockito.when(trainingDao.unassignTrainers(1,2)).thenReturn("Trainer Assigned Successfully!!");
		
		Mockito.when(trainingDao.validateTrainer(2)).thenReturn(1);
		
		Mockito.when(trainingDao.updateTrainerStatus(1)).thenReturn("Trainer Updated!!!");
		
		
		assertEquals("Trainer Assigned Successfully!!", trainingService.assignTrainers(1,2));
	}
	
	@Test
	public void getTrainersByCourseId() {
		Mockito.when(trainingDao.getTrainersByCourseId(1)).thenReturn(list);
		assertEquals(list, trainingService.getTrainersByCourseId(1));
	}

	@Test
	public void getAllEmployees() {
		Mockito.when(trainingDao.getAllEmployees()).thenReturn(list);
		assertEquals(list, trainingService.getAllEmployees());
	}
	
}
