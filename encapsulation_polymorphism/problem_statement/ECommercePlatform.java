import java.util.ArrayList;
import java.util.List;

// Abstract class representing a Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor to initialize product details
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters for encapsulation
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateDiscount();

    // Method to display product details
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Discount: $" + calculateDiscount());
    }
}

// Interface representing taxable products
interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

// Electronics category (Taxable)
class Electronics extends Product implements Taxable {
    private double discountRate = 0.10; // 10% discount
    private double taxRate = 0.18; // 18% tax

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Implement discount calculation (10% discount)
    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    // Implement tax calculation (18% tax)
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 18% (Electronics)";
    }
}

// Clothing category (Taxable)
class Clothing extends Product implements Taxable {
    private double discountRate = 0.15; // 15% discount
    private double taxRate = 0.05; // 5% tax

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Implement discount calculation (15% discount)
    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    // Implement tax calculation (5% tax)
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 5% (Clothing)";
    }
}

// Groceries category (Non-Taxable)
class Groceries extends Product {
    private double discountRate = 0.05; // 5% discount

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    // Implement discount calculation (5% discount)
    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }
}

// Main class to test the E-Commerce Platform
public class ECommercePlatform {
    public static void main(String[] args) {
        // List to store products using polymorphism
        List<Product> products = new ArrayList<>();

        // Creating product instances
        Electronics laptop = new Electronics(101, "Laptop", 50000);
        Clothing tShirt = new Clothing(102, "T-Shirt", 2000);
        Groceries rice = new Groceries(103, "Rice (5kg)", 500);

        // Adding products to the list
        products.add(laptop);
        products.add(tShirt);
        products.add(rice);

        // Displaying product details and calculating final price
        for (Product product : products) {
            product.displayDetails();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
            double finalPrice = product.getPrice() + tax - product.calculateDiscount();
            System.out.println("Final Price (After Tax & Discount): $" + finalPrice);

            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
            System.out.println("----------------------------");
        }
    }
}
