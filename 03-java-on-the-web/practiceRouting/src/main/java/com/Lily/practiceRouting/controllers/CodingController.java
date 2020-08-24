package com.Lily.practiceRouting.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {

	@RequestMapping("")
	public String rootHello() {
	return "Hello Coding Dojo! Are you there?";
	}
	
	@RequestMapping("/python")
	public String pythonHello() {
	return "Python/Django was awesome!";
	}
	
	@RequestMapping("/java")
	public String javaHello() {
	return "Java/Spring is better!";
	}
	
	
}