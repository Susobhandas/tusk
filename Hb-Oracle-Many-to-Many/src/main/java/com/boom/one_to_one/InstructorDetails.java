package com.boom.one_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="instructor_details")
public class InstructorDetails {

	public InstructorDetails() {
		
		
	}

	
	
	public InstructorDetails(String youtube, String hobby) {
		
		this.youtube = youtube;
		this.hobby = hobby;
	}



	@Id
	@SequenceGenerator(name="details_seq", sequenceName="ins_details_seq" ,allocationSize=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="details_seq")
	@Column(name="instructor_id")
	private int id;
	
	@Column(name="channel")
	private String youtube;
	
	
	@Column(name="hobby")
	private String hobby;


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getYoutube() {
		return youtube;
	}



	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}



	public String getHobby() {
		return hobby;
	}



	public void setHobby(String hobby) {
		this.hobby = hobby;
	}



	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", youtube=" + youtube + ", hobby=" + hobby + "]";
	}
	
	
	
}
