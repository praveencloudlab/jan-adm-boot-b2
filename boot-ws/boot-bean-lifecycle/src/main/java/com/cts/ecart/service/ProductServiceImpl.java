package com.cts.ecart.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
@Scope("singleton")
@Lazy(value = false) // lazy=true disables bean
public class ProductServiceImpl {
	
	/*
	 * bean life cycle methods
	 * 	1. constructor
	 *  2. @PostConstruct
	 *  
	 * 
	 */
	
	@Bean
	public void f2() {
		System.out.println("3.bean f2 method on "+System.identityHashCode(this));
	}
	
	@Bean
	public void f22() {
		System.out.println("3.bean f22 method on "+System.identityHashCode(this));
	}
	
	
	@PostConstruct
	public void f1() {
		System.out.println("2.After constructor on "+System.identityHashCode(this));
	}
	
	@PreDestroy
	public void f4() {
		System.out.println("5. preDestroy f4 "+System.identityHashCode(this));
	}
	
	
	public ProductServiceImpl() {
		System.out.println("1.ProductServiceImpl object created on "+System.identityHashCode(this));
	}
	
	
	public void saveProduct() {
		System.out.println("4.ProductServiceImpl :: saveProduct on "+System.identityHashCode(this));
	}

}
