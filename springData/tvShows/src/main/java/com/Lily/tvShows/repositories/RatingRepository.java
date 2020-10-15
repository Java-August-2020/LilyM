package com.Lily.tvShows.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Lily.tvShows.models.Rating;

@Repository

public interface RatingRepository extends CrudRepository<Rating, Long> {
List<Rating> findAll();
List<Rating> findRatingByShowId(long showId);

}
