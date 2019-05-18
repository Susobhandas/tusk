package com.boom.author_egar_lazy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="AUTHOR_DETAILS")
public class AuthorDetails {
	
	@Id
	@SequenceGenerator(name = "auth_detail_seq", sequenceName="author_details_seq" , allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="auth_detail_seq")
	@Column(name="id")
	private int id;
	
	@Column(name="Production")
	private String production;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="details_id",cascade=CascadeType.ALL)
	private Author author_id;
	
	

	public AuthorDetails() {
	
	}



	public AuthorDetails(String production, String hobby) {
		
		this.production = production;
		this.hobby = hobby;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getProduction() {
		return production;
	}



	public void setProduction(String production) {
		this.production = production;
	}



	public String getHobby() {
		return hobby;
	}



	public void setHobby(String hobby) {
		this.hobby = hobby;
	}



	public Author getAuthor_id() {
		return author_id;
	}



	public void setAuthor_id(Author author_id) {
		this.author_id = author_id;
	}



	@Override
	public String toString() {
		return "AuthorDetails [id=" + id + ", production=" + production + ", hobby=" + hobby + ", author_id="
				+ author_id + "]";
	}

	
	
	
}
