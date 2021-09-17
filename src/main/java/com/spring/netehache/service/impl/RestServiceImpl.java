package com.spring.netehache.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.netehache.domain.Student;
import com.spring.netehache.service.RestService;

@Service
public class RestServiceImpl implements RestService{

	@Cacheable(value = "cachingStudent" , key = "#student.getPhoneNumber()")
	public Student getDetails(Student student) {
		
		System.out.println("Inside getDetails");
		
		student.setUserName("PES-" + student.getUserName());
		return student;
	}

}
