package com.Lily.tvShows.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ratings")

public class Rating {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	@Min(1)
	@Max(5)
	private int rating;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User rater;    //comes from model USER mappedBy
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="show_id")
	private Show show;    //will come from SHOW mappedBy
	
	//#2 Join OneRatingperShow
//	@OneToOne(mappedBy="rateoneshow", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private Show show;


	//constructor
	public Rating() {
	}

	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public User getRater() {
		return rater;
	}
	public void setRater(User rater) {
		this.rater = rater;
	}
	
	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	//record  before it exists and before it is updated
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
