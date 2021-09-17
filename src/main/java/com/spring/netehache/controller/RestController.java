package com.spring.netehache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.netehache.domain.Student;
import com.spring.netehache.service.RestService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/v1")
public class RestController {

	@Autowired
	private RestService restService;

	@GetMapping(path = "/check", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student check(@RequestHeader String transactionId, @RequestBody Student student) {

		return restService.getDetails(student);
	}

}
