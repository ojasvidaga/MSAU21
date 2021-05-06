package com.aums.course.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Course {
	
 private int courseId;
 private String courseDescription;
 private String courseLocation;
 private String courseName;
 private String coursePrerequisites;
 private String courseSkills;
 private int courseAdminId;
 
 
public int getCourseId() {
	return courseId;
}
public void setCourseId(int courseId) {
	this.courseId = courseId;
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
public int getCourseAdminId() {
	return courseAdminId;
}
public void setCourseAdminId(int courseAdminId) {
	this.courseAdminId = courseAdminId;
}
 
 
 
}
