package com.Lily.eventsBeltReviewer.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Lily.eventsBeltReviewer.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

}