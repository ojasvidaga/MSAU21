package com.aums.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aums.course.models.TrainingMaterial;
import com.aums.course.services.TrainingMaterialService;


@RestController
@RequestMapping("api/trainingMaterial")
public class TrainingMaterialController {

	@Autowired
	TrainingMaterialService trainingMaterialService;
	
	@PostMapping("/add")
	public String addFiles(@RequestParam("files[]") MultipartFile[] filesArr,@RequestParam("courseId") int courseId, @RequestParam("trainerId") int trainerId) throws Exception {
		return trainingMaterialService.addFiles(filesArr, courseId, trainerId);
	}
	
	@PostMapping("/delete")
	public String deleteFile(@RequestBody int fileId)  {
		return trainingMaterialService.deleteFile(fileId);
	}
		
	@GetMapping("/files/{courseId}/{trainerId}")
	public List<TrainingMaterial> getFilesByTrainingId(@PathVariable("courseId") int courseId, @PathVariable("trainerId") int trainerId) {
		return trainingMaterialService.getFilesByTrainingId(courseId, trainerId);
	}

	@GetMapping("/fileVersions/{courseId}")
	public List<TrainingMaterial> getVersions(@PathVariable("courseId") int courseId) {
		return trainingMaterialService.getVersions(courseId);
	}
	
}

