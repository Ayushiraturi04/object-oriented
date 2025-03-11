// Sample Program 6: Vehicle Registration System
// Create a Vehicle class with the following features:

public class VehicleRegistration {
    public static void main(String[] args) {
        // Creating vehicle objects with owner name and vehicle type
        Vehicle vehicle1 = new Vehicle("John Doe", "Car");
        Vehicle vehicle2 = new Vehicle("Jane Doe", "Motorcycle");
        Vehicle vehicle3 = new Vehicle("John Smith", "Truck");

        // Updating the registration fee for all vehicles
        Vehicle.updateRegistrationFee(1000);

        // Displaying registration details for each vehicle
        vehicle1.displayRegistrationDetails();
        vehicle2.displayRegistrationDetails();
        vehicle3.displayRegistrationDetails();
    }
}

class Vehicle {
    // Static variable for registration fee, shared by all vehicles
    private static int registrationFee = 500; 
    private final int registrationNumber; // Unique registration number for each vehicle
    private String ownerName; // Owner's name
    private String vehicleType; // Type of vehicle (Car, Motorcycle, etc.)

    // Constructor to initialize vehicle details and generate a unique registration number
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        // Generating a random registration number for each vehicle instance
        this.registrationNumber = (int) (Math.random() * 1000);
    }

    // Method to display vehicle registration details
    public void displayRegistrationDetails() {
        // Checking if the current object is an instance of Vehicle (always true here)
        if (this instanceof Vehicle) {
            // Printing owner details and vehicle registration information
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
            System.out.println(); // Blank line for better readability
        }
    }

    // Static method to update the registration fee for all vehicles
    public static void updateRegistrationFee(int fee) {
        registrationFee = fee; // Updating the registration fee
    }
}



// Static:
// A static variable registrationFee common for all vehicles.
// A static method updateRegistrationFee() to modify the fee.
// This:
// Use this to initialize ownerName, vehicleType, and registrationNumber in the constructor.
// Final:
// Use a final variable registrationNumber to uniquely identify each vehicle.
// Instanceof:
// Check if an object belongs to the Vehicle class before displaying its registration 
// details. 
