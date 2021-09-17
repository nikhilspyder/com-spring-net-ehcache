package com.spring.netehache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.netehache.domain.Student;
import com.spring.netehache.service.StudentService;

@RestController
@RequestMapping(path = "/v1")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/getDetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student getDetails(@RequestHeader String transactionId, @RequestBody Student student) {

		return studentService.getDetails(student);
	}

}
