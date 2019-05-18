package com.boom.egar_lazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Bi_directional {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instruct.class)
				.addAnnotatedClass(instruct_details.class)
				.buildSessionFactory();
		
		
		Session session=factory.getCurrentSession();
		
		session.beginTransaction();
		
		int temp_detail=1061;
		try {
		instruct_details tempins=session.get(instruct_details.class,temp_detail);
		
		
		
		System.out.println("found the instructor "+tempins);
		
		tempins.getInstructor().setIns_details_id(null);
		
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
			session.close();
			factory.close();
		}

	}

}
