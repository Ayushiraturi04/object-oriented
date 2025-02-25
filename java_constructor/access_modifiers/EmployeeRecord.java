package access_modifiers;

// Base class: Employee
class Employee {
    public int employeeID; // Public: Accessible everywhere
    protected String department; // Protected: Accessible in subclass
    private double salary; // Private: Accessible only via methods

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // Setter for salary
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
            System.out.println("Salary updated to: " + salary);
        } else {
            System.out.println("Invalid salary amount!");
        }
    }

    // Display employee details
    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

// Subclass: Manager
class Manager extends Employee {
    private String teamName;

    // Constructor
    public Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    // Display Manager details
    public void displayManagerInfo() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID); // Public - Accessible
        System.out.println("Department: " + department); // Protected - Accessible in subclass
        System.out.println("Salary:" + getSalary()); // Access private via getter
        System.out.println("Team Name: " + teamName);
    }
}

// Main class to test
public class EmployeeRecord {
    public static void main(String[] args) {
        // Creating an Employee object
        Employee emp1 = new Employee(101, "HR", 60000);
        emp1.displayEmployeeInfo();

        // Modifying salary using setter
        emp1.setSalary(65000);
        System.out.println("Updated Salary: " + emp1.getSalary());

        // Creating a Manager object
        Manager mgr1 = new Manager(201, "IT", 90000, "Tech Team");
        mgr1.displayManagerInfo();
    }
}
