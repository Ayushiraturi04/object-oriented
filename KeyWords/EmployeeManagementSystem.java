// Sample Program 3: Employee Management System

// Main class to test the Employee functionality in an employee management system
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating three employee records with different details
        Employee employee1 = new Employee("John Doe", 123456, "Software Engineer");
        Employee employee2 = new Employee("Jane Doe", 654321, "Senior Software Engineer");
        Employee employee3 = new Employee("John Smith", 987654, "Project Manager");

        // Display total number of employees in the company
        Employee.displayTotalEmployees();

        // Display details of each employee
        employee1.displayEmployeeDetails();
        employee2.displayEmployeeDetails();
        employee3.displayEmployeeDetails();
    }
}

// Employee class representing a company employee
class Employee {
    // Static variable shared among all instances, representing the company name
    private static String companyName = "Tech Solutions";
    
    // Static variable to keep track of total employees in the company
    private static int totalEmployees = 0;
    
    // Final variable to ensure the employee ID cannot be changed once assigned
    private final int id;
    
    // Instance variables for employee name and designation
    private String name;
    private String designation;

    // Constructor to initialize a new employee record
    public Employee(String name, int id, String designation) {
        this.name = name; // Using 'this' to refer to instance variable
        this.id = id;
        this.designation = designation;
        totalEmployees++; // Increment total employees whenever a new employee is added
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        // Checking if the object is an instance of Employee (not necessary here, but included as per instruction)
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee Name: " + name);
            System.out.println("Employee ID: " + id);
            System.out.println("Designation: " + designation);
            System.out.println();
        }
    }

    // Static method to display the total number of employees in the company
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
}



// Design an Employee class with the following features:
// Static:
// A static variable companyName shared by all employees.
// A static method displayTotalEmployees() to show the total number of employees.
// This:
// Use this to initialize name, id, and designation in the constructor.
// Final:
// Use a final variable id for the employee ID, which cannot be modified after assignment.
// Instanceof
// Check if a given object is an instance of the Employee class before printing the employee details.
