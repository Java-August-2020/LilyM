package com.Lily.dogs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Lily.dogs.models.Dog;
import com.Lily.dogs.models.Tag;
import com.Lily.dogs.models.User;
import com.Lily.dogs.services.DogService;
import com.Lily.dogs.services.TagService;
import com.Lily.dogs.services.UserService;
import com.Lily.dogs.validators.UserValidator;

@Controller
public class DogController {
	@Autowired
	private DogService dService;
	@Autowired
	private TagService tService;
	@Autowired
	private UserService uSerivce;
	@Autowired
	private UserValidator validator;
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "landing.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			// if there are validation errors, throw them back to the root route
			return "landing.jsp";
		}
		User newUser = this.uSerivce.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dogs";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uSerivce.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		
		User user = this.uSerivce.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/dogs";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/likes/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long dogId = id;
		User liker = this.uSerivce.getOneUser(userId);
		Dog likedDog = this.dService.getOneDog(dogId);
		this.dService.addLiker(liker, likedDog);
		return "redirect:/dogs";
	}
	
	@RequestMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long dogId = id;
		User unliker = this.uSerivce.getOneUser(userId);
		Dog likedDog = this.dService.getOneDog(dogId);
		this.dService.removeLiker(unliker, likedDog);
		return "redirect:/dogs";
	}
	
	@RequestMapping("/dogs")
	public String dogs(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		User loggedUser = this.uSerivce.getOneUser(userId);
		List<Dog> dogs = this.dService.getAllPets();
		viewModel.addAttribute("allDogs", dogs);
		viewModel.addAttribute("user", loggedUser);
		return "index.jsp";
	}
	
	
	@PostMapping("/")
	public String createNew(@Valid @ModelAttribute("dog") Dog newDog, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("userID", userId);
			return "new.jsp";
		} else {
			this.dService.createDog(newDog);
			return "redirect:/";
		}

	}
	
	//Antiquated Way
	// @RequestMapping(value="/", method=RequestMethod.POST)
	@PostMapping("/oldway")
	public String createOldWay(@RequestParam("name") String name, @RequestParam("breed") String breed, @RequestParam("age") int age, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("hey there, you forgot to add a name");
		}
		
		if(errors.size() > 0) {
			for(String e: errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/new";
		}
		this.dService.createDog(name, breed, age);
		return "redirect:/";
	}
	
	
	
	@RequestMapping("/new")
	public String create(@ModelAttribute("dog") Dog dog, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("userID", userId);
		return "new.jsp";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("dog") Dog dog, @ModelAttribute("tag") Tag tag, HttpSession session) {
		viewModel.addAttribute("dog", dService.getOneDog(id));		
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("userID", userId);
		return "show.jsp";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String updatePet(@Valid @ModelAttribute("dog") Dog updatedDog, BindingResult result, @ModelAttribute("tag") Tag tag) {
		if(result.hasErrors()) {
			return "show.jsp";
		} else {
			dService.updateDog(updatedDog);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/users/{id}")
	public String userProfile(@PathVariable Long id, Model viewModel){
			viewModel.addAttribute("user", this.uSerivce.getOneUser(id));
			return "profile.jsp";
	}
	
	@PostMapping("/tag")
	public String createTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model viewModel, HttpSession session) {
		Long dogId = tag.getDog().getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("dog", dService.getOneDog(dogId));
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("userID", userId);
			return "show.jsp";
		} else {
			this.tService.create(tag);
			return "redirect:/" + dogId;
		}
	}
}
