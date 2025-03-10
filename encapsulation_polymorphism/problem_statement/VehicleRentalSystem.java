import java.util.ArrayList;
import java.util.List;

// Abstract class representing a Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor to initialize vehicle details
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Getters for encapsulation (No direct access to fields)
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateRentalCost(int days);

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: $" + rentalRate);
    }
}

// Interface representing Insurable vehicles
interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

// Car subclass (Insurable)
class Car extends Vehicle implements Insurable {
    private double insuranceRate = 0.05; // 5% of rental cost

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
    }

    // Implement rental cost calculation
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Implement insurance calculation (5% of total rental cost)
    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate;
    }

    // Implement insurance details (Encapsulation: Restricting policy number)
    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy: [Protected]";
    }
}

// Bike subclass (Insurable)
class Bike extends Vehicle implements Insurable {
    private double insuranceRate = 0.03; // 3% of rental cost

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    // Implement rental cost calculation
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Implement insurance calculation (3% of total rental cost)
    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate;
    }

    // Implement insurance details
    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy: [Protected]";
    }
}

// Truck subclass (Non-Insurable)
class Truck extends Vehicle {
    private double extraCharge = 50.0; // Fixed extra charge per rental

    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    // Implement rental cost calculation (Includes extra charge)
    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + extraCharge;
    }
}

// Main class to test the Vehicle Rental System
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // List to store vehicles using polymorphism
        List<Vehicle> vehicles = new ArrayList<>();

        // Creating different types of vehicles
        Car car = new Car("MH12AB1234", 100, "CAR-INS-123");
        Bike bike = new Bike("MH14XY5678", 50, "BIKE-INS-567");
        Truck truck = new Truck("MH09TR9999", 300);

        // Adding vehicles to the list
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);

        // Displaying vehicle details, rental cost, and insurance (if applicable)
        int rentalDays = 5; // Example rental duration
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            System.out.println("Rental Cost for " + rentalDays + " days: $" + vehicle.calculateRentalCost(rentalDays));

            if (vehicle instanceof Insurable) {
                System.out.println("Insurance Cost: $" + ((Insurable) vehicle).calculateInsurance());
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }

            System.out.println("----------------------------");
        }
    }
}
