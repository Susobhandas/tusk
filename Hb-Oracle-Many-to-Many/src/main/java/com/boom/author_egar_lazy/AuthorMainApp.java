package com.boom.author_egar_lazy;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AuthorMainApp {

	public static void main(String[] args) {
		
SessionFactory factory=new Configuration()
                                         .addAnnotatedClass(Author.class)
                                         .addAnnotatedClass(AuthorDetails.class)
                                         .addAnnotatedClass(Books.class)
                                         .addAnnotatedClass(Review.class)
                                         .configure("hibernate.cfg.xml")
                                         .buildSessionFactory();






Author tempauth=new Author("Arthur Conan", "Doyle", "conan@gmail.com");

AuthorDetails tempdetails=new AuthorDetails("‎The Oxford", "Writting");

List<Books> book=new ArrayList<Books>();


Books book1=new Books("The Adventures of Sherlock Holmes (1892)");

book1.setAuthor_id(tempauth);

Books book2=new Books("The Memories of Sherlock Holmes (1893–94)");

book2.setAuthor_id(tempauth);

Books book3=new Books("The Return of Sherlock Holmes (1905)");

book3.setAuthor_id(tempauth);

Books book4=new Books("His Last Bow (1917)");

book4.setAuthor_id(tempauth);

Books book5=new Books("The Case-Book of Sherlock Holmes (1927)");
book5.setAuthor_id(tempauth);

book.add(book1);
book.add(book2);
book.add(book3);
book.add(book4);
book.add(book5);

System.out.println(book);


Review tempreview1=new Review("verry good!!!!!!");
Review tempreview2=new Review("satisfactory");

Review tempreview3=new Review("Cool!!!!!!");
Review tempreview4=new Review("i luv it..");

Session session=factory.getCurrentSession();


session.beginTransaction();
		
try {


tempauth.setDetails_id(tempdetails);
	

	
	tempauth.setBooks(book);
	
	book1.addReview(tempreview1);
	
	book1.addReview(tempreview2);
	
    book2.addReview(tempreview1);
	
	book3.addReview(tempreview2);
	
	book4.addReview(tempreview3);
	
	book5.addReview(tempreview2);
	book5.addReview(tempreview4);

session.save(tempauth);

session.save(book1);
session.save(book2);
session.save(book3);
session.save(book4);
session.save(book5);



session.getTransaction().commit();
	System.out.println("commit done");	
	}
catch (Exception e) {
	e.printStackTrace();
}

finally{
	
}

}
}
