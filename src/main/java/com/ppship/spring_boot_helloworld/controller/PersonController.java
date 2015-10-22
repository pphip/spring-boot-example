package com.ppship.spring_boot_helloworld.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppship.spring_boot_helloworld.param.PersonCreateParam;

@RestController
@RequestMapping("/person")
public class PersonController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/create")
	PersonCreateParam create(@RequestBody @Valid PersonCreateParam personParam) {
		return personParam;
	}
}
