import java.util.ArrayList;

// Product class (Products exist independently)
class Product {
    private String name;
    private double price;

    // Constructor to initialize product details
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Overriding toString method to display product details
    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

// Order class (Contains multiple Product objects - Aggregation)
class Order {
    private static int orderCounter = 1000; // Unique order ID generator
    private int orderId;
    private ArrayList<Product> products; // List of products in the order
    private Customer customer; // The customer who placed the order

    // Constructor to initialize an order for a customer
    public Order(Customer customer) {
        this.orderId = ++orderCounter; // Generate unique order ID
        this.customer = customer;
        this.products = new ArrayList<>(); // Initialize product list
    }

    // Method to add a product to the order
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to display order details
    public void viewOrderDetails() {
        System.out.println("Order ID: " + orderId + " | Customer: " + customer.getName());
        System.out.println("Products Ordered:");
        for (Product product : products) {
            System.out.println("  - " + product);
        }
        System.out.println("Total Amount: $" + calculateTotal() + "\n");
    }

    // Method to calculate the total cost of the order
    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Get order ID
    public int getOrderId() {
        return orderId;
    }
}

// Customer class (Customers place multiple orders - Association)
class Customer {
    private String name;
    private ArrayList<Order> orders; // List of orders placed by the customer

    // Constructor to initialize customer details
    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>(); // Initialize order list
    }

    // Method to place an order
    public Order placeOrder() {
        Order order = new Order(this); // Create a new order associated with this customer
        orders.add(order); // Add order to the customer's list
        return order;
    }

    // Method to display all orders placed by the customer
    public void viewOrders() {
        System.out.println("Customer: " + name + " - Order History:");
        if (orders.isEmpty()) {
            System.out.println("No orders placed yet.");
        } else {
            for (Order order : orders) {
                order.viewOrderDetails();
            }
        }
    }

    // Get customer name
    public String getName() {
        return name;
    }
}

// E-commerce simulation
public class Ecommerce {
    public static void main(String[] args) {
        // Creating products
        Product laptop = new Product("Laptop", 850.00);
        Product phone = new Product("Smartphone", 499.99);
        Product headphones = new Product("Wireless Headphones", 99.99);

        // Creating customers
        Customer alice = new Customer("Alice Johnson");
        Customer bob = new Customer("Bob Brown");

        // Alice places an order
        Order aliceOrder1 = alice.placeOrder();
        aliceOrder1.addProduct(laptop);
        aliceOrder1.addProduct(headphones);

        // Bob places an order
        Order bobOrder1 = bob.placeOrder();
        bobOrder1.addProduct(phone);

        // Alice places another order
        Order aliceOrder2 = alice.placeOrder();
        aliceOrder2.addProduct(phone);
        aliceOrder2.addProduct(headphones);

        // Display customer order details
        System.out.println();
        alice.viewOrders();
        System.out.println();
        bob.viewOrders();
    }
}
