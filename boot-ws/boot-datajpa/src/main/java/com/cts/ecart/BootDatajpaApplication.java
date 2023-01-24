package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.ecart.entity.Product;
import com.cts.ecart.repository.ProductRepository;

@SpringBootApplication
public class BootDatajpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac= SpringApplication.run(BootDatajpaApplication.class, args);
		ProductRepository prodRepo = ac.getBean(ProductRepository.class);
		Product p1=new Product("Laptop", 45000);
		Product p2=new Product("Mobile", 56000);
		Product p3=new Product("Mouse", 4600);
		Product p4=new Product("Head Phone", 38000);
		Product p5=new Product("Ipad", 95000);
		
		//prodRepo.save(p1);
		//prodRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		// fetch all records
		
		 //Integer[] ids= {1,2,3,4,5};
		 /*
		  * [1,2,3,4,5]
		  * [{"id":1},{"id":2},{"id":3},{"id":4},{"id":5}]
		  *  data.txt -> 1,2,3,4,5
		  * 
		  * 
		  * 
		  */
		 
		//List<Product> products = prodRepo.findAllById(Arrays.asList(1,2,3,4,5));
		//System.out.println(products);
		
		//prodRepo.findAll().forEach(System.out::println);
		
		
		Product product = prodRepo.findById(2).orElse(null);
		System.out.println(product);
		product.setPrice(16000);
		prodRepo.save(product);
		
		
		
		
		
		
		
		
	}

}
