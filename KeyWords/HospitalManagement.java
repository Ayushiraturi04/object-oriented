// Sample Program 7: Hospital Management System
// Create a Patient class with the following features:

// Main class to test the Patient functionality in a hospital management system
public class HospitalManagement {
    public static void main(String[] args) {
        // Creating three patient records with different details
        Patient patient1 = new Patient("John Doe", 25, "Fever");
        Patient patient2 = new Patient("Jane Doe", 30, "Headache");
        Patient patient3 = new Patient("John Smith", 35, "Cough");

        // Display total number of patients admitted
        Patient.displayTotalPatients();

        // Display details of each patient
        patient1.displayPatientDetails();
        patient2.displayPatientDetails();
        patient3.displayPatientDetails();
    }
}

// Patient class representing a hospital patient
class Patient {
    // Static variable shared among all instances, representing the hospital name
    private static String hospitalName = "XYZ Hospital";
    
    // Static variable to keep track of total patients admitted
    private static int totalPatients = 0;
    
    // Final variable to ensure the patient ID cannot be changed once assigned
    private final int patientID;
    
    // Instance variables for patient name, age, and ailment
    private String name;
    private int age;
    private String ailment;

    // Constructor to initialize a new patient record
    public Patient(String name, int age, String ailment) {
        this.name = name; // Using 'this' to refer to instance variable
        this.age = age;
        this.ailment = ailment;
        totalPatients++; // Increment total patients whenever a new patient is admitted
        this.patientID = (int) (Math.random() * 1000); // Generate a random patient ID
    }

    // Method to display patient details
    public void displayPatientDetails() {
        // Checking if the object is an instance of Patient (not necessary here, but included as per instruction)
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient Name: " + name);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println();
        }
    }

    // Static method to display the total number of patients admitted
    public static void displayTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }
}






// Static:
// A static variable hospitalName shared among all patients.
// A static method getTotalPatients() to count the total patients admitted.
// This:
// Use this to initialize name, age, and ailment in the constructor.
// Final:
// Use a final variable patientID to uniquely identify each patient.
// Instanceof:
// Check if an object is an instance of the Patient class before displaying its details.
