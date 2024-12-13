package example.hibernate.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Author_Master")

public class Author {
	@Id
	@Column(name = "Author_Id")
	private int authorId;
	@Column(name = "Author_name")
	private String name;
	@Column(name = "Author_Dob")
	private LocalDate dob;
	@Column(name = "Author_Country")
	private String country;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Author_Id")
	private Collection<Book> books;

	public Author() {
		books = new ArrayList<Book>();
	}

	public Author(int authorId, String name, LocalDate dob, String country, Collection<Book> books) {
		super();
		this.authorId = authorId;
		this.name = name;
		this.dob = dob;
		this.country = country;
		this.books = books;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

	public void addBook(Book bookObject) {
		books.add(bookObject);
	}

}