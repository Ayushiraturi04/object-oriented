import java.util.ArrayList;
import java.util.List;

// Abstract class representing a Library Item
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    protected boolean isAvailable = true; // Default availability

    // Constructor to initialize item details
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters for encapsulation (No direct access to fields)
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Abstract method to be implemented by subclasses
    public abstract int getLoanDuration(); // Days allowed for borrowing

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Checked Out"));
    }
}

// Interface for reservable items
interface Reservable {
    boolean reserveItem();
    boolean checkAvailability();
}

// Book subclass (Reservable)
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    // Implement loan duration (Books can be borrowed for 14 days)
    @Override
    public int getLoanDuration() {
        return 14;
    }

    // Implement reservation system
    @Override
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Magazine subclass (Not reservable)
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    // Implement loan duration (Magazines can be borrowed for 7 days)
    @Override
    public int getLoanDuration() {
        return 7;
    }
}

// DVD subclass (Reservable)
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    // Implement loan duration (DVDs can be borrowed for 5 days)
    @Override
    public int getLoanDuration() {
        return 5;
    }

    // Implement reservation system
    @Override
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Main class to test the Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // List to store library items using polymorphism
        List<LibraryItem> libraryItems = new ArrayList<>();

        // Creating different library items
        Book book = new Book("B101", "The Great Gatsby", "F. Scott Fitzgerald");
        Magazine magazine = new Magazine("M202", "National Geographic", "NatGeo Team");
        DVD dvd = new DVD("D303", "Inception", "Christopher Nolan");

        // Adding items to the library collection
        libraryItems.add(book);
        libraryItems.add(magazine);
        libraryItems.add(dvd);

        // Displaying item details and loan durations
        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // Checking and reserving items dynamically
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Reserving Item: " + (reservableItem.reserveItem() ? "Success" : "Failed - Already Reserved"));
            }

            System.out.println("----------------------------");
        }
    }
}

