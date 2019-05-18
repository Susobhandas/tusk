package com.boom.egar_lazy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	public Course() {

	}
	
	
	
	public Course(String course_title) {
		
		this.course_title = course_title;
		
	}



	@Id
	@SequenceGenerator(name="seq", sequenceName="course_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	@Column(name="id")
	private int id;
	
	@Column(name="course_title")
	private String course_title;
	
    @ManyToOne(cascade= {CascadeType.PERSIST,
    		CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name="ins_id")
	private Instruct instructorid;

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCourse_title() {
		return course_title;
	}



	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}



	public Instruct getInstructorid() {
		return instructorid;
	}



	public void setInstructorid(Instruct instructorid) {
		this.instructorid = instructorid;
	}
    
    

}
