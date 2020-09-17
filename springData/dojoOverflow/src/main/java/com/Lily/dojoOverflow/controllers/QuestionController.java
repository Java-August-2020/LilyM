package com.Lily.dojoOverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Lily.dojoOverflow.models.Answer;
import com.Lily.dojoOverflow.models.NewQuestion;
import com.Lily.dojoOverflow.services.AppService;

@Controller
public class QuestionController {
	private final AppService service;
	public QuestionController(AppService service) {
		this.service = service;
	}
	//Display all Questions
	@GetMapping("/")
	public String Index(Model model) {
		model.addAttribute("questions", this.service.getQuestions());
		return "index.jsp";
	}
	//Create New Question
	@GetMapping("/new")
	public String New(@ModelAttribute("newQuest") NewQuestion newQuest) {
		return "new.jsp";
	}
	@PostMapping("/")
	public String Create(@Valid @ModelAttribute("newQuest") NewQuestion newQuest, 
		BindingResult result) {
		if(result.hasErrors())
			return "new.jsp";
		this.service.createQuestion(newQuest);
		return "redirect:/";
	}
	
	//Show specific question 
	@GetMapping("/{id}")
	public String Show(@PathVariable("id") Long id, @ModelAttribute("ans") Answer ans, Model model) {
		model.addAttribute("question", this.service.getQuestion(id));
		return "show.jsp";
	}
	
	
	//try Reena's code
	@PostMapping("/answers")
	public String CreateAnswer(@Valid @ModelAttribute("ans") Answer ans,  BindingResult result) {
//		public String CreateAnswer(@Valid @ModelAttribute("ans") Answer ans,  BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			
			//need to fix here when in error -redisplay 
				//System.out.println(ans.getQuestion().getId());

			return "show.jsp";}
		Answer newAnswer = this.service.createAnswer(ans);
		return "redirect:/" + newAnswer.getQuestion().getId();
	}

	
}	