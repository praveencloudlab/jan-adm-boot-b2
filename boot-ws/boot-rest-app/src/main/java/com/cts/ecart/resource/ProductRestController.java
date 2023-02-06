package com.cts.ecart.resource;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
	
	@GetMapping
	public String f1() {
		return "GET mapping";
	}
	
	@GetMapping("/{productId}")
	public String f1111(@PathVariable int productId) {
		return "GET mapping - f1111 - "+productId;
	}
	
	@GetMapping("/{id}/{name}/{price}")
	public String f11111(@PathVariable int id,@PathVariable String name,@PathVariable double price) {
		System.out.println("ID: "+id+" name: "+name+" and price: "+price);
		return "ID: "+id+" name: "+name+" and price: "+price;
	}
	
	@GetMapping(value = "r1")
	public String f11() {
		return "GET mapping - r - f11";
	}
	
	@GetMapping(value = "r2")
	public String f111() {
		return "GET mapping - r2 - f111";
	}
	
	@PostMapping
	public Product f2(@RequestBody Product product) {
		// read product object from client
		System.out.println(">>> "+product);
		return product;
	}
	
	@PostMapping(value = "all")
	public List<Product> f22(@RequestBody List<Product> products) {
		// read product object from client
		System.out.println(">>> "+products);
		return products;
	}
	
	@PutMapping
	public String f3() {
		return "PUT";
	}
	
	@DeleteMapping
	public String f4() {
		return "DELETE mapping";
	}

}
