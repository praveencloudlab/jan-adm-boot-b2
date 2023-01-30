package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.ecart.entity.Category;
import com.cts.ecart.repository.BrandRepository;
import com.cts.ecart.repository.CategoryRepository;
import com.cts.ecart.repository.ProductRepository;

@SpringBootApplication
public class BootDatajpaEcartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(BootDatajpaEcartApplication.class, args);
		ProductRepository prodRepo = ac.getBean(ProductRepository.class);
		BrandRepository brandRepo = ac.getBean(BrandRepository.class);
		CategoryRepository catRepo = ac.getBean(CategoryRepository.class);

		// Brand brand = brandRepo.findById(81).orElse(null);
		// Category category = catRepo.findById(53).orElse(null);

		// brand.getProds().add(prodRepo.findById(97).orElse(null));
		// brand.getProds().add(prodRepo.findById(66).orElse(null));
		// brand.getProds().add(prodRepo.findById(164).orElse(null));
		// brand.getProds().add(prodRepo.findById(167).orElse(null));

		// category.getProds().add(prodRepo.findById(164).orElse(null));
		// category.getProds().add(prodRepo.findById(167).orElse(null));

		// brandRepo.save(brand);
		// catRepo.save(category);

		/*
		 * 
		 * Product p1=new Product(); p1.setProductTitle("Sony Sound Bar");
		 * p1.setDescription("SONY Dolby 7.1 Sound bar");
		 * p1.setKeywords("5.1,Sound Bar,Bar,Sound,Sound System, Sony Sound,Speakers");
		 * PriceInfo pi=new PriceInfo(); pi.setPrice(95000); StockInfo si=new
		 * StockInfo(); si.setStock(30);
		 * 
		 * p1.setPriceInfo(pi); p1.setStockInfo(si);
		 * 
		 * prodRepo.save(p1); brand.getProds().add(p1); Category c1=new Category();
		 * c1.setCategoryTitle("Speakers"); c1.getProds().add(p1); catRepo.save(c1);
		 * brandRepo.save(brand);
		 * 
		 */

		// fetch all products

		// prodRepo.findAll().forEach(System.out::println);

		/*
		 * catRepo.findAll().forEach(cat->{ System.out.println(cat); });
		 * 
		 */

		/*
		Category cat = catRepo.findById(1).orElse(null);
		System.out.println(cat);
		System.out.println("-----------------------------------");
		cat.getProds().forEach(System.out::println);
		
		*/
		
		/*
		 * queries
		 * ==========
		 * 1.Display brand name of a given product ID
		 * 2.Display all products for a given category title 'Laptop'
		 * 3.Display all products for a given brand title 'Apple'
		 *===============================================================
		 * 
		 * 
		 * 
		 */
		
		
		
		
		
		
		

	}

}
