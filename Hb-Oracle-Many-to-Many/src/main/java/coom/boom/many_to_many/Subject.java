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
@Table
public class Subject {

	
	@Id
	@SequenceGenerator(name = "subject_seq", sequenceName="subject_seq" , allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="subject_seq")
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	
	@JoinTable(name="subject_Student",
	
			joinColumns=@JoinColumn(name="Subject_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			)
	private List<Student> students; 

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Subject() {
		
	}

	public Subject(String title) {
		
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
	
	public void addStudent(Student st) {
		
		if(students==null)
			students=new ArrayList<Student>();
		students.add(st);
		
		
		
	}
	
	
}
