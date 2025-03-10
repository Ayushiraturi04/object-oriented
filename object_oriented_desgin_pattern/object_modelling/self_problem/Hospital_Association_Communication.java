import java.util.ArrayList;

// Patient class (Patients can consult multiple doctors)
class Patient {
    private String name;
    private ArrayList<Doctor> consultedDoctors; // Doctors the patient has consulted

    // Constructor to initialize patient
    public Patient(String name) {
        this.name = name;
        this.consultedDoctors = new ArrayList<>();
    }

    // Method to consult a doctor
    public void consultDoctor(Doctor doctor) {
        consultedDoctors.add(doctor);
        doctor.consult(this); // Establish two-way association
    }

    // Display doctors the patient has consulted
    public void showDoctors() {
        System.out.println("Patient: " + name + " - Consulted Doctors:");
        for (Doctor doctor : consultedDoctors) {
            System.out.println(doctor.getName());
        }
    }

    // Get patient name
    public String getName() {
        return name;
    }
}

// Doctor class (Doctors can see multiple patients)
class Doctor {
    private String name;
    String specialty;
    private ArrayList<Patient> patients; // Patients the doctor has seen

    // Constructor to initialize doctor
    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }

    // Method to consult a patient
    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name + " (Specialty: " + specialty + ") consulted patient: " + patient.getName());
    }

    // Display patients the doctor has consulted
    public void showPatients() {
        System.out.println("Doctor: " + name + " - Patients Consulted:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }

    // Get doctor name
    public String getName() {
        return name;
    }
}

// Hospital class (Aggregation: A hospital has doctors and patients, but they
// can exist independently)
class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    // Constructor to initialize hospital
    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Method to add a doctor to the hospital
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Method to add a patient to the hospital
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Display all doctors in the hospital
    public void showDoctors() {
        System.out.println("Hospital: " + name + " - Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getName() + " (Specialty: " + doctor.specialty + ")");
        }
    }

    // Display all patients in the hospital
    public void showPatients() {
        System.out.println("Hospital: " + name + " - Patients:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}

public class Hospital_Association_Communication {
    public static void main(String[] args) {
        // Creating a hospital
        Hospital hospital = new Hospital("City Hospital");

        // Creating doctors
        Doctor doctor1 = new Doctor("John Doe", "Cardiology");
        Doctor doctor2 = new Doctor("Jane Smith", "Neurology");

        // Creating patients
        Patient patient1 = new Patient("Alice Johnson");
        Patient patient2 = new Patient("Bob Brown");

        // Adding doctors and patients to the hospital (Aggregation)
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Patients consulting doctors (Association)
        patient1.consultDoctor(doctor1);
        patient1.consultDoctor(doctor2);
        patient2.consultDoctor(doctor2);

        // Displaying hospital, doctor, and patient details
        System.out.println();
        hospital.showDoctors();
        System.out.println();
        hospital.showPatients();
        System.out.println();

        doctor1.showPatients();
        System.out.println();
        doctor2.showPatients();
        System.out.println();

        patient1.showDoctors();
        System.out.println();
        patient2.showDoctors();
    }
}
