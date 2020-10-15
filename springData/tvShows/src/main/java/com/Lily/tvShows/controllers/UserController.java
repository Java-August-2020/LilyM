package com.Lily.tvShows.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Lily.tvShows.models.User;
import com.Lily.tvShows.services.UserService;
import com.Lily.tvShows.validators.UserValidator;


@Controller
public class UserController {
	@Autowired
	private UserValidator validator;
	@Autowired 
	private UserService uService;
	
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "landing.jsp";
	}
	
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User newUser, BindingResult result, HttpSession session) {
		validator.validate(newUser, result);
		if(result.hasErrors()) {
			// if there are any validation errors, return them to the index/landing page
			return "landing.jsp";
		}
		User u = this.uService.registerUser(newUser);
		session.setAttribute("user_id", u.getId());
		// if no validation errors, let ShowController show the dashboard.jsp
			return "redirect:viewShows/";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttrs, HttpSession session) {
	if(!this.uService.authenticateUser(email, password)) {
		redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
		return "redirect:/";
	}
	User user = this.uService.getByemail(email);
	session.setAttribute("user_id", user.getId());
	// if no validation errors, let ShowController show the dashboard.jsp
		return "redirect:viewShows/";
	}

	//TESTING------start
	 //findAll Shows  - TESTING need to add to test this piece -below
//	@Autowired 
//	private ShowService wService;
	
		//from back-end to front-end thru model (from database -findALL)
//		@RequestMapping("/viewShows")
//		public String display(Model model) {
//		model.addAttribute("shows", wService.getShows());
//		return "dashboard.jsp";
//		}
	//TESTING------end
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
