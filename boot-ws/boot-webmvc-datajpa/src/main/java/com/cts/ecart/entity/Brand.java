package com.cts.ecart.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity(name = "brands")
@DynamicUpdate
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int brandId;
	private String brandTitle;
	
	
	@OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name ="brand_info",
		joinColumns = {@JoinColumn(name="brandId")},
		inverseJoinColumns = {@JoinColumn(name="productId")})
	List<Product> prods=new ArrayList<>();

	public Brand() {
		// TODO Auto-generated constructor stub
	}

	public Brand(int brandId, String brandTitle) {
		super();
		this.brandId = brandId;
		this.brandTitle = brandTitle;
		
	}

	
	
	public List<Product> getProds() {
		return prods;
	}

	public void setProds(List<Product> prods) {
		this.prods = prods;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandTitle() {
		return brandTitle;
	}

	public void setBrandTitle(String brandTitle) {
		this.brandTitle = brandTitle;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandTitle=" + brandTitle + ", prods=" + prods + "]";
	}

	

	
}
