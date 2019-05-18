package com.boom.egar_lazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteRecordDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instruct.class)
				.addAnnotatedClass(instruct_details.class)
				.buildSessionFactory();
		
		
		Session session=factory.getCurrentSession();
		
		session.beginTransaction();
		
		int temp=13;
		try {
		Instruct tempins=session.get(Instruct.class,temp);
		
		System.out.println("found the instructor "+tempins);
		
		if(tempins!=null) {
		
		session.delete(tempins);
		System.out.print(" and deleted!!!!!!!!!");
		}
		
	
		
		session.getTransaction().commit();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			factory.close();
		}

	}

}
