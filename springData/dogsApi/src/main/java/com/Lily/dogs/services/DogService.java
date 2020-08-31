package com.Lily.dogs.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Lily.dogs.repositories.DogRepository;
import com.Lily.dogs.models.Dog;

@Service
public class DogService {
	private DogRepository dRepo;
	
	
	public DogService(DogRepository repo) {
		this.dRepo = repo;
	}
	
	// getAll
	public List<Dog> getAllPets() {
		return this.dRepo.findAll();
	}
	
	// getOne
	public Dog getOneDog(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	// createDog
	public Dog createDog(Dog newDog) {
		return this.dRepo.save(newDog);
	}
	
	// updateDog
	public Dog updateDog(Long id, Dog updatedDog) {
		return this.dRepo.save(updatedDog);
	}
	
	// deleteDog
	public void deleteDog(Long id) {
		this.dRepo.deleteById(id);
	}
}
	