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

import com.aums.course.models.Email;
import com.aums.course.models.Employee;
import com.aums.course.models.Training;
import com.aums.course.queries.Queries;
import com.aums.course.rowmapper.TrainingRowMapper;

@SpringBootTest()
public class TrainingDaoTest {
	
	@Mock
    private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
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
	public void addOrUpdateTrainer() {
		when(jdbcTemplate.update(Queries.ADD_UPDATE_TRAINER, 1)).thenReturn(1);
		assertEquals("Employee Added/Updated Successfully!!",trainingDao.addOrUpdateTrainer(1));
	}

	@Test
	public void assignTrainers() {
		when(jdbcTemplate.update(Queries.ASSIGN_TRAINER, 1, 1)).thenReturn(1);
		assertEquals("Trainer Assigned Successfully!!",trainingDao.assignTrainers(1,1));	
	}

	@Test
	public void unassignTrainers() {
		when(jdbcTemplate.update(Queries.UNASSIGN_TRAINER, 1, 1)).thenReturn(1);
		assertEquals("Trainer Unassigned Successfully!!",trainingDao.unassignTrainers(1,1));
	}

	@Test
	public void validateTrainer() {
		when(jdbcTemplate.queryForObject(Queries.VALIDATE_TRAINER, Integer.class, 1)).thenReturn(1);
		assertEquals(1,trainingDao.validateTrainer(1));
	}

	@Test
	public void updateTrainerStatus() {
		when(jdbcTemplate.update(Queries.UPDATE_TRAINER_STATUS, 1)).thenReturn(1);
		assertEquals("Trainer Updated!!!",trainingDao.updateTrainerStatus(1));
	}

	@Test
	public void getTrainersByCourseId() {
		when(jdbcTemplate.query(Queries.GET_TRAINERS_BY_COURSE, TrainingRowMapper.TrainingRowMapperLambda ,1)).thenReturn(list);
		assertEquals(list,trainingDao.getTrainersByCourseId(1));
	}

	@Test
	public void getAllEmployees() {
		when(jdbcTemplate.query(Queries.GET_ALL_EMPLOYEES, TrainingRowMapper.TrainerRowMapperLambda)).thenReturn(list);
		assertEquals(list,trainingDao.getAllEmployees());
	}
	
}
