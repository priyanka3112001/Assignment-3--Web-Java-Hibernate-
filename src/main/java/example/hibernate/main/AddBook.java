package example.hibernate.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.entity.Book;
import example.hibernate.utils.HibernateConfig;

public class AddBook {

	public static void main(String[] args) {
		try (SessionFactory factory = HibernateConfig.getSessionFactory(); Session session = factory.openSession();

		) {
			Book b1 = new Book();
			b1.setBookid(2);
     		b1.setTitle("Mahashweta");
			b1.setPub_year(2000);
			b1.setPrice(200.00);
			
			Book b2 = new Book();
			b2.setBookid(1);
			b2.setTitle("Wings Of Fire");
			b2.setPub_year(1999);
			b2.setPrice(400.00);
			b2.setBookid(2);
			b2.setTitle("Wings Of Fire");
			b2.setPub_year(1995);
			b2.setPrice(300.00);

			Transaction tx = session.beginTransaction();
			session.persist(b1);
			session.persist(b2);
			tx.commit();
			System.out.println("Books Added...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
