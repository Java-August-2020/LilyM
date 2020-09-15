package com.Lily.dojoNinjas.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Lily.dojoNinjas.models.Ninja;
import com.Lily.dojoNinjas.services.OneToManyService;

@Controller
public class NinjaController {

	private  OneToManyService service;
	
	public NinjaController(OneToManyService serv) {
		this.service = serv;
	}
	
	//from back-end to front-end thru model (from database -findALL)
	@RequestMapping("/ninjas/all")
	public String index(Model model) {
	model.addAttribute("ninjas", service.allNinjas());
	return "/ninjas/indexNinjas.jsp";
	}	
	//	CREATE
	//from front-end to back-end thru @RequestParam -parms entered by user
	@RequestMapping("/ninjas/new")
	public String create(@ModelAttribute("ninja") Ninja ninja, Model model) {
	model.addAttribute("dojos", this.service.allDojos());
	return "/ninjas/newNinja.jsp";
	}
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", this.service.allDojos());
			return "/ninjas/newNinja.jsp";
		}
			this.service.createNinja(ninja);
			return "redirect:/";
	}	
}
