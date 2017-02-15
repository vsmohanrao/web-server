package com.mu.microservices.message.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mu.microservices.message.service.WebMessageService;

@RestController
public class WebMessageController {

	@Autowired
	private WebMessageService messageService;

	@RequestMapping(value = "/message/{name}", produces = "application/json")
	public String welcomeMesssage(@PathVariable String name) {
		return messageService.getMessage(name);
	}
}
