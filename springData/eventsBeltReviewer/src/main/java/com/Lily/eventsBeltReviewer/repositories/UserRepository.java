package com.Lily.eventsBeltReviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Lily.eventsBeltReviewer.models.EventUser;

@Repository
public interface UserRepository extends CrudRepository<EventUser, Long>{
	EventUser findByEmail(String email);
}