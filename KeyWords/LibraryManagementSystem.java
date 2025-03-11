// Sample Program 2: Library Management System

// Main class to test the Library functionality in a library management system
public class LibraryManagementSystem {
    public static void main(String args[]) {
        // Creating three book records with different details
        Book b1 = new Book("The Alchemist", "Paulo Coelho", "9780062315007");
        Book b2 = new Book("The Da Vinci Code", "Dan Brown", "9780307474278");
        Book b3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");

        // Display library name and book details for each book
        b1.displayLibraryName();
        b2.displayLibraryName();
        b3.displayLibraryName();
    }
}

// Book class representing a book in the library
class Book {
    // Static variable shared among all instances, representing the library name
    private static String LibraryName = "Central Library";
    
    // Final variable to ensure the ISBN cannot be changed once assigned
    private final String isbn;
    
    // Instance variables for book title and author
    private String title;
    private String author;

    // Constructor to initialize a new book record
    public Book(String title, String author, String isbn) {
        this.title = title; // Using 'this' to refer to instance variable
        this.author = author;
        this.isbn = isbn;
    }

    // Method to display library name and book details
    public void displayLibraryName() { 
        // Checking if the object is an instance of Book (not necessary here, but included as per instruction)
        if(this instanceof Book) {
            System.out.println("Library: " + LibraryName); 
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
            System.out.println();
        }
    }
}



// Create a Book class to manage library books with the following features:
// Static:
// A static variable libraryName shared across all books.
// A static method displayLibraryName() to print the library name.
// This:
// Use this to initialize title, author, and isbn in the constructor.
// Final:
// Use a final variable isbn to ensure the unique identifier of a book cannot be changed.
// Instanceof:
// Verify if an object is an instance of the Book class before displaying its details.