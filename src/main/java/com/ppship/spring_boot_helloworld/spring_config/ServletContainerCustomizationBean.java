package com.ppship.spring_boot_helloworld.spring_config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

@Component
public class ServletContainerCustomizationBean implements EmbeddedServletContainerCustomizer {
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8080);
	}
}
