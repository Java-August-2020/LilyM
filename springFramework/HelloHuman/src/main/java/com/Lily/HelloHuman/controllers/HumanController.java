package com.Lily.HelloHuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HumanController {
	
	@RequestMapping("/")
    public String index(@RequestParam(value="firstname", required=false) String nameQuery, Model model)  {
			
		
//public String index(@RequestParam(value="firstname", required=false) String nameQuery, Model model, @RequestParam(value="lastname", required=false) String nameQuery2)  {
			
		if (nameQuery == null) {
			model.addAttribute("savedName", "Human");
			
		}else {
			model.addAttribute("savedName", nameQuery);
		}
		
		
		return "indexHuman.jsp";
		
	}
	
	
}
