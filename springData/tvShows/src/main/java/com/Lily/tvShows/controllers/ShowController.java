package com.Lily.tvShows.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Lily.tvShows.models.Show;
import com.Lily.tvShows.models.User;
import com.Lily.tvShows.services.RatingService;
import com.Lily.tvShows.services.ShowService;
import com.Lily.tvShows.services.UserService;



@Controller
public class ShowController {
	@Autowired 
	private ShowService wService;
	@Autowired
	private UserService uService;
	@Autowired
	private RatingService rService;
	


	//If no errors found at Registration/Login
	//findAll Shows -directed to dashboard by the UserController
			//from back-end to front-end thru model (from database -findALL)
			@RequestMapping("/viewShows")
			public String display(Model viewModel, HttpSession session ) {
				Long userId = (Long) session.getAttribute("user_id");
				if(userId == null) {
					return "redirect: /";
				}
				User loggedUser = this.uService.findAUser(userId);
				viewModel.addAttribute("user", loggedUser);
				viewModel.addAttribute("shows", wService.getShows());
				return "dashboard.jsp";
			}
	
	//CREATE 
	//Display form and get front-end to back-end thru @RequestParam -parms entered by user
		@RequestMapping("/shows/new")
		public String newShow(@ModelAttribute("show") Show show, HttpSession session, Model viewModel) {
			//need users list to link to shows??
			List<User> usersListShow = uService.allUser();
			viewModel.addAttribute("usersListShow", usersListShow);
	  	       //System.out.print(usersListShow);
			
			//the userID will be displayed on dashboard:  Welcome userxxx
			Long userId = (Long) session.getAttribute("user_id");
			viewModel.addAttribute("userID", userId);
			return "/shows/newShow.jsp";
		}
		//Add to database
			//@RequestMapping(value="/addShows", method=RequestMethod.POST)
		@PostMapping("/addShows")
		public String create(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session, Model viewModel) {
			if(result.hasErrors()) {
				System.out.println(result);
				//in error -repopulate fields 
				Long userId = (Long) session.getAttribute("user_id");
				viewModel.addAttribute("userID", userId);
				return "/shows/newShow.jsp";
			} else {
			
				this.wService.create(show);
				return "redirect:viewShows/";
			}
		}
	
	//----test here calling ratingShow.jsp with maybe "/rate/{id}"   ---------------
		
		
	//--------------------------------------------------------------------------------
		
		//show by id 
			@RequestMapping("/{id}")
			public String show(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("show") Show show, HttpSession session) {
				viewModel.addAttribute("show", this.wService.getById(id));
				
				Long userId = (Long) session.getAttribute("user_id");			
		        User user=this.uService.findAUser(userId);
		        viewModel.addAttribute("user", user);
		        
		        System.out.println(user);
		        
				return "/shows/showShow.jsp";
			}

	//update
			@PostMapping("/{id}")
			public String update(@Valid @ModelAttribute("show")  Show updatedShow, BindingResult result, HttpSession session, Model viewModel) {
					if(result.hasErrors()) {
						return "/shows/showShow.jsp";
					} else {
						Long userId = (Long) session.getAttribute("user_id");
						viewModel.addAttribute("userID", userId);
						this.wService.updateShow(updatedShow);
						return "redirect:viewShows/";
					}
			}		
		
			
	//delete
			@GetMapping(value="/delete/{id}")
			public String delete(@PathVariable("id") Long id) {
				this.wService.deleteShow(id);
				return "redirect:/viewShows";
//				return "redirect:/";
				}
			
			
}
			
	
			
			
