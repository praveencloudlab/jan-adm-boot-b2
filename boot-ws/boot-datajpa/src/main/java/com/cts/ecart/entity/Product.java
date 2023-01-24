package com.cts.ecart.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; // JEE 9
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity(name = "products")
@DynamicUpdate(true )
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // SEQUENCE
	private int productId; // product_id
	@Column(length = 80)
	private String productName; // product_name
	private double price;
	
	public Product(String productName, double price) {
		this.productName = productName;
		this.price = price;
	}
	
	
	
	
	
	
	
}
