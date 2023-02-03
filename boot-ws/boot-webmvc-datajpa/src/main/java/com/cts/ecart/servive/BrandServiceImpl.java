package com.cts.ecart.servive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Product;
import com.cts.ecart.repository.BrandRepository;

@Service
public class BrandServiceImpl {
	@Autowired
	private BrandRepository brandRepo;
	
	public Brand saveBrand(Brand brand,Product prod) {
		Brand brandObj = brandRepo.findById(brand.getBrandId()).orElse(null);
	
		if(brandObj!=null) {
			brandObj.getProds().add(prod);
			return brandRepo.save(brandObj);
		}
		return null;
	}

}
