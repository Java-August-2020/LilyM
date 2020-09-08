package com.Lily.relationships.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Lily.relationships.models.License;
import com.Lily.relationships.models.Person;
import com.Lily.relationships.repositories.LicenseRepository;
import com.Lily.relationships.repositories.PersonRepository;

@Service
public class OneToOneService {
	private  PersonRepository personRepo;
	private  LicenseRepository licRepo;
	public OneToOneService(PersonRepository pRepo, LicenseRepository licRepo) {
		this.personRepo = pRepo;
		this.licRepo = licRepo;
	}
	//findAll
	public List<Person> getPeople() {
		return personRepo.findAll();
	}
	public Person getPerson(Long id) {
		return personRepo.findById(id).orElse(null);
	}
	
	public List<Person> getUnlicensedPeople() {
		return personRepo.findByLicenseIdIsNull();
	}
	public Person createPerson(Person p) {
		return personRepo.save(p);
	}
	public License createLicense(License lic) {
		lic.setNumber(this.generateLicenseNumber());
		return licRepo.save(lic);
	}
	public int generateLicenseNumber() {
		License lic = licRepo.findTopByOrderByNumberDesc();
		if(lic == null)
			return 1;
		int lastNumber = lic.getNumber();
		lastNumber++;
		return (lastNumber);
	}
	
}