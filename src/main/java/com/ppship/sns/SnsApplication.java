package com.ppship.sns;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.ppship.common.CommonApplication;

@SpringBootApplication
public class SnsApplication {
	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder() //
				.showBanner(true) //
				.sources(CommonApplication.class, SnsApplication.class) //
				.run(args);
		
	}
}
