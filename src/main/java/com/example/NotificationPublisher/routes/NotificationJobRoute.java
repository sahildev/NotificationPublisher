package com.example.NotificationPublisher.routes;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NotificationJobRoute extends RouteBuilder{
	
	@Autowired
	Processor preProcessor;

	@Override
	public void configure() throws Exception {
		from("direct:startJobRoute")
		.log("${body}")
		.routeId("notification-route")
		.startupOrder(1)
		.autoStartup(true)
		.description("Notification Processing route.")
		.process(preProcessor);
		
	}

}
