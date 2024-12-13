package example.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book_Master")
public class Book {
	@Id
	
	@Column(name = "book_id", length = 4)
	private int bookid;
	
	@Column(name = "Book_title", length=50)
	private String title;
	
	@Column(name = "Publication_Year", length=4)
	private int pub_year;
	
	@Column(name = "Book_price", length=5)
	private double price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bookid, String title, int pub_year, double price) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.pub_year = pub_year;
		this.price = price;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPub_year() {
		return pub_year;
	}

	public void setPub_year(int pub_year) {
		this.pub_year = pub_year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", pub_year=" + pub_year + ", price=" + price + "]";
	}

	public void setAuthor(Author author) {
		this.setAuthor(author);
		
	}

	
	}

	

	
