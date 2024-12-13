package example.hibernate.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.entity.Author;
import example.hibernate.utils.HibernateConfig;

public class AddAuthors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				SessionFactory factory = HibernateConfig.getSessionFactory();
				Session session = factory.openSession();
				
				){
//			Author a1 = new Author();
//			a1.setAuthorId(1);
//			a1.setName("Sudha Murty");
//		    a1.setCountry("India");
//		    a1.setDob(LocalDate.of(1950, 8, 19));
		    
		    Author a2 = new Author();
			a2.setAuthorId(2);
			a2.setName("APJ Abdul Kalam");
		    a2.setCountry("India");
		    a2.setDob(LocalDate.of(1931, 9, 15));
		 
			Transaction tx = session.beginTransaction();
		//	session.persist(a1);
			session.persist(a2);
			tx.commit();
			System.out.println("Authors Added...");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}
	}

