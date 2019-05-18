package coom.boom.many_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Many_to_Many_MainApp {

	public static void main(String[] args) {
		
SessionFactory factory=new Configuration()
                                        
                                         .addAnnotatedClass(Student.class)
                                         .addAnnotatedClass(Subject.class)
                                         .configure("hibernate.cfg.xml")
                                         .buildSessionFactory();





//-------------students
/*
Student tempstd1=new Student("Gandu Giri", "gandu@gmail.com");

Student tempstd2=new Student("Modon Mallik", "modon@gmail.com");

Student tempstd3=new Student("Boka Choda", "boka@gmail.com");

Student tempstd4=new Student("Nitai poira", "nitai@gmail.com");
Student tempstd5=new Student("Nunu Batcha", "nunu@gmail.com");

//-------------------------subjects---------------

Subject tempsub1=new Subject("Handle Mara");

Subject tempsub2=new Subject("Dudu Chusa");

Subject tempsub3=new Subject("Magi Thapano");

Session session=factory.getCurrentSession();


session.beginTransaction();
		
try {

System.out.println("-------------------Saving students-----------------");



	
session.save(tempstd1);

session.save(tempstd2);

session.save(tempstd3);

session.save(tempstd4);

session.save(tempstd5);

System.out.println("-----------------Saved Student---------------------");

System.out.println("--------------adding Students to Subjects----------------");


tempsub1.addStudent(tempstd1);
tempsub1.addStudent(tempstd2);
tempsub1.addStudent(tempstd3);
tempsub1.addStudent(tempstd4);
tempsub1.addStudent(tempstd5);

tempsub2.addStudent(tempstd1);
tempsub2.addStudent(tempstd3);

tempsub3.addStudent(tempstd1);
tempsub3.addStudent(tempstd3);
tempsub3.addStudent(tempstd4);

System.out.println("------------- added Students to Subjects -----------");

System.out.println("-------------Saving Subjects---------------------");

session.save(tempsub1);

session.save(tempsub2);

session.save(tempsub3);*/

Session session=factory.getCurrentSession();


session.beginTransaction();
		
try {

	Subject tempsub=session.get(Subject.class,101);
	
	String subname=tempsub.getTitle();
	session.delete(tempsub);

System.out.println("-----------------"+subname+" Subject deleted---------------------");

session.getTransaction().commit();
	System.out.println("-----------commit done---------------");	
	}
catch (Exception e) {
	e.printStackTrace();
}

finally{
	session.close();
	factory.close();
	
	System.out.println("session closed");	
}

}
}
