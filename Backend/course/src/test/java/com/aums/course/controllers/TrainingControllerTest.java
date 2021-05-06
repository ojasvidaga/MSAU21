package com.aums.course.controllers;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.aums.course.models.Email;
import com.aums.course.models.Employee;
import com.aums.course.models.Training;
import com.aums.course.services.TrainingService;

@SpringBootTest()
public class TrainingControllerTest {

	@InjectMocks
	private TrainingController trainingController;

	@Mock
	private TrainingService trainingService;
	
	Training obj = new Training();
	Employee emp = new Employee();
	List<Employee> list = new ArrayList<>();
	Email mail = new Email();
	
	@BeforeEach
	public void init() {
		obj.setCourseId(1);
		obj.setFeedback("Great");
		obj.setTrainerId(2);
		obj.setTrainingId(3);
		
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
	public void getAllEmployees() {
		Mockito.when(trainingService.getAllEmployees()).thenReturn(list);
		assertEquals(list, trainingController.getAllEmployees());
	}

	@Test
	public void unassignTrainers() {
		Mockito.when(trainingService.unassignTrainers(1, 2)).thenReturn("Trainer UnAssigned Successfully!!!");
		assertEquals("Trainer UnAssigned Successfully!!!", trainingController.unassignTrainers(obj));
	}
	
	@Test
	public void assignTrainers() {
		Mockito.when(trainingService.assignTrainers(1, 2)).thenReturn("Trainer Assigned Successfully!!!");
		assertEquals("Trainer Assigned Successfully!!!", trainingController.assignTrainers(obj));
	}
	
	@Test
	public void getTrainersByCourseId() {
		Mockito.when(trainingService.getTrainersByCourseId(1)).thenReturn(list);
		assertEquals(list, trainingController.getTrainersByCourseId(1));
	}

	@Test
	public void sendMail() throws MessagingException {
		Mockito.when(trainingService.sendMail(mail)).thenReturn("Mail Sent");
		assertEquals("Mail Sent", trainingController.sendMail(mail));
	}

}

