package com.Lily.tvShows.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.Lily.tvShows.models.User;
import com.Lily.tvShows.repositories.UserRepository;



@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		//These methods come from the User model -need to match
		//if Not user = !user
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Match", "Passwords do not match!!!!!!!!!!!!!!!!!!!!!");
		}
		
		// Make sure email is unique in the DB
		//getEmail comes from User Model but existsByEmail from the UserRepository
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Email is already taken");
		}
		
	}
}
