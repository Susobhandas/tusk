package com.boom.one_to_one.delete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.boom.one_to_one.Instructor;
import com.boom.one_to_one.InstructorDetails;

public class OnetoManyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instruct.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(instruct_details.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
		instruct_details details1=new instruct_details("www.youtube.com/hoho","hauhau kora");
		
		//creating obj of instructor
		
		Instruct tempIns=new Instruct("crap","shit","crap@gmail.com");
		
		tempIns.setIns_details_id(details1);
		
		/*
		 int tmpinsid=11;
		 
		 Instruct tempIns=session.get(Instruct.class,Instruct);
		 */
		
		Course tempcourse1=new Course("Violin is the best of all music instrument");
		Course tempcourse2=new Course("You should really try Anime ");
		Course tempcourse3=new Course("My Office envirnoment Sucks!!!");
		
		tempIns.addCourse(tempcourse1);
		
		tempIns.addCourse(tempcourse2);
		tempIns.addCourse(tempcourse3);
		
		session.beginTransaction();
		
		session.save(tempIns);
		session.save(tempcourse1);
		session.save(tempcourse2);
		session.save(tempcourse3);
		
		

		
		
	
		
		session.getTransaction().commit();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			session.close();
			factory.close();
		}

	}

}
