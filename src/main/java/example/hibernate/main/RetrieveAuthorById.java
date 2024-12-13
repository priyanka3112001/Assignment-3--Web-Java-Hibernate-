package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import example.hibernate.entity.Author;
import example.hibernate.utils.HibernateConfig;

public class RetrieveAuthorById {
		public static void main(String[] args) {
			try (
					SessionFactory factory = HibernateConfig.getSessionFactory();
					Session session = factory.openSession();

			) {
				Author foundAuthor=session.find(Author.class,"1");
			
				if(foundAuthor!=null) {
					
				System.out.println("Found Author :"+ foundAuthor);
				System.out.println(" Name: "+ foundAuthor.getName());
				}
				else
					System.out.println("Author with given ID does not exits..");
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}

	}

