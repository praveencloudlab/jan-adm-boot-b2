package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import com.Demo;
import com.cts.ecart.service.ProductServiceImpl;

@SpringBootApplication //(container)
public class BootBeanLifecycleApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac= SpringApplication.run(BootBeanLifecycleApplication.class, args);

		
		ProductServiceImpl ps1 = ac.getBean(ProductServiceImpl.class);	
		ProductServiceImpl ps2 = ac.getBean(ProductServiceImpl.class);
		
		ps1.saveProduct();
		ps2.saveProduct();
		
		//ac.close();
		//ac.registerShutdownHook();
	
	
	}

}
