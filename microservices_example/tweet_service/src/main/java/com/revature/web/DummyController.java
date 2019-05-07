package com.revature.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

	// Injects the value of some property (in your .properties file) into a field
	@Value("${server.port}")
	private String portNumber;
	
	@GetMapping(value = "/dummy", produces="text/plain")
	public String getLoadBalancedMessage() {
		return "Hello from the tweet_service on port " + portNumber;
	}
}
