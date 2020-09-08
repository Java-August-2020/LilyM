package com.Lily.relationships.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Lily.relationships.models.Person;
import com.Lily.relationships.models.License;
import com.Lily.relationships.services.OneToOneService;

@Controller
public class OneToOneController {
	private  OneToOneService service;
	
	public OneToOneController(OneToOneService serv) {
		this.service = serv;
	}
	
	//from back-end to front-end thru model (from database -findALL)
	@RequestMapping("/")
	public String Index(Model model) {
		List<Person> people = service.getPeople();
		model.addAttribute("persons", people);
		return "index.jsp";
	}
	
	//PERSON	
	//from front-end to back-end thru @RequestParam -parms entered by user
		@RequestMapping("/new")
		public String newPerson(@ModelAttribute("person") Person person) {
			return "newPerson.jsp";
		}
		@RequestMapping(value="/new", method=RequestMethod.POST)
		public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, @RequestParam Map<String,String> body) {
			if(result.hasErrors() ) {
				return "newPerson.jsp";
			}
			service.createPerson(person);
			return "redirect:/";
		}
		//LICENSE
		@RequestMapping("/licenses/new")
		public String newLic(@ModelAttribute("license") License lic, Model model) {
			List<Person> unlicensed = service.getUnlicensedPeople();
			model.addAttribute("persons", unlicensed);
			return "/licenses/newLicense.jsp";
		}
		@RequestMapping(value = "/licenses", method=RequestMethod.POST)
		public String createLic(@Valid @ModelAttribute("license") License lic, BindingResult result) {
			if(result.hasErrors())
				return "/licenses/newLicense.jsp";
			service.createLicense(lic);
			return "redirect:/";
		}
		
		//show
		@RequestMapping("/{id}")
		public String showPerson(@PathVariable("id") Long id, Model model) {
			model.addAttribute("person", service.getPerson(id));
			return "show.jsp";
		}
	
}
