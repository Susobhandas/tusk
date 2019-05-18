package com.boom.one_to_one.delete;

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
@Table(name="instructor_details")
public class instruct_details {

	public instruct_details() {
		
	}
	
	

	public instruct_details(String channel, String hobby) {
		
		this.channel = channel;
		this.hobby = hobby;
	}



	@Id
	@SequenceGenerator(name="detail_seq", sequenceName="ins_details_seq",allocationSize=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="detail_seq")
	@Column(name="instructor_id")
	private int id;
	
	@Column(name="channel")
	private String channel;
	
	@Column(name="hobby")
	private String hobby;
	
	
	@OneToOne(mappedBy="ins_details_id",cascade= {CascadeType.DETACH,
			                                      CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Instruct instructor;

	public Instruct getInstructor() {
		return instructor;
	}



	public void setInstructor(Instruct instructor) {
		this.instructor = instructor;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getChannel() {
		return channel;
	}



	public void setChannel(String channel) {
		this.channel = channel;
	}



	public String getHobby() {
		return hobby;
	}



	public void setHobby(String hobby) {
		this.hobby = hobby;
	}



	@Override
	public String toString() {
		return "instruct_details [id=" + id + ", channel=" + channel + ", hobby=" + hobby + "]";
	}
	
	
}
