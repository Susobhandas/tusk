package com.boom.author_egar_lazy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {

	@Id
	@SequenceGenerator(name = "book_review_seq", sequenceName="review_seq" , allocationSize=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="book_review_seq")
	@Column(name="id")
	private int id;
	
	
	@Column(name="comments")
	private String comments;
	
	
	public Review() {
		
	}

	public Review(String comments) {
		
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
	
}
