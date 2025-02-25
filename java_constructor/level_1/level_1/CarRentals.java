package level_1;

class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    // Default Constructor
    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Not Assigned";
        this.rentalDays = 0;
        this.dailyRate = 0;
    }

    // Parameterized Constructor
    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    // Copy Constructor
    public CarRental(CarRental rental) {
        this.customerName = rental.customerName;
        this.carModel = rental.carModel;
        this.rentalDays = rental.rentalDays;
        this.dailyRate = rental.dailyRate;
    }

    // Method to calculate total rental cost
    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    // Method to display rental details
    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: " + dailyRate);
        System.out.println("Total Cost: " + calculateTotalCost());
    }
}

// Main class to test the Car Rental System
public class CarRentals {
    public static void main(String[] args) {
        // Creating car rental objects
        CarRental rental1 = new CarRental("Alice", "Toyota Corolla", 5, 1500);
        CarRental rental2 = new CarRental("Bob", "Honda City", 3, 1800);

        // Displaying rental details
        rental1.displayRentalDetails();
        rental2.displayRentalDetails();

        // Using Copy Constructor
        CarRental rental3 = new CarRental(rental1);
        rental3.displayRentalDetails();
    }
}