package com.cts.ecart;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.ecart.repository.ProductRepositoryImpl;

@SpringBootApplication
//exclude = {DataSourceAutoConfiguration.class}
public class BootJdbcTemplateApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ac= SpringApplication.run(BootJdbcTemplateApplication.class, args);
		ProductRepositoryImpl prodDao = ac.getBean(ProductRepositoryImpl.class);
		
		//prodDao.fetchAll().forEach(System.out::println);
		Map<String, Object> row = prodDao.findById(3);
		System.out.println(row);
	}

}
