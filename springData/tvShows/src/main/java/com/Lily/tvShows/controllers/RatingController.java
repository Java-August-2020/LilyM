package com.Lily.tvShows.controllers;

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

import com.Lily.tvShows.models.Rating;
import com.Lily.tvShows.models.Show;
import com.Lily.tvShows.models.User;
import com.Lily.tvShows.services.RatingService;
import com.Lily.tvShows.services.ShowService;
import com.Lily.tvShows.services.UserService;


@Controller
public class RatingController {
	@Autowired 
	private RatingService rService;
	@Autowired
	private ShowService wService;
	@Autowired
	private UserService uService;
	
	//If no errors found at Registration/Login -Needed for fall back errors even though seems redundant from other controllers.
		//findAll Shows -directed to dashboard by the UserController
				//from back-end to front-end thru model (from database -findALL)
				@RequestMapping("/rater/viewShows")
				public String display(Model viewModel, HttpSession session ) {
					Long userId = (Long) session.getAttribute("user_id");
					if(userId == null) {
						return "redirect: /";
					}
					User loggedUser = this.uService.findAUser(userId);
					viewModel.addAttribute("user", loggedUser);
					viewModel.addAttribute("shows", wService.getShows());
					viewModel.addAttribute("ratings", rService.getAllRatings());
					return "dashboard.jsp";
				}
					
			//DISPLAY by showId (when clicking the showNameID on the dashboard -TeamController-show all users that rated this show 
			//Then will have button to add a rating
				@RequestMapping("/rater/{id}")
				public String usersThatRatedShow(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("show") Show show, @ModelAttribute("rating") Rating rating, HttpSession session ) {			
					Long userId = (Long) session.getAttribute("user_id");
					System.out.println(userId);
					viewModel.addAttribute("userID", userId);
					viewModel.addAttribute("show", this.wService.getById(id));
//					viewModel.addAttribute("ratings", rService.getAllRatings());
					viewModel.addAttribute("ratings", rService.getAllRatingsByShowId(id));
//					viewModel.addAttribute("users", uService.allUser());
					return "/shows/ratingShow.jsp";
				}						

				
				//CREATE -add a new Rating 
				//Display form first -When link is pressed on ratingShow.jsp to Rate this Show!  (href="/newRating" )
				@RequestMapping("/displayToAddRating/{id}")
					public String createRating(@PathVariable("id") Long id, @ModelAttribute("rating") Rating rating, @ModelAttribute("show") Show show, Model viewModel,HttpSession session) {
					viewModel.addAttribute("show", this.wService.getById(id));   //got show.id
					
					Long userId = (Long) session.getAttribute("user_id");     //do we need user.id?
			        User user=uService.findAUser(userId);
			        viewModel.addAttribute("user", user);
			        
//					viewModel.addAttribute("ratings", rService.getAllRatings());
					viewModel.addAttribute("ratings", rService.getAllRatingsByShowId(id));
					return "/newRating.jsp";   //display form
				}

				
					@PostMapping("/newRating/{id}")
//					public String create(@Valid @ModelAttribute("rating") Rating rating, BindingResult result, HttpSession session, Model viewModel) {
					public String create(@PathVariable("id") Long id, @Valid @ModelAttribute("rating") Rating rating, BindingResult result, @ModelAttribute("show") Show show, Model viewModel,HttpSession session) {
						viewModel.addAttribute("show", this.wService.getById(id));
				        
						if(result.hasErrors()) {
							System.out.println(result);
							//in error -repopulate fields 
							viewModel.addAttribute("show", this.wService.getById(id));
							
							Long userId = (Long) session.getAttribute("user_id");			
					        User user=uService.findAUser(userId);
					        viewModel.addAttribute("user", user);
					        
							viewModel.addAttribute("ratings", rService.getAllRatings());
//							viewModel.addAttribute("ratings", rService.getAllRatingsByShowId(id));
							return "/newRating.jsp";
						} else {
						
							this.rService.createRating(rating);
							return "redirect:viewShows/";
						}
					}
				
		
					
}
	