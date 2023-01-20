package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix  = "spring.application")
public class ProuctServiceImpl {
	
	//@Value("${my-city}")
	private String cityName;
	
	
	private String name;
	
	@Autowired
	private Environment env;
	
	@Value("${spring.application.name}")
	private String appName;
	
	@Profile("dev")
	@Bean
	public void f1() {
		System.out.println("City: "+env.getProperty("city"));
		System.out.println("App name: "+appName);
		System.out.println("name: "+name);
	}
	
	
	@Profile("test")
	@Bean
	public void f2() {
		System.out.println("City: "+env.getProperty("city"));
		System.out.println("App name: "+appName);
		System.out.println("name: "+name);
	}

}
