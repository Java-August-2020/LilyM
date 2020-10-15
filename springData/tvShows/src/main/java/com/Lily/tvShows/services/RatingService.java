package com.Lily.tvShows.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Lily.tvShows.models.Rating;
import com.Lily.tvShows.repositories.RatingRepository;
import com.Lily.tvShows.repositories.ShowRepository;
import com.Lily.tvShows.repositories.UserRepository;

@Service
public class RatingService {
@Autowired
private RatingRepository rRepo;
@Autowired
private ShowRepository wRepo;
@Autowired
private UserRepository uRepo;
	
	
	
	//display all ratings
		public List<Rating> getAllRatings(){
			return this.rRepo.findAll();
		}	
		//display only one Rating byID
		public Rating getRatingById(Long id) {
			return this.rRepo.findById(id).orElse(null);
		}
	
		//all ratings by specific showId
		public List<Rating> getAllRatingsByShowId(Long showId) {
			return this.rRepo.findRatingByShowId(showId);
		}
		
		//just create for now
		public Rating createRating(Rating rating) {
			return this.rRepo.save(rating);
		}	
		
	
}

