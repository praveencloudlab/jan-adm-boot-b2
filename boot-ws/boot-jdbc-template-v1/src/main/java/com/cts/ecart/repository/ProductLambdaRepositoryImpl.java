package com.cts.ecart.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.ecart.model.Product;
@Repository
public class ProductLambdaRepositoryImpl {

	@Autowired
	private JdbcTemplate jt;
	
	
	/*
	 * RowMapper : method (2 params)
	 * ResultSetExtractor (1 param)
	 * 
	 *  Threads : Runnable => run : no params
	 * 
	 * 
	 * 
	 */
	
	
	 public void test() {
		
	}
	
	
	  //RowMaper : multiple rows fetch
	 public List<Product> findAllRowMapper(){
		 
		 return jt.query("select * from product", (rs,rowNo)->new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getDouble("price")));
	 }
	 
	 //single row operations: find
	 public Product findByIdRowMapper(int id) {
		 return jt.queryForObject("select * from product where product_id=?", (rs,rowNo)->new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getDouble("price")),id);
	}
	
	 //ResultSetExtractor
	 //Fetch all rows
	 public List<Product> findAllResultSetExtractor() {
		 
		 return jt.query("select * from product", (rs)->{
			List<Product> prodsList=new ArrayList<>();
			 while(rs.next()) {
				 Product prod=new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getDouble("price"));
				 prodsList.add(prod);
			 }
			 return prodsList;
		 });	
	}
	 
	 
	// find single record : ResultSetExtractor
	 public Product findByIdResultSetExtractor(int id) {
		return jt.query("select * from product where product_id=?", (rs)->{
			if(rs.next()) {
				 Product prod=new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getDouble("price"));
				 return prod;
			}
			return null;
		},id);
	}
	 
}







