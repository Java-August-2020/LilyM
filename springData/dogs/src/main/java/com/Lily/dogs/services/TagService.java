package com.Lily.dogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lily.dogs.models.Tag;
import com.Lily.dogs.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	
	// Create a Tag
	public Tag create(Tag tag) {
		return this.tRepo.save(tag);
	}
}
