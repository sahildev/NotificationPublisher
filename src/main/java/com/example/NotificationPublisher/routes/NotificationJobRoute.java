package com.example.NotificationPublisher.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class NotificationJobRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:startJobRoute")
		.log("${body}")
		.routeId("notif-route")
		.startupOrder(1)
		.autoStartup(true)
		.description("Notification Processing route.");
		
	}

}
