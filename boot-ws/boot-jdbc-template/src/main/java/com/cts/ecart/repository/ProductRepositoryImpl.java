package com.cts.ecart.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl {
	
	@Autowired
	private JdbcTemplate jt;
	
	
	// load all records from table
	
	
	/*
	 * Spring JDBC Template
	 * ================================
	 * 1.DML operations
	 * 2.DRL operations
	 * 
	 * 2.DRL operations
	 * ====================
	 * 1. Using Single row operations
	 * 		-> Generic maps
	 * 		-> domain class specific operations
	 * 2. Multiple row operations
	 * 		-> maps
	 * 		-> domain class specific operations
	 */
	
	
	
	 public List<Map<String,Object>> fetchAll() {
		 return jt.queryForList("select * from product");
	 }
	 
	 
	 // Single Row
	 public Map<String, Object> findById(int id){
		 return jt.queryForMap("select * from product where product_id=?",id);
	 }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
