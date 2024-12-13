package example.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import example.hibernate.dao.AuthorDao;
import example.hibernate.entity.Author;
import example.hibernate.entity.Book;

public class AuthorMain {
    public static void main(String[] args) {
        AuthorDao dao = new AuthorDao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Author");
            System.out.println("2. Retrieve Author by ID");
            System.out.println("3. Update Author");
            System.out.println("4. Delete Author");
            System.out.println("5. List All Authors");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            switch (choice) {
                case 1 -> {
                    // Add Author
                    Author author = new Author();
                    System.out.print("Enter name: ");
                    author.setName(scanner.nextLine());
                    System.out.print("Enter DOB (YYYY-MM-DD): ");
                    author.setDob(LocalDate.parse(scanner.nextLine()));
                    System.out.print("Enter country: ");
                    author.setCountry(scanner.nextLine());

                    System.out.print("Enter number of books: ");
                    int bookCount = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    ArrayList<Book> books = new ArrayList<>();
                    for (int i = 0; i < bookCount; i++) {
                        Book book = new Book();
                        System.out.print("Enter book title: ");
                        book.setTitle(scanner.nextLine());
                        System.out.print("Enter publication year: ");
                        book.setPub_year(scanner.nextInt());
                        System.out.print("Enter price: ");
                        book.setPrice(scanner.nextDouble());
                        scanner.nextLine(); // Consume newline
                        books.add(book);
                    }
                    author.setBooks(books);
                    dao.addAuthor(author);
                    System.out.println("Author and books added successfully!");
                }
                case 2 -> {
                    // Retrieve Author by ID
                    System.out.print("Enter author ID: ");
                    int id = scanner.nextInt();
                    Author author = dao.getAuthorById(id);
                    if (author != null) {
                        System.out.println("Author Details:\n" + author);
                    } else {
                        System.out.println("Author not found!");
                    }
                }
                case 3 -> {
                    // Update Author
                    System.out.print("Enter author ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Author author = dao.getAuthorById(id);
                    if (author != null) {
                        System.out.print("Enter new name: ");
                        author.setName(scanner.nextLine());
                        System.out.print("Enter new DOB (YYYY-MM-DD): ");
                        author.setDob(LocalDate.parse(scanner.nextLine()));
                        System.out.print("Enter new country: ");
                        author.setCountry(scanner.nextLine());

                        System.out.print("Do you want to update books? (yes/no): ");
                        String updateBooks = scanner.nextLine();
                        if (updateBooks.equalsIgnoreCase("yes")) {
                            ArrayList<Book> books = new ArrayList<>();
                            System.out.print("Enter number of books: ");
                            int bookCount = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            for (int i = 0; i < bookCount; i++) {
                                Book book = new Book();
                                System.out.print("Enter book title: ");
                                book.setTitle(scanner.nextLine());
                                System.out.print("Enter publication year: ");
                                book.setPub_year(scanner.nextInt());
                                System.out.print("Enter price: ");
                                book.setPrice(scanner.nextDouble());
                                scanner.nextLine(); // Consume newline
                                books.add(book);
                            }
                            author.setBooks(books);
                        }
                        dao.updateAuthor(author);
                        System.out.println("Author updated successfully.");
                    } else {
                        System.out.println("Author not found.");
                    }
                }
                case 4 -> {
                    // Delete Author
                    System.out.print("Enter author ID: ");
                    int id = scanner.nextInt();
                    dao.deleteAuthor(id);
                    System.out.println("Author deleted successfully.");
                }
                case 5 -> {
                    // List All Authors
                    System.out.println("All Authors:");
                    dao.getAllAuthors().forEach(System.out::println);
                }
                case 6 -> {
                    // Exit
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
