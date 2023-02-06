package com.cts.ecart.servive;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Category;
import com.cts.ecart.repository.BrandRepository;
import com.cts.ecart.repository.CategoryRepository;

@Service
public class CategoryServiceImpl {
	
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private BrandRepository brandRepo;
	
	List<Category> categories=new ArrayList<>();
	
	public Category save(Category cat) {
		return catRepo.save(cat);
	}

	public List<Category> getCategories(){
		categories= catRepo.findAll();
		return categories;
	}
	
	public Category findById(int categoryId) {
		return catRepo.findById(categoryId).orElse(null);
	}
	
	public List<Brand> getBrands(int categoryId){
		   System.out.println(">>> "+categoryId);
		   System.out.println(categories);
		   Category catObj = catRepo.findAll().stream()
				   .filter(cat->cat.getCategoryId()==categoryId)
				   .findFirst()
				   .orElse(null);
		   return catObj.getBrands();
	}
	
	

}
