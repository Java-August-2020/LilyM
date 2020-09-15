package com.Lily.ProductsCategories.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Lily.ProductsCategories.models.Category;
import com.Lily.ProductsCategories.services.ManyToManyService;


@Controller
public class CategoryController {

	private  ManyToManyService service;
	
	public CategoryController(ManyToManyService serv) {
		this.service = serv;
	}
	
	//findAll
	//from back-end to front-end thru model (from database -findALL)
	@RequestMapping("/categories/all")
	public String index(Model model) {
	model.addAttribute("categories", service.findCategories());
	return "/categories/indexCat.jsp";
	}	
	//	CREATE Category
	//from front-end to back-end thru @RequestParam -parms entered by user
	@RequestMapping("/categories/new")
	public String newCat(@ModelAttribute("category") Category category) {
		return "/categories/newCat.jsp";
	}
	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public String createCat(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors())
			return "/categories/newCat.jsp";
			this.service.createCategory(category);
			return "redirect:/";
	}
	//show by id
	//When clicking on category -show All products for x category
	@RequestMapping("/categories/{id}")
	public String showCat(@PathVariable("id") Long id, Model model) {
			model.addAttribute("category", service.getCategory(id));
			return "/categories/showCat.jsp";
	}
	
}
