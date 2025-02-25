package level_1;

class Book {
    // Attributes
    private String title;
    private String author;
    private double price;

    // Default Constructor
    public Book() {
        this.title = "Atomic Habits";
        this.author = "James clear";
        this.price = 350.00;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Display
    public void display() {
        System.out.println("Name of book:" + title);
        System.out.println("Name of the author:" + author);
        System.out.println("Price of the book:" + price);
    }

    public static void main(String args[]) {

        // Create object for default contructor
        Book book1 = new Book();
        book1.display();

        // Create object for parameterized constructor
        Book book2 = new Book("The Alchemist", "Paulo Coelho", 399);
        book2.display();
    }
}