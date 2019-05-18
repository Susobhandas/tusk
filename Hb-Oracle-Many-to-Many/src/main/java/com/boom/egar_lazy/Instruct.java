package com.boom.egar_lazy;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instruct {

	public Instruct() {
		
	}
	
	
	
	public Instruct(String firstname, String lastname, String email) {
	
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}



	@Id
	@SequenceGenerator(name="seq", sequenceName="ins_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ins_details_id")
	private instruct_details ins_details_id;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="instructorid",cascade={CascadeType.PERSIST,
		CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private List<Course> cources;


	public List<Course> getCources() {
		return cources;
	}



	public void setCources(List<Course> cources) {
		this.cources = cources;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public instruct_details getIns_details_id() {
		return ins_details_id;
	}



	public void setIns_details_id(instruct_details ins_details_id) {
		this.ins_details_id = ins_details_id;
	}



	@Override
	public String toString() {
		return "Instruct [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", ins_details_id=" + ins_details_id + "]";
	}
	
	
	public void addCourse(Course tempCourse) {
		if(cources==null) {
			cources=new ArrayList<Course>();
		}
			cources.add(tempCourse);
			
			tempCourse.setInstructorid(this);
		
	}
	
	
}
