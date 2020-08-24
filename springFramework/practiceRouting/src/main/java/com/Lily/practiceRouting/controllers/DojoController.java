package com.Lily.practiceRouting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoController {

	@RequestMapping("/")
    public String index(@RequestParam(value="q", required=false) String searchQuery, Model model) {
		model.addAttribute("search", "searchQuery");
		return "index.jsp";
	}
	
//	@RequestMapping("/dojo")
//    public String index(Model model) {
//    //to test if the model is responding just print to the console below
//		System.out.println("This is coming from dojo");
//		return "index.jsp";
//	}
	
	//place any phrase or name after localhost808/dojo/xxxxx mapping
	@RequestMapping("/dojo/{name}")
    public String showName(@PathVariable("name") String userName, Model model) {
		model.addAttribute("userName", userName);
		return "index.jsp";
	}
	
}
