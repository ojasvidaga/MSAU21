package com.aums.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aums.course.dao.LoginDao;
import com.aums.course.models.Employee;

@Service
public class LoginService implements ILoginService {

	@Autowired
	LoginDao loginDao;
	
	public Employee validateUser(String email) {
		Employee emp = loginDao.validateUser(email);
		
		boolean admin = loginDao.checkAdmin(emp.getEmpId());
		boolean trainer = loginDao.checkTrainer(emp.getEmpId());
		
		emp.setRole( admin && trainer ? "both" : admin ? "admin" : "trainer" );
		
		
		return emp;
	}
	
}
