package com.aums.course.controllers;

import java.util.List; 

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aums.course.models.Email;
import com.aums.course.models.Employee;
import com.aums.course.models.Training;
import com.aums.course.services.TrainingService;

@RestController
@RequestMapping("api/training")
public class TrainingController {

	@Autowired
	TrainingService trainingService;
	
	private TrainingController() {
		
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return trainingService.getAllEmployees();
	}
	
	@PostMapping("/assignTrainers")
	public String assignTrainers(@RequestBody Training trainingTest) {
		return trainingService.assignTrainers(trainingTest.getCourseId(),trainingTest.getTrainerId());
	}
	
	@PostMapping("/unassignTrainers")
	public String unassignTrainers(@RequestBody Training trainingTest) {
		return trainingService.unassignTrainers(trainingTest.getCourseId(),trainingTest.getTrainerId());
	}
	
	@GetMapping("/getTrainersByCourseId/{courseId}") 
	public List<Employee> getTrainersByCourseId(@PathVariable("courseId") int courseId) {
		return trainingService.getTrainersByCourseId(courseId);
	}
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody Email obj) throws MessagingException {
		return trainingService.sendMail(obj);
	}
}

