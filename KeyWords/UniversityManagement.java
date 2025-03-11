// Sample Program 5: University Student Management
// Create a Student class to manage student data with the following features:

public class UniversityManagement {
    public static void main(String[] args) {
        // Creating student objects with name, roll number, and grade
        Student student1 = new Student("John Doe", 123456, 3.5);
        Student student2 = new Student("Jane Doe", 654321, 3.8);
        Student student3 = new Student("John Smith", 987654, 3.2);

        // Displaying the total number of students in the university
        Student.displayTotalStudents();

        // Displaying details for each student
        student1.displayStudentDetails();
        student2.displayStudentDetails();
        student3.displayStudentDetails();
    }
}

class Student {
    // Static variables for the university name and total number of students
    private static String universityName = "XYZ University";
    private static int totalStudents = 0;
    // Instance variables for student details (name, roll number, and grade)
    private final int rollNumber;
    private String name;
    private double grade;

    // Constructor to initialize student details and update total students count
    public Student(String name, int rollNumber, double grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++; // Incrementing total students count whenever a new student is created
    }

    // Method to display details for the individual student
    public void displayStudentDetails() {
        // Displaying university name and student's details
        System.out.println("University Name: " + universityName);
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
        System.out.println(); // Adding an empty line for better readability
    }

    // Static method to display the total number of students in the university
    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }
}






// Static:
// A static variable universityName shared across all students.
// A static method displayTotalStudents() to show the number of students enrolled.
// This:
// Use this in the constructor to initialize name, rollNumber, and grade.
// Final:
// Use a final variable rollNumber for each student that cannot be changed.
// Instanceof:
// Check if a given object is an instance of the Student class before performing operations like displaying or updating grades.
