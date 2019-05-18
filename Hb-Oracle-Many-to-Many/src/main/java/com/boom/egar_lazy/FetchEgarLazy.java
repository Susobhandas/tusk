package com.boom.egar_lazy;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchEgarLazy {

		
		public static void main(String[] args) {
			
			SessionFactory factory=new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instruct.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(instruct_details.class)
					.buildSessionFactory();
			Session session=factory.getCurrentSession();
			
			try {
			
			session.beginTransaction();
			
			int id1=21;
			
			Query<Instruct> query=session.createQuery("select i from Instruct i "+
			                                          "JOIN FETCH i.cources "+
					                                   "where i.id=:theinsid",
					
					
					Instruct.class);
			
			query.setParameter("theinsid",id1);
			
			//Instruct tempins=query.getSingleResult();
			
			List<Instruct> tempins=query.getResultList();
			
			System.out.println(tempins);
			
			/*
			
			session.get(Instruct.class,id1);
			
			
			
			System.out.println("Instrictor --> "+tempins);
			System.out.println("course--> "+tempins.getCources());
			
			System.out.println("----closing session---");
			session.close();
			
			//System.out.println("Courses --> "+tempins.getCources().getCourse_title());
		
			for(Course c:tempins.getCources()) {
				
				System.out.println("Courses --> "+c.getCourse_title());
			}*/
			session.getTransaction().commit();
			
			System.out.println("committing");
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			finally {
				System.out.println("closing factory");
				factory.close();
			}

		}

	}
