package example.hibernate.main;

import java.util.Arrays;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.entity.Author;
import example.hibernate.entity.Book;
import example.hibernate.utils.HibernateConfig;

public class LinkBookToAuthor {

	public static void main(String[] args) {
		try (SessionFactory factory = HibernateConfig.getSessionFactory(); Session session = factory.openSession();

		) {
			// Loading the films for which songs are to be linked
			Author author1 = session.find(Author.class, "1");
			Author author2 = session.find(Author.class, "2");

			// Loading the songs for which Film are to be linked

			Book book1 = session.find(Book.class, "1");
			Book book2 = session.find(Book.class, "2");
			
			Transaction tx = session.beginTransaction();
			// Adding song3 and song4 to the film:film
			Collection<Book> booksCollection = Arrays.asList(book1);
			author1.setBooks(booksCollection);

			// Adding song3 and song4 to the film:film2
			// film2.addSong(song3);
			// film2.addSong(song4);
			tx.commit();
			System.out.println("Books linked to the Author..");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
