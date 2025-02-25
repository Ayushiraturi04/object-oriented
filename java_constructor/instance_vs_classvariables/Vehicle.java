package instance_vs_classvariables;

class Vehicle {
    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Class variable
    private static double registrationFee = 500.0;

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee:" + registrationFee);
    }

    // Class method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Main method to test the Vehicle class
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("John Doe", "Car");
        Vehicle v2 = new Vehicle("Jane Smith", "Motorcycle");

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        System.out.println();
        Vehicle.updateRegistrationFee(600.0);
        System.out.println("Updated Registration Fee: " + registrationFee);
    }
}
