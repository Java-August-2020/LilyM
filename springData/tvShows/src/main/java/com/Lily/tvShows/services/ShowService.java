package com.Lily.tvShows.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lily.tvShows.models.Show;
import com.Lily.tvShows.repositories.ShowRepository;


@Service
public class ShowService {
	@Autowired
	private ShowRepository wRepo;
	
	//display all shows
	public List<Show> getShows(){
		return this.wRepo.findAll();
	}	
	//show only one show byID
	public Show getById(Long id) {
		return this.wRepo.findById(id).orElse(null);
	}
	//create show
	public Show create(Show show) {
		return this.wRepo.save(show);
	}	
	//update show
		public Show updateShow(Show updatedshow) {
			return this.wRepo.save(updatedshow);
		}	
	//delete show
		public void deleteShow(Long id) {
			this.wRepo.deleteById(id);
		}
}