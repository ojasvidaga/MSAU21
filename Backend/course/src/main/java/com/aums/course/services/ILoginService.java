package com.aums.course.services;

import com.aums.course.models.Employee;

public interface ILoginService {

	public Employee validateUser(String email);
}
