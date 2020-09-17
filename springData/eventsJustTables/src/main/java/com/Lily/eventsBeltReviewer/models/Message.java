package com.Lily.eventsBeltReviewer.models;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="messages")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String content;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	//#3 now that Message.java has been created and it has being joined by Event.java -joined it
    //redo getters  
	//#4 -hummm came back and had 2 more getters/setters -so recheck Event and EventUser all good?
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private EventUser author;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;
    
	//constructor
	public Message() {
	}
	//special constructor -how do you know?
	public Message(EventUser author, Event event, String content) {
    	this.author = author;
    	this.event = event;
    	this.content = content;
    }

	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public EventUser getAuthor() {
		return author;
	}
	public void setAuthor(EventUser author) {
		this.author = author;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
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
    