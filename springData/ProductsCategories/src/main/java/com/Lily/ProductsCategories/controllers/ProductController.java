package com.Lily.ProductsCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Lily.ProductsCategories.models.Category;
import com.Lily.ProductsCategories.models.Product;
import com.Lily.ProductsCategories.services.ManyToManyService;

@Controller
public class ProductController {
	private  ManyToManyService service;
	
	public ProductController(ManyToManyService serv) {
		this.service = serv;
	}
	//findAll
	//from back-end to front-end thru model (from database -findALL)
	@RequestMapping("/")
	public String index(Model model) {
	model.addAttribute("products", service.findProducts());
	return "index.jsp";
	}
	//CREATE Product
	//from front-end to back-end thru @RequestParam -parms entered by user
	@RequestMapping("/products/new")
	public String newProd(@ModelAttribute("product") Product product, Model model) {
		//need to show list of categories in the dropdown to choose from
		List<Category> categories = service.findCategories();
		model.addAttribute("categories", categories);
  	       //System.out.print(categories);
		return "/products/newProd.jsp";
	}
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors())
			return "/products/newProd.jsp";
			this.service.createProduct(product);
			return "redirect:/";
	}
	
	//show by id 
	//Show categories under "X" product(id)
		@RequestMapping("/{id}")
		public String show(@PathVariable("id") Long id, Model model) {
			model.addAttribute("product", service.getProduct(id));
			return "/products/showProd.jsp";
		}
}
