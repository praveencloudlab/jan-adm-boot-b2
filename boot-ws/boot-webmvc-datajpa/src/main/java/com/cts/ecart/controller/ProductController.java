package com.cts.ecart.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.cts.ecart.model.Brand;
import com.cts.ecart.model.Category;
import com.cts.ecart.model.Product;
import com.cts.ecart.model.StoreInfo;
import com.cts.ecart.servive.CategoryServiceImpl;


@Controller
public class ProductController {
	
	@Autowired
	private CategoryServiceImpl csi;
	
	@RequestMapping(value = "/loadProductForm")
	public String loadProductForm() {
		return "product-form";
	}
	
	@RequestMapping(value = "/loadProductFormV1")
	public String loadProductFormV1(Model model,@ModelAttribute Product prod) {
		
		System.out.println(csi.getCategories());
		model.addAttribute("categories", csi.getCategories());		
		model.addAttribute("product", prod);
		return "product-form2";
	}
	
	@RequestMapping(value = "/save")
	public String saveProduct(@RequestParam int productId,@RequestParam String productName,@RequestParam double price,@RequestParam String description) {
		System.out.println(productId);
		System.out.println(productName);
		System.out.println(price);
		System.out.println(description);
		return "index";
	}
	
	
	@RequestMapping("/test")
	@ResponseBody
	public List<Category> test() {
		return csi.getCategories();
	}
	
	@RequestMapping(value = "/loadcategoryNames")
	@ResponseBody
	public List<Brand> loadStoreNames(@RequestParam("categoryId") int categoryId) {
		return csi.getBrands(categoryId);
	}
	
	@RequestMapping(value = "/saveV1")
	public String saveProductV1(@ModelAttribute Product product,@ModelAttribute Category category,@ModelAttribute Brand brand) {
		
		brand.getProds().add(product);
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
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("two");
		mav.addObject("user", "admin");
		mav.addObject("name", "James");
		
		return mav;
	}
	
	
	//ModelMap class
	@RequestMapping(value = "/s3")
	public String f3(ModelMap modelMap) {
		System.out.println(">> ProductController :: f3 method");
		
		modelMap.put("appname", "ecart application");
		
		return "three";
	}
	
	
	
	

}
