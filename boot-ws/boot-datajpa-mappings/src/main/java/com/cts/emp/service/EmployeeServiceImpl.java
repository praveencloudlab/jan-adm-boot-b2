package com.cts.emp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.cts.emp.entity.Employee;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImpl {

	//@Value("classpath:data.json")
	@Value("classpath:employees.json")
	private Resource resource;

	/*
	@Bean
	public Employee loadEmployee() throws StreamReadException, DatabindException, IOException {
		return new ObjectMapper().readValue(resource.getInputStream(), Employee.class);
	}
	
	*/
	
	
	public List<Employee> loadEmployees() throws StreamReadException, DatabindException, IOException{
		return new ObjectMapper().readValue(resource.getInputStream(), new TypeReference<List<Employee>>(){});
	}
	
	
	

}
