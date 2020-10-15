package com.Lily.tvShows.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Lily.tvShows.models.Show;


@Repository
public interface ShowRepository extends CrudRepository<Show, Long>{
	List<Show> findAll();
}