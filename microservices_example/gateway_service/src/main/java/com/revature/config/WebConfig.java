package com.revature.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Marks this class as a bean that is used to provide other beans
// (A replacement for your beans.xml, or application-context.xml, ... .xml)
@Configuration
public class WebConfig {

	// @Bean denotes that a Spring Bean of the method's return type will be available
	// in the ApplicationContext
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Perform any other configuration/customization of your RestTemplate
		return builder.build();
	}
	
}
