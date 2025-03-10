import java.util.ArrayList;
import java.util.List;

// Abstract class representing a Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    protected double baseCharge = 500; // Common base charge for all patients

    // Constructor to initialize patient details
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters for encapsulation
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateBill();

    // Concrete method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Interface for managing medical records
interface MedicalRecord {
    void addRecord(String record);

    void viewRecords();
}

// InPatient subclass (Admitted to hospital)
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge = 1000; // Charge per day
    private List<String> medicalHistory = new ArrayList<>();

    public InPatient(String patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    // Implement calculateBill() with inpatient-specific charges
    @Override
    public double calculateBill() {
        return baseCharge + (daysAdmitted * dailyCharge);
    }

    // Implement medical record management
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }
}

// OutPatient subclass (Visits hospital but not admitted)
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee = 300; // Fixed consultation fee
    private List<String> medicalHistory = new ArrayList<>();

    public OutPatient(String patientId, String name, int age) {
        super(patientId, name, age);
    }

    // Implement calculateBill() with outpatient-specific charges
    @Override
    public double calculateBill() {
        return baseCharge + consultationFee;
    }

    // Implement medical record management
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }
}

// Main class to test the Hospital Patient Management System
public class HospitalManagement {
    public static void main(String[] args) {
        // List to store patient data using polymorphism
        List<Patient> patients = new ArrayList<>();

        // Creating different patients
        InPatient patient1 = new InPatient("P101", "John Doe", 45, 5);
        OutPatient patient2 = new OutPatient("P202", "Jane Smith", 30);

        // Adding patients to the hospital system
        patients.add(patient1);
        patients.add(patient2);

        // Adding medical records
        patient1.addRecord("Diagnosed with Pneumonia");
        patient1.addRecord("Prescribed Antibiotics");

        patient2.addRecord("Routine Checkup");
        patient2.addRecord("Blood Test Done");

        // Processing patient data dynamically
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: $" + patient.calculateBill());

            // Checking and displaying medical records dynamically
            if (patient instanceof MedicalRecord) {
                MedicalRecord medicalPatient = (MedicalRecord) patient;
                medicalPatient.viewRecords();
            }

            System.out.println("----------------------------");
        }
    }
}
