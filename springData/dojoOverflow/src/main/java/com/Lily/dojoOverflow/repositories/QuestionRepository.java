package com.Lily.dojoOverflow.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.Lily.dojoOverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();
}