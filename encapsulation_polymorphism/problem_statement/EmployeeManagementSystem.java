import java.util.ArrayList;
import java.util.List;

// Abstract class representing an Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    // Constructor to initialize employee details
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters for encapsulation
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    // Concrete method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Final Salary: " + calculateSalary());
    }
}

// Interface representing Department functionality
interface Department {
    void assignDepartment(String departmentName);

    String getDepartmentDetails();
}

// Full-time employee subclass
class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double bonus;

    // Constructor initializing Full-time Employee details
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    // Implementing abstract method to calculate salary
    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus; // Full-time employees get a fixed salary + bonus
    }

    // Implementing interface methods
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Part-time employee subclass
class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int hoursWorked;
    private double hourlyRate;

    // Constructor initializing Part-time Employee details
    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Implementing abstract method to calculate salary
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate; // Part-time employees are paid based on hours worked
    }

    // Implementing interface methods
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Main class to test the Employee Management System
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // List to store employees using polymorphism
        List<Employee> employees = new ArrayList<>();

        // Creating full-time and part-time employees
        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 50000, 10000);
        emp1.assignDepartment("IT");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 0, 20, 500);
        emp2.assignDepartment("HR");

        // Adding employees to the list
        employees.add(emp1);
        employees.add(emp2);

        // Displaying employee details using polymorphism
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            System.out.println("----------------------------");
        }
    }
}
