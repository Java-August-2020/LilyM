package com.Lily.dojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.Lily.dojoOverflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
	//	List<Answer> findAll();
}