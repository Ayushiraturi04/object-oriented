package Level_1;

import java.util.ArrayList;

class book {

    // Attributes
    String title;
    String author;
    int price;

    // constructor
    public book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Methods to display books
    public void display() {
        System.out.println("Title of the book:" + title);
        System.out.println("Author of the book:" + author);
        System.out.println("Price of a book:" + price);
    }

    public static void main(String[] args) {
        book book1 = new book("Atomic Habits", "James Clear", 500);
        book1.display();

    }
}
