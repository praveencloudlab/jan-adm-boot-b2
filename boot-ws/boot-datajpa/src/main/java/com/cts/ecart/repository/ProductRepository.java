package com.cts.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{ 
	
	//31 methods
	// DSL =>Domain specific language
	// Query => Annotation
	// loads data from csv file, xlsx files, json array files
	

}
