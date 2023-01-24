package com.cts.ecart.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class MyAspect {
	
	@Around(value = "")
	public void f1() {
		System.out.println("test");
	}

}
