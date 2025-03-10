import java.util.ArrayList;

// Book class (can exist independently)
class Book {
    private String title;
    private String author;

    // Constructor to initialize book details
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getter methods to access book details
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Overriding toString method to display book details
    @Override
    public String toString() {
        return "Book{Title='" + title + "', Author='" + author + "'}";
    }
}

// Library class aggregates Book objects (has-a relationship)
class Library {
    private String name;
    private ArrayList<Book> books;

    // Constructor to initialize library with a name
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>(); // Initializing the book list
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books in the library
    public void showBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class LibraryAggregation {
    public static void main(String[] args) {
        // Creating books
        Book book1 = new Book("Atomic Habits", "James Clear");
        Book book2 = new Book("Too Good Too Be True", "Prajakta Koli");

        // Creating libraries
        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");

        // Adding books to different libraries
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2); // Same book can be in multiple libraries

        // Displaying books in each library
        library1.showBooks(); // Shows books in City Library
        System.out.println();
        library2.showBooks(); // Shows books in University Library
    }
}
