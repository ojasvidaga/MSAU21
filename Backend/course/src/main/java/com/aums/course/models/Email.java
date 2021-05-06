package com.aums.course.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Email {

	private String mailRecepient;
	private String mailSubject;
	private String trainerName;
	private String courseDescription;
	private String courseLocation;
	private String courseName;
	private String coursePrerequisites;
	private String courseSkills;
	public String getMailRecepient() {
		return mailRecepient;
	}
	public void setMailRecepient(String mailRecepient) {
		this.mailRecepient = mailRecepient;
	}
	public String getMailSubject() {
		return mailSubject;
	}
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getCourseLocation() {
		return courseLocation;
	}
	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCoursePrerequisites() {
		return coursePrerequisites;
	}
	public void setCoursePrerequisites(String coursePrerequisites) {
		this.coursePrerequisites = coursePrerequisites;
	}
	public String getCourseSkills() {
		return courseSkills;
	}
	public void setCourseSkills(String courseSkills) {
		this.courseSkills = courseSkills;
	}
	
	
}
