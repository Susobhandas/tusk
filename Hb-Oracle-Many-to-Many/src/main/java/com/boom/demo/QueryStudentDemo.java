package com.boom.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//Createsession factory--
		
		SessionFactory factory=new Configuration().addAnnotatedClass(Student.class)
				.configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		//create session
		Session session=factory.getCurrentSession();
		
		
        session.beginTransaction();
		
		//start new transaction
        try {
		
        	System.out.println("---------------------------------------------------");
        	
		Student mystudent=session.get(Student.class,1004);
		System.out.println("Student of id 1004: "+mystudent);
		
		System.out.println("\n\n STudent Name = "+mystudent.getFirstname()+" "+mystudent.getLastname());
		
		
		//-----------
		
		List<Student> students=session.createQuery("from Student s where s.lastname='pal' OR s.firstname='boom'").getResultList();
		
		displayStudent(students);
		
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		//close session
		finally {
			session.close();
		
			System.out.println("session closed.....");
			factory.close();
			System.out.println("sessionfactory closed.....");
			System.out.println("---------------------------------------------------");
		}

	}

	private static void displayStudent(List<Student> students) {
		for(Student s:students) {
			System.out.println(s);
		}
	}

}
