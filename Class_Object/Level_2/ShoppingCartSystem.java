package Level_2;

class ShoppingCart {
    String itemName; // Name of the item
    double price; // Price per unit of the item
    int quantity; // Quantity of the item in the cart

    // Constructor to initialize item details
    ShoppingCart(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add/update an item in the cart
    public void addItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to remove an item from the cart
    public void removeItem() {
        this.itemName = null; // Setting item name to null to indicate no item
        this.price = 0; // Reset price to 0
        this.quantity = 0; // Reset quantity to 0
    }

    // Method to display item details and total cost
    public void display() {
        if (itemName == null) {
            System.out.println("No items in the cart.");
        } else {
            System.out.println("Item Name: " + itemName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Cost: " + (price * quantity));
        }
        System.out.println("---------------------------");
    }
}

// Main class to execute the program
public class ShoppingCartSystem {
    public static void main(String[] args) {
        // Creating objects with initial items
        ShoppingCart cart1 = new ShoppingCart("Laptop", 50000, 2);
        ShoppingCart cart2 = new ShoppingCart("Mobile", 20000, 3);

        // Displaying initial cart details
        cart1.display();

        // Adding a new item to the first cart
        cart1.addItem("Mobile", 20000, 3);
        cart1.display();

        // Removing an item from the first cart
        cart1.removeItem();
        cart1.display();

        // Displaying the second cart details
        cart2.display();

        // Updating the second cart with a new item
        cart2.addItem("Laptop", 50000, 2);
        cart2.display();
    }
}