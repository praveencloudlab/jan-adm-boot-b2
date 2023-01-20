package com.cts.ecart.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MyAspect {
	
	@Bean
	public void f1() {
		System.out.println("test");
	}

}
