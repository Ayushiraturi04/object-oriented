import java.util.ArrayList;
import java.util.List;

// Abstract class representing a Food Item
abstract class FoodItem {
    private String itemName;
    protected double price;
    protected int quantity;

    // Constructor to initialize food item details
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters for encapsulation
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateTotalPrice();

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: $" + price);
        System.out.println("Quantity: " + quantity);
    }
}

// Interface for discountable items
interface Discountable {
    double applyDiscount();

    String getDiscountDetails();
}

// VegItem subclass (Discountable)
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Implement total price calculation
    @Override
    public double calculateTotalPrice() {
        return price * quantity - applyDiscount();
    }

    // Implement discount (5% off for veg items)
    @Override
    public double applyDiscount() {
        return (price * quantity) * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied!";
    }
}

// NonVegItem subclass (Discountable)
class NonVegItem extends FoodItem implements Discountable {
    private double nonVegCharge = 2.0; // Extra charge per item

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Implement total price calculation (extra charge applied)
    @Override
    public double calculateTotalPrice() {
        return (price * quantity + (nonVegCharge * quantity)) - applyDiscount();
    }

    // Implement discount (3% off for non-veg items)
    @Override
    public double applyDiscount() {
        return (price * quantity) * 0.03;
    }

    @Override
    public String getDiscountDetails() {
        return "3% discount applied, but includes a non-veg surcharge of $" + (nonVegCharge * quantity);
    }
}

// Main class to test the Online Food Delivery System
public class FoodDeliverySystem {
    public static void main(String[] args) {
        // List to store food items using polymorphism
        List<FoodItem> order = new ArrayList<>();

        // Creating different food items
        VegItem vegBurger = new VegItem("Veg Burger", 5.99, 2);
        NonVegItem chickenPizza = new NonVegItem("Chicken Pizza", 12.99, 1);
        VegItem paneerTikka = new VegItem("Paneer Tikka", 8.49, 3);

        // Adding items to the order
        order.add(vegBurger);
        order.add(chickenPizza);
        order.add(paneerTikka);

        // Processing order dynamically
        double totalOrderPrice = 0;
        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price (after discount & charges): $" + item.calculateTotalPrice());

            // Checking discount details dynamically
            if (item instanceof Discountable) {
                Discountable discountItem = (Discountable) item;
                System.out.println(discountItem.getDiscountDetails());
            }

            totalOrderPrice += item.calculateTotalPrice();
            System.out.println("----------------------------");
        }

        // Display total order price
        System.out.println("Final Order Amount: $" + totalOrderPrice);
    }
}
