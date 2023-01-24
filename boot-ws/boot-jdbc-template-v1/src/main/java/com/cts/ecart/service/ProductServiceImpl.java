package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.ecart.model.Product;
import com.cts.ecart.repository.ProductRepositoryImpl;

@Service
@EnableTransactionManagement
public class ProductServiceImpl {
	
	@Autowired
	private ProductRepositoryImpl prodRepo;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void operations() {
		prodRepo.save(new Product(109,"Toy",13500));
		prodRepo.update(new Product(1,"Ball Pen",340));	
	}

}
