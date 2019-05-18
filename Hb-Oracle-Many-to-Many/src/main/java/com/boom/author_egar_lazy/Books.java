package com.boom.author_egar_lazy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Books {

	@Id
	@SequenceGenerator(name = "bk_seq", sequenceName="books_seq" , allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bk_seq")
	@Column(name="id")
	private int id;
	
	
	@Column(name="Book_title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name="Author_id")
	private Author author_id;
	
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="Book_id")
	private List<Review> reviews;

	public Books() {
		
	}

	public Books(String title) {
	
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Author author_id) {
		this.author_id = author_id;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author_id=" + author_id + "]";
	}
	
	
	
	public void addReview(Review review) {
		
		if(reviews==null)
			reviews=new ArrayList<Review>();
		
		reviews.add(review);
	}
	
	
	
	
}
