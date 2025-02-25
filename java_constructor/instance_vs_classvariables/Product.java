package instance_vs_classvariables;

class Product {
    private static int totalProducts = 0; // Class variable to keep track of total products created
    private String productName; // Instance variable for product name
    private double price; // Instance variable for price

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment total products count when a new product is created
    }

    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    // Main method
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1000.0);
        Product product2 = new Product("Phone", 500.0);

        product1.displayProductDetails();
        product2.displayProductDetails();

        Product.displayTotalProducts();
    }
}
