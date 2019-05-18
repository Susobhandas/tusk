package com.boom.author_egar_lazy;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Author")
public class Author {
	
	
	@Id
	@SequenceGenerator(name = "auth_seq", sequenceName="author_seq" , allocationSize=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="auth_seq")
	@Column(name="id")
	private int author_id;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Author_details_id")
	private AuthorDetails details_id;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="author_id", cascade={CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private List<Books> books;


	public Author() {
	
	}


	public Author(String firstname, String lastname, String email) {
	
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}


	public int getAuthor_id() {
		return author_id;
	}


	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public AuthorDetails getDetails_id() {
		return details_id;
	}


	public void setDetails_id(AuthorDetails details_id) {
		this.details_id = details_id;
	}


	public List<Books> getBooks() {
		return books;
	}


	public void setBooks(List<Books> books) {
		this.books = books;
	}


	
	
	

}
