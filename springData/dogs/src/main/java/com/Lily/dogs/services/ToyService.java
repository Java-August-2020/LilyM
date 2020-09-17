package com.Lily.dogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lily.dogs.models.Toy;
import com.Lily.dogs.repositories.ToyRepository;

@Service
public class ToyService {
	@Autowired
	private ToyRepository tRepo;
	
	// Create Toy For Dog
	public Toy create(Toy toy) {
		return this.tRepo.save(toy);
	}
}