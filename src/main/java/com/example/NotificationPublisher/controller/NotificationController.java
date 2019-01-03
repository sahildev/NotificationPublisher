package com.example.NotificationPublisher.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
	
	@Autowired
	ProducerTemplate producerTemplate;
	
	@RequestMapping(value ="/{entity}")
	public void startJob(@PathVariable String entity){
		
		producerTemplate.sendBody("direct:startJobRoute", entity);
		
	}

}
