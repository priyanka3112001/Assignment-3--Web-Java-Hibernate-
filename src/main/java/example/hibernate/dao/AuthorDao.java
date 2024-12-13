package example.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.hibernate.entity.Author;

import java.util.List;

public class AuthorDao {
    private SessionFactory SF;

    public AuthorDao() {
    	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    	SessionFactory sessionFactory = configuration.buildSessionFactory();

    }

    // 1. Add a new author
    public void addAuthor(Author author) {
        Session session = SF.openSession();
        Transaction tx = session.beginTransaction();
        session.save(author);
        tx.commit();
        session.close();
    }

    // 2. Retrieve an author by ID
    public Author getAuthorById(int id) {
        Session session = SF.openSession();
        Author author = session.get(Author.class, id);
        session.close();
        return author;
    }


    // 3. Update an author
    public void updateAuthor(Author updatedAuthor) {
        Session session = SF.openSession();
        Transaction tx = session.beginTransaction();
        session.update(updatedAuthor);
        tx.commit();
        session.close();
    }

    // 4. Delete an author
    public void deleteAuthor(int id) {
        Session session = SF.openSession();
        Transaction tx = session.beginTransaction();
        Author author = session.get(Author.class, id);
        if (author != null) {
            session.delete(author);
        }
        tx.commit();
        session.close();
    }

    // Retrieve all authors
    public List<Author> getAllAuthors() {
        Session session = SF.openSession();
        List<Author> authors = session.createQuery("from Author", Author.class).list();
        session.close();
        return authors;
    }
}


//public interface AuthorDao {
//	
//	    void addAuthor(Author author);
//	    
//	    Author getAuthorById(int id);
//	    
//	    void updateAuthor(Author author);
//	    
//	    void deleteAuthor(int id);
//	}


