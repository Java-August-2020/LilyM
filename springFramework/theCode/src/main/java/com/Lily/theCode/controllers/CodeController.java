package com.Lily.theCode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	private Boolean isCorrectCode(String guess) {
		return guess.equals("bushido");
	}
	private String[] getItems() {
		return new String[] {
			"Loyalty", "Courage", "Veracity", "Compassion", "Honor"
		};
	}
	@RequestMapping("/")
	public String Index() {
		return "index.jsp";
	}
	@RequestMapping(value="/attempt", method=RequestMethod.POST)
	public String Attempt(@RequestParam(value="guess") String guess, 
			Model model, RedirectAttributes  redirectAttributes) {
		if(isCorrectCode(guess)) {
			return "redirect:/code";
		}
		redirectAttributes.addFlashAttribute("error", "You must train harder");
		return "redirect:/";		
	}
	@RequestMapping("/code")
	public String Code(Model model) {
		model.addAttribute("items", getItems());
		return "code.jsp";
	
	}
	
}