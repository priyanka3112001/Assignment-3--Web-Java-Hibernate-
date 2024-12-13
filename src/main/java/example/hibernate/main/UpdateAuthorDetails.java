package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.entity.Author;
import example.hibernate.utils.HibernateConfig;

public class UpdateAuthorDetails {
	
		public static void main(String[] args) {
			try (
					SessionFactory factory = HibernateConfig.getSessionFactory();
					Session session = factory.openSession();

			) {
				Author foundAuthor=session.find(Author.class,"1");
				Transaction tx = session.beginTransaction();
				 foundAuthor.setName("");
				 tx.commit();
				 System.out.println("Record Updated");

		}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

