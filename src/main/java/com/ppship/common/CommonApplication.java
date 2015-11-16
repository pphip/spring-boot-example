package com.ppship.common;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.ppship.sns.SnsApplication;

@SpringBootApplication
public class CommonApplication {
	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder() //
				.showBanner(true) //
				.sources(CommonApplication.class) //
				.run(args);
	}
}
