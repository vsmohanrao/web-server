package com.mu.microservices.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebMessageService {

	public static final String MESSAGE_SERVICE_ID = "http://MESSAGE-SERVICE";

	@Autowired
	protected RestTemplate restTemplate;

	public String getMessage(String name) {
		return restTemplate.getForObject(
				MESSAGE_SERVICE_ID + "/message/{name}", String.class, name);
	}

}
