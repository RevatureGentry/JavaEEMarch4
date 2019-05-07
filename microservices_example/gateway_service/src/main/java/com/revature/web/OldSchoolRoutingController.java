package com.revature.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OldSchoolRoutingController {

	/*
	 * This a Spring convenience class to help create HTTP requests and manage their responses
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/old-school", produces="text/plain")
	public String getDummyMessageFromTweetService() {
		return restTemplate.getForObject("http://tweetservice/dummy", String.class);
	}
}
