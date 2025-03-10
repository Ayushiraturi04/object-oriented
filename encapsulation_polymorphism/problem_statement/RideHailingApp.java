import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Abstract class representing a Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    protected double ratePerKm;

    // Constructor to initialize vehicle details
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getters for encapsulation
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateFare(double distance);

    // Concrete method to display vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per km: $" + ratePerKm);
    }
}

// Interface for GPS tracking
interface GPS {
    String getCurrentLocation();

    void updateLocation(String newLocation);
}

// Car subclass (Expensive ride)
class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown"; // Default location
    }

    // Implement fare calculation for Car
    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 5; // Additional base charge
    }

    // Implement GPS methods
    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Bike subclass (Cheapest ride)
class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    // Implement fare calculation for Bike
    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm; // No extra charge
    }

    // Implement GPS methods
    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Auto subclass (Mid-range ride)
class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    // Implement fare calculation for Auto
    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm + 2; // Small additional charge
    }

    // Implement GPS methods
    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Main class to test the Ride-Hailing Application
public class RideHailingApp {
    public static void main(String[] args) {
        // List to store available rides using polymorphism
        List<Vehicle> rides = new ArrayList<>();

        // Creating different vehicles
        Car car1 = new Car("C101", "John Doe", 10.0);
        Bike bike1 = new Bike("B202", "Jane Smith", 5.0);
        Auto auto1 = new Auto("A303", "Robert Brown", 7.0);

        // Adding vehicles to the system
        rides.add(car1);
        rides.add(bike1);
        rides.add(auto1);

        // Simulating a ride request for different vehicles
        double distance = 12.5; // Example distance in km
        for (Vehicle ride : rides) {
            ride.getVehicleDetails();
            System.out.println("Estimated Fare for " + distance + " km: $" + ride.calculateFare(distance));

            // Checking GPS details dynamically
            if (ride instanceof GPS) {
                GPS gpsVehicle = (GPS) ride;
                String newLocation = generateRandomLocation();
                gpsVehicle.updateLocation(newLocation);
                System.out.println("Updated Location: " + gpsVehicle.getCurrentLocation());
            }

            System.out.println("----------------------------");
        }
    }

    // Method to generate a random location for GPS updates
    private static String generateRandomLocation() {
        String[] locations = { "Downtown", "City Center", "Airport", "Suburbs", "Train Station" };
        Random rand = new Random();
        return locations[rand.nextInt(locations.length)];
    }
}
