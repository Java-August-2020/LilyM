package com.Lily.relationships.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Lily.relationships.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findAll();
	List<Person> findByNoLicense();
	
	@Query(value="SELECT p.* FROM persons p LEFT OUTER JOIN licenses c ON p.id = c.person_id WHERE c.id IS NULL", nativeQuery=true)
	List<Person> findByLicenseIdIsNull();
}
