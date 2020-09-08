package com.Lily.dojoNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Lily.dojoNinjas.models.Dojo;
import com.Lily.dojoNinjas.models.Ninja;
import com.Lily.dojoNinjas.repositories.DojoRepository;
import com.Lily.dojoNinjas.repositories.NinjaRepository;

@Service
public class OneToManyService {
	private  DojoRepository dojoRepo;
	private NinjaRepository ninjaRepo;
	public OneToManyService(DojoRepository dRepo, NinjaRepository nRepo) {
		this.dojoRepo = dRepo;
		this.ninjaRepo = nRepo;
		
	}
	//FindAll -dojos/ninjas
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	public List<Ninja> allNinjas() {
		return  ninjaRepo.findAll();
	}
	//Create -dojos/ninjas
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	//FindDojo by id -dropdown
	public Dojo findDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
	
}
