package com.example.NotificationPublisher.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.NotificationPublisher.service.DynamicConfigReader;

@Configuration
public class JsonDataSourcesConfiguration {
	
	@Value("${mappingPath.notification}")
	private String notificationJsonMappingConfig;
	
	@Bean(name="notificationConfiguration")
	public DynamicConfigReader notificationConfigReader(){
		DynamicConfigReader dynamicConfigReader = new DynamicConfigReader(notificationJsonMappingConfig);
		return dynamicConfigReader;
		
	}

}
