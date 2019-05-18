package com.boom.author_egar_lazy;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AuthorDataRetrive {

	public static void main(String[] args) {
		
SessionFactory factory=new Configuration()
                                         .addAnnotatedClass(Author.class)
                                         .addAnnotatedClass(AuthorDetails.class)
                                         .addAnnotatedClass(Books.class)
                                         .configure("hibernate.cfg.xml")
                                         .buildSessionFactory();

Session session=factory.getCurrentSession();

try {



session.beginTransaction();

int tmpid=1051;

Author tempauth=session.get(Author.class,tmpid);
System.out.println("Author: "+tempauth);

List<Books> book= tempauth.getBooks();

System.out.println("books : "+book);

	tempauth.setBooks(book);



session.getTransaction().commit();
	System.out.println("commit done");	
	}
catch (Exception e) {
	e.printStackTrace();
}

finally{
	
	session.close();
	System.out.println("closed session");
	factory.close();
}

}
}
