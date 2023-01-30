package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Category;
import com.cts.ecart.entity.Product;
import com.cts.ecart.repository.BrandRepository;
import com.cts.ecart.repository.CategoryRepository;
import com.cts.ecart.repository.ProductRepository;

@SpringBootApplication
public class BootDatajpaEcartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(BootDatajpaEcartApplication.class, args);
		ProductRepository prodRepo = ac.getBean(ProductRepository.class);
		BrandRepository brandRepo=ac.getBean(BrandRepository.class);
		CategoryRepository catRepo = ac.getBean(CategoryRepository.class);
		
		//Brand brand = brandRepo.findById(98).orElse(null);
		Category category = catRepo.findById(53).orElse(null);
		
		//brand.getProds().add(prodRepo.findById(97).orElse(null));
		//brand.getProds().add(prodRepo.findById(66).orElse(null));
		//brand.getProds().add(prodRepo.findById(164).orElse(null));
		//brand.getProds().add(prodRepo.findById(167).orElse(null));
		

		category.getProds().add(prodRepo.findById(164).orElse(null));
		category.getProds().add(prodRepo.findById(167).orElse(null));
		
		
		
		//brandRepo.save(brand);
		catRepo.save(category);
		


		
		
	}

}
