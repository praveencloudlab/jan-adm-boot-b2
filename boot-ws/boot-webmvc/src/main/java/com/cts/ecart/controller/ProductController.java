package com.cts.ecart.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.cts.ecart.model.Product;
import com.cts.ecart.model.StoreInfo;


@Controller
public class ProductController {
	
	private List<String> storeLocations=Arrays.asList("Chennai","Mumbai","Hyderabad","Pune","Kolkatha","Delhi","Kerala");
	
	@RequestMapping(value = "/loadProductForm")
	public String loadProductForm() {
		return "product-form";
	}
	
	@RequestMapping(value = "/loadProductFormV1")
	public String loadProductFormV1(Model model) {
		
		model.addAttribute("stores", storeLocations);		
		
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
	
	@RequestMapping(value = "/loadStoreNames")
	public String loadStoreNames(@RequestParam("storeInfo.location") String location) {
		
		System.out.println(">>>> working ... "+location);
		
		return "product-form2";
	}
	
	@RequestMapping(value = "/saveV1")
	public String saveProductV1(@ModelAttribute Product product) {
		System.out.println(product);
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
