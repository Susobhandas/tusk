package coom.boom.many_to_many;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name="Students")
public class Student {
	
	
	@Id
	@SequenceGenerator(name = "student_seq", sequenceName="STUDENTS_SEQ" , allocationSize=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="student_seq")
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String fullname;
	
	
	@Column(name="email")
	private String email;

	
	
	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	
	@JoinTable(name="subject_Student",
	
			joinColumns=@JoinColumn(name="student_id"),
			inverseJoinColumns=@JoinColumn(name="Subject_id")
			)
	private List<Subject> subjects; 

	public Student() {
		
	}


	public Student(String fullname, String email) {
		
		this.fullname = fullname;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
public void addStudent(Subject subject) {
		
		if(subjects==null)
			subjects=new ArrayList<Subject>();
		subjects.add(subject);
		
		
		
	}
	
	
	
}
	