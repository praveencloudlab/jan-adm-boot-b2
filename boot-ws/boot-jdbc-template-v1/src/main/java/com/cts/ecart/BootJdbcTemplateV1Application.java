package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.ecart.model.Product;
import com.cts.ecart.repository.ProductLambdaRepositoryImpl;
import com.cts.ecart.repository.ProductRepositoryImpl;
import com.cts.ecart.service.ProductServiceImpl;

@SpringBootApplication
public class BootJdbcTemplateV1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac= SpringApplication.run(BootJdbcTemplateV1Application.class, args);
		ProductRepositoryImpl dao = ac.getBean(ProductRepositoryImpl.class);
		ProductServiceImpl ps = ac.getBean(ProductServiceImpl.class);
		ProductLambdaRepositoryImpl prodRepo = ac.getBean(ProductLambdaRepositoryImpl.class);
		//dao.findAllByRowMapper().forEach(System.out::println);
		//dao.findAllByRowMapperFilter(10000).forEach(System.out::println);
		//Product product = dao.findByIdRowMapper(1);
		//System.out.println(product);
		//dao.findAllByResultSetExtractor().forEach(System.out::println);
		//Product product = dao.findByIdResultSetExtractor(1);
		//System.out.println(product);
		//dao.save(new Product(104, "IPAD", 46000));
		//dao.update(new Product(101, "BP Machine", 5600));
		
		// ps.operations();
		
		//prodRepo.findAllRowMapper().forEach(System.out::println);
		//Product prod = prodRepo.findByIdRowMapper(1);
		//System.out.println(prod);
		
		//prodRepo.findAllResultSetExtractor().forEach(System.out::println);
		
		//Product prod = prodRepo.findByIdResultSetExtractor(1);
		//System.out.println(prod);
		
		
		/*
		 
		 Runnable t=()->{
			 System.out.println("Hello Thread "+Thread.currentThread().getName());
		 };	
		 
		 Thread t1=new Thread(t,"First One");
		 t1.start();
		 
		 */
		 
	}
}





