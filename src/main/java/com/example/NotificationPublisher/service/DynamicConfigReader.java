package com.example.NotificationPublisher.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicConfigReader {
	
	
	String mappingPath;
	private Map<String,Object> jsonMapping;
	
	public DynamicConfigReader(String mappingPath) {
		super();
		this.mappingPath = mappingPath;
	}
	
	@PostConstruct
	public void init() throws FileNotFoundException{
		
		log.info("Initializing entity mapping..");
		
		Reader reader = new BufferedReader(new FileReader(mappingPath));
		Gson gsonObject = new Gson();
		Type type = new TypeToken<HashMap<String, Object>>() {}.getType();
		jsonMapping = gsonObject.fromJson(reader, type);
		
		log.info("Entity : {} ",jsonMapping);
		
	}

}
