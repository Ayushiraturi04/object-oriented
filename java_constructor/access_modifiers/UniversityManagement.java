package access_modifiers;

// Base class Student
class Student {
    public int rollNumber; // Public: Accessible everywhere
    protected String name; // Protected: Accessible within subclass
    private double CGPA; // Private: Accessible only within this class

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Getter for CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Setter for CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA! Must be between 0 and 10.");
        }
    }

    // Display student details
    public void displayStudentInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass PostgraduateStudent demonstrating protected access
class PostgraduateStudent extends Student {
    private String specialization;

    // Constructor
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    // Display postgraduate student details
    public void displayPGStudentInfo() {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber); // Public - Accessible
        System.out.println("Name: " + name); // Protected - Accessible in subclass
        System.out.println("Specialization: " + specialization);
        System.out.println("CGPA: " + getCGPA()); // Access private CGPA via getter
    }
}

// Main class to test
public class UniversityManagement {
    public static void main(String[] args) {
        // Creating a Student object
        Student student1 = new Student(101, "Alice", 8.5);
        student1.displayStudentInfo();

        // Modifying CGPA using setter
        student1.setCGPA(9.2);
        System.out.println("Updated CGPA: " + student1.getCGPA());

        // Creating a PostgraduateStudent object
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Bob", 9.0, "Machine Learning");
        pgStudent.displayPGStudentInfo();
    }
}
