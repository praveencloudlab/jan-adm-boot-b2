package com.cts.ecart.servive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cts.ecart.model.Brand;
import com.cts.ecart.model.Category;

@Service
public class CategoryServiceImpl {

	List<Category> categories = Arrays.asList(new Category(1, "Laptops"), new Category(2, "Mobiles"),
			new Category(3, "Cloths"), new Category(4, "Speakers"));

	List<Brand> brands = Arrays.asList(new Brand(1, "Apple", 1), new Brand(2, "Dell", 1), new Brand(3, "Levevo", 1),
			new Brand(4, "HP", 1), new Brand(5, "Apple", 2), new Brand(6, "Samsung", 2), new Brand(7, "One Plus", 2),
			new Brand(8, "LP", 3), new Brand(9, "Levise", 3), new Brand(10, "Sony", 4), new Brand(11, "Boss", 4),
			new Brand(12, "JBL", 4)

	);

	public List<Category> getCategories() {
		return categories;
	}

	public List<Brand> getBrands(int categoryId) {
		return brands.stream().filter(brand->brand.getCategoryId()==categoryId).collect(Collectors.toList());
	}

}
