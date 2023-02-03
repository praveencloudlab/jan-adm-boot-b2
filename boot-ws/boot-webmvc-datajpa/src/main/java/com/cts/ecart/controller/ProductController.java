package com.cts.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Category;
import com.cts.ecart.entity.Product;
import com.cts.ecart.servive.BrandServiceImpl;
import com.cts.ecart.servive.CategoryServiceImpl;
import com.cts.ecart.servive.ProductServiceImpl;

@Controller
public class ProductController {

	@Autowired
	private CategoryServiceImpl csi;
	@Autowired
	private BrandServiceImpl bsi;
	
	@Autowired
	private ProductServiceImpl psi;
	
	
	@RequestMapping("/listAllProducts")
	public String findAllProducts(Model model){
		 List<Product> products = psi.findAll();
		 model.addAttribute("prods", products);
		 return "products";
	}
	
	

	@RequestMapping(value = "/loadProductForm")
	public String loadProductForm() {
		return "product-form";
	}

	@RequestMapping(value = "/loadProductFormV1")
	public String loadProductFormV1(Model model, @ModelAttribute Product prod) {

		// System.out.println(csi.getCategories());
		model.addAttribute("categories", csi.getCategories());
		model.addAttribute("product", prod);
		return "product-form2";
	}

	@RequestMapping(value = "/save")
	public String saveProduct(@RequestParam int productId, @RequestParam String productName, @RequestParam double price,
			@RequestParam String description) {
		System.out.println(productId);
		System.out.println(productName);
		System.out.println(price);
		System.out.println(description);
		return "index";
	}


	@RequestMapping("/loadcategoryNames")
	@ResponseBody
	public List<Brand> getCategories(@RequestParam int categoryId){
		return csi.getBrands(categoryId);
	}
	
	
	
	
	@RequestMapping(value = "/saveV1")
	public String saveProductV1(@ModelAttribute Product product, @ModelAttribute Category category,
			@ModelAttribute Brand brand) {

		
		//brand.getProds().add(product);
		psi.save(product);
		bsi.saveBrand(brand,product);
		System.out.println(product);
		System.out.println(brand);
		
		return "index";
	}

	@RequestMapping(value = "/")
	public String welcome() {
		return "index";
	}

	// map interface
	@RequestMapping(value = "/s1")
	public String f1(Model model) {
		System.out.println(">> ProductController :: f1 method");

		model.addAttribute("personName", "Praveen"); // request scope
		model.addAttribute("city", "London"); // request scope

		return "one";
	}

	// ModelAndView class
	@RequestMapping(value = "/s2")
	public ModelAndView f2(Model model) {
		System.out.println(">> ProductController :: f2 method");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("two");
		mav.addObject("user", "admin");
		mav.addObject("name", "James");

		return mav;
	}

	// ModelMap class
	@RequestMapping(value = "/s3")
	public String f3(ModelMap modelMap) {
		System.out.println(">> ProductController :: f3 method");

		modelMap.put("appname", "ecart application");

		return "three";
	}

}
