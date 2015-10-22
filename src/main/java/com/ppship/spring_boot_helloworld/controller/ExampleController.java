package com.ppship.spring_boot_helloworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppship.spring_boot_helloworld.domain.City;
import com.ppship.spring_boot_helloworld.domain.ProjectSettings;

@RestController
public class ExampleController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ProjectSettings projectSettings;
	
	@RequestMapping("/")
	String home() {
		logger.debug("projectSettings : " + projectSettings);
		return "{'result':'Hello World!'}";
	}

	@RequestMapping("/test")
	String homeTest() {
		return "{'result':'Hello World!123435'}";
	}
	@RequestMapping("/test/abc")
	String homeTestAbc() {
		return "{'result':'Hello World!2'}";
	}
	@RequestMapping("/test/def")
	String homeTestDef() {
		return "{'result':'Hello World!2'}";
	}

	@RequestMapping("/test/eee")
	String homeTestEee(City city) {
		return "{'result':'Hello World!123435'}";
	}
}
