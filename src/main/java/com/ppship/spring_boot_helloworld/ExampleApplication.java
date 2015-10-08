package com.ppship.spring_boot_helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableAutoConfiguration
//@Configuration
//@ComponentScan
@SpringBootApplication
public class ExampleApplication {
	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder() //
		.showBanner(true) //
		.sources(ExampleApplication.class) //
		.run(args);
	}
}
