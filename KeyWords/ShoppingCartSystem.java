// Create a Product class to manage shopping cart items with the following features:

public class ShoppingCartSystem {
    public static void main(String[] args) {
        // Creating product objects with name, price, and quantity
        Product product1 = new Product("Laptop", 1000, 2);
        Product product2 = new Product("Smartphone", 500, 3);
        Product product3 = new Product("Tablet", 300, 4);

        // Updating the discount to 10%
        Product.updateDiscount(10);

        // Displaying product details for each product
        product1.displayProductDetails();
        product2.displayProductDetails();
        product3.displayProductDetails();
    }
}

class Product {
    // Static variable to hold discount applicable to all products
    private static double discount = 0;
    // Instance variables for product ID, name, price, and quantity
    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    // Constructor to initialize product details
    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        // Randomly generating product ID
        productID = (int) (Math.random() * 1000);
    }

    // Method to display product details including discount
    public void displayProductDetails() {
        // Displaying product information
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.println(); // Adding an empty line for better readability
    }

    // Static method to update the discount for all products
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
}



// Static:
// A static variable discount shared by all products.
// A static method updateDiscount() to modify the discount percentage.
// This:
// Use this to initialize productName, price, and quantity in the constructor.
// Final:
// Use a final variable productID to ensure each product has a unique identifier that cannot be changed.
// Instanceof:
// Validate whether an object is an instance of the Product class before processing its details.
