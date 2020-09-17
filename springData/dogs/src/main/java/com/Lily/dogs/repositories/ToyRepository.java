package com.Lily.dogs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Lily.dogs.models.Toy;

@Repository
public interface ToyRepository extends CrudRepository<Toy, Long> {

}
