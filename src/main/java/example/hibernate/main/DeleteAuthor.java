package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.entity.Author;
import example.hibernate.entity.Book;
import example.hibernate.utils.HibernateConfig;

public class DeleteAuthor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (
				SessionFactory factory = HibernateConfig.getSessionFactory();
				Session session = factory.openSession();

		) {
//			Author foundAuthor=session.find(Author.class,"1");
//			Transaction tx = session.beginTransaction();
//			session.remove(foundAuthor);
//			tx.commit();
//			System.out.println(" Author Record Deleted..");
			
			Book foundBook=session.find(Book.class,"2");
			Transaction Tx = session.beginTransaction();
			session.remove(foundBook);
			Tx.commit();
			System.out.println("Book Record Deleted..");

	}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
