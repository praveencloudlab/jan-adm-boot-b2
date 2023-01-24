package com.cts.ecart.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.cts.ecart.model.Product;
@Repository
public class ProductRepositoryImpl {

	@Autowired
	private JdbcTemplate jt;
	
	
	//DML 
	public void save(Product prod) {
		jt.update("insert into product values(?,?,?)",prod.getId(),prod.getPrice(),prod.getName());
	}
	
	public void update(Product prod) {
		jt.update("update product set product_name=?,price=? where product_id=?",prod.getName(),prod.getPrice(),prod.getId());
	}
	
	
	
	
	// DRL

	// multiple row fetch
	public List<Map<String, Object>> fetchAll() {
		return jt.queryForList("select * from product");
	}

	// Single Row
	public Map<String, Object> findById(int id) {
		return jt.queryForMap("select * from product where product_id=?", id);
	}
	
	// Domain based fetching
	
	//1. RowMapper interface for multiple row fetching
	public List<Product> findAllByRowMapper(){
		List<Product> products = jt.query("select * from product", new RowMapperDemo());
		return products;
	}
	
	//2. RowMapper interface for multiple row fetching : filter
	public List<Product> findAllByRowMapperFilter(double price){
		List<Product> products = jt.query("select * from product where price>=?", new RowMapperDemo(),price);
		return products;
	}
	
	//3. RowMapper for single row fetch technique
	public Product findByIdRowMapper(int id) {
		Product product = jt.queryForObject("select * from product where product_id=?", new RowMapperDemo(),id);
		return product;
	}
	
	//ResultSetExtractor interface
	//===================================
	//4.Multiple row fetching using ResultSetExtractor
	public List<Product> findAllByResultSetExtractor() {
		List<Product> products = jt.query("select * from product", new ResultSetExtractorDemo());
		return products;
	}
	
	//5.Single row fetching using ResultSetExtractor
	public Product findByIdResultSetExtractor(int id) {
		return jt.query("select * from product where product_id=?", new ResultSetExtractorDemoV1(),id);
	}
	
	

}


class ResultSetExtractorDemoV1 implements ResultSetExtractor<Product>{
	@Override
	public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
		if(rs.next()) {
			Product prod=new Product();
			prod.setId(rs.getInt("product_id"));
			prod.setName(rs.getString("product_name"));
			prod.setPrice(rs.getDouble("price"));
			return prod;
		}
		
		return null;
	}
}

class ResultSetExtractorDemo implements ResultSetExtractor<List<Product>>{
	@Override
	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Product> prods=new ArrayList<>();
		
		while(rs.next()) {
			Product prod=new Product();
			prod.setId(rs.getInt("product_id"));
			prod.setName(rs.getString("product_name"));
			prod.setPrice(rs.getDouble("price"));
			prods.add(prod);
		}
		
		return prods;
	}
}

class RowMapperDemo implements RowMapper<Product>{
	
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product prod=new Product();
		prod.setId(rs.getInt("product_id"));
		prod.setName(rs.getString("product_name"));
		prod.setPrice(rs.getDouble("price"));
		return prod;
	}
}



