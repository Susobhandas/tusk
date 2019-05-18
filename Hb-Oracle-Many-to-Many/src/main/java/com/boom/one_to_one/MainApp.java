package com.boom.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		
		//creating session factory obj
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		
		
		//creating obj of instructor_details
		
		
		InstructorDetails details1=new InstructorDetails("www.youtube.com/PUBG","Gamming");
		
		//creating obj of instructor
		
		Instructor tempIns=new Instructor("Susen","Darby","susen@gmail.com");
		
		tempIns.setIns_details_id(details1);
		
		Session session=factory.getCurrentSession();
		
		session.beginTransaction();
		try {
		session.save(tempIns);
		
		
		session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			
		}
	}

}
