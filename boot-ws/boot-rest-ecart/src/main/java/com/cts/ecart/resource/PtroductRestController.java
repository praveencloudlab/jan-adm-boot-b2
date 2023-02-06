package com.cts.ecart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Category;
import com.cts.ecart.entity.Product;
import com.cts.ecart.servive.BrandServiceImpl;
import com.cts.ecart.servive.CategoryServiceImpl;
import com.cts.ecart.servive.ProductServiceImpl;
@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class PtroductRestController {
	
	@Autowired
	private ProductServiceImpl psi;
	@Autowired
	private CategoryServiceImpl csi;
	@Autowired
	private BrandServiceImpl bsi;
	
	
	// load all products
	@GetMapping
	public List<Product> findAll(){
		return psi.findAll();
	}
	
	
	@GetMapping("/{productId}")
	public Product findById(@PathVariable int productId) {
		return psi.findById(productId);
	}
	
	@GetMapping(value = "/filter/productName/{productTitle}")
	public List<Product> filterByName(@PathVariable String productTitle){
		
		return psi.findByProductTitleLike(productTitle);
	}
	
	
	@PostMapping("/{brandId}")
	public Product saveProduct(@PathVariable int brandId,@RequestBody Product product) {

		Brand brand = bsi.findById(brandId);		
		Product prod = psi.save(product);
		bsi.saveBrand(brand, prod);
		
		return prod;
	}
	
	@PostMapping("/{categoryId}/{brandId}")
	public Product saveProductV1(@PathVariable int categoryId, @PathVariable int brandId,@RequestBody Product product) {
		Category category = csi.findById(categoryId);
		category.getMapProducts().add(product);
		Product prod = psi.save(product);
		csi.save(category);
		Brand brand = bsi.findById(brandId);		
		bsi.saveBrand(brand, prod);
		
		return prod;
	}
	
	
	
	
	
	
	
	
	
	
	

}
