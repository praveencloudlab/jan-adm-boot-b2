package com.cts.ecart.model;

import java.util.ArrayList;
import java.util.List;

public class Brand {

	private int brandId;
	private String brandTitle;
	private int categoryId;
	
	
	List<Product> prods=new ArrayList<>();

	public Brand() {
		// TODO Auto-generated constructor stub
	}

	public Brand(int brandId, String brandTitle, int categoryId) {
		super();
		this.brandId = brandId;
		this.brandTitle = brandTitle;
		this.categoryId = categoryId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandTitle=" + brandTitle + ", categoryId=" + categoryId + ", prods="
				+ prods + "]";
	}

	
}
