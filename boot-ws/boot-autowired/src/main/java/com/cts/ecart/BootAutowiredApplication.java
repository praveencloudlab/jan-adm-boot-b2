package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.ecart.repository.ProductMySQLRepositoryImpl;
import com.cts.ecart.service.ProductService;
import com.cts.ecart.service.ProductServiceImpl;

@SpringBootApplication
public class BootAutowiredApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac= SpringApplication.run(BootAutowiredApplication.class, args);
		//ProductMySQLRepositoryImpl ps = ac.getBean(ProductMySQLRepositoryImpl.class);
		//ps.save();
		
		ProductService ps = ac.getBean(ProductService.class);
		ps.saveProduct();
		
	}

}
