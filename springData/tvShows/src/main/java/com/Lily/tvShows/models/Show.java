package com.Lily.tvShows.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="shows")
public class Show {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String title;
	@NotBlank
	private String network;
//	@Min(1)
//	@Max(5)
//	private double ratingAvg;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	
//	#2 Join OneShow to ManyRatings
	@OneToMany(mappedBy="show", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Rating>  ratings;
	
	
//	//the first join happened on Model User.java -the joins are opposite to this model (Wedding.java)
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//    		name="rated",
//        joinColumns = @JoinColumn(name = "show_id"), 
//        inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<User> users;
   
    
    //constructor
	public Show() {	
	}
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	//Join#2  OneShowOneRating
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	//join
//		public List<User> getUsers() {
//		return users;
//	}
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
		public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
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
