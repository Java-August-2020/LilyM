package com.Lily.dojoNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Lily.dojoNinjas.models.Dojo;
import com.Lily.dojoNinjas.services.OneToManyService;

@Controller
public class DojoController {
	
	private  OneToManyService service;
	
	public DojoController(OneToManyService serv) {
		this.service = serv;
	}
	//from back-end to front-end thru model (from database -findALL)
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojos", service.allDojos());
		return "index.jsp";
	}
	//DOJO
	//from front-end to back-end thru @RequestParam -parms entered by user
	@RequestMapping("/dojos/new")
	public String New(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/newDojo.jsp";
	}
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors())
			return "/dojos/newDojo.jsp";
		this.service.createDojo(dojo);
		return "redirect:/";
	}
	//show by id
	@RequestMapping("/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", this.service.findDojo(id));
		return "/dojos/showDojo.jsp";
	}
	
}