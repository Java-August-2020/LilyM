package com.Lily.dogs.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Lily.dogs.models.Dog;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long>{
	List<Dog> findAll();
    List<Dog> findByBreed(String breed);
}
