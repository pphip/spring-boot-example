package com.voyageth.spring_boot_helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	@RequestMapping("/")
	String home() {
		return "{'result':'Hello World!'}";
	}

	@RequestMapping("/test")
	String homeTest() {
		return "{'result':'Hello World!2'}";
	}
	@RequestMapping("/test/abc")
	String homeTestAbc() {
		return "{'result':'Hello World!2'}";
	}
	@RequestMapping("/test/def")
	String homeTestDef() {
		return "{'result':'Hello World!2'}";
	}
}
