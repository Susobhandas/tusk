package com.student1;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.addAnnotatedClass(Student.class)
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		String dateofbirth="30/06/1994";
		
		Date dob = null;
		try {
			dob = DateUtiles.parseDate(dateofbirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(dateofbirth);
		
		Student temp=new Student("Boom","Da","boom.da@gmail.com", dob);
		
		Session session=factory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(temp);
		
		session.getTransaction().commit();

	}

}
