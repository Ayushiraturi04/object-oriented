import java.util.ArrayList;

// Employee class (exists only within a Department)
class Employee {
    private String name;
    private String position;

    // Constructor to initialize employee details
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Overriding toString method to display employee details
    @Override
    public String toString() {
        return "Employee{Name='" + name + "', Position='" + position + "'}";
    }
}

// Department class (exists only within a Company)
class Department {
    String name;
    private ArrayList<Employee> employees; // List of employees in the department

    // Constructor to initialize department details
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>(); // Initializing employee list
    }

    // Method to add an employee to the department
    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    // Method to display department details and employees
    public void showEmployees() {
        System.out.println("Department: " + name);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

// Company class (contains Departments and owns their lifecycle)
class Company {
    private String name;
    private ArrayList<Department> departments; // List of departments in the company

    // Constructor to initialize company details
    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>(); // Initializing department list
    }

    // Method to add a department to the company
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Method to get a department by name
    public Department getDepartment(String departmentName) {
        for (Department dept : departments) {
            if (dept.name.equals(departmentName)) {
                return dept;
            }
        }
        return null;
    }

    // Method to display all departments and employees
    public void showCompanyDetails() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.showEmployees();
            System.out.println();
        }
    }

    // Destructor-like method to delete the company (simulating cleanup)
    public void deleteCompany() {
        departments.clear(); // Removing all departments and employees
        System.out.println("Company and all associated departments and employees deleted.");
    }
}

public class Company_composition {
    public static void main(String[] args) {
        // Creating a company
        Company company = new Company("TechCorp");

        // Adding departments
        company.addDepartment("Engineering");
        company.addDepartment("Marketing");

        // Adding employees to departments
        Department engineering = company.getDepartment("Engineering");
        if (engineering != null) {
            engineering.addEmployee("Alice Johnson", "Software Engineer");
            engineering.addEmployee("Bob Smith", "DevOps Engineer");
        }

        Department marketing = company.getDepartment("Marketing");
        if (marketing != null) {
            marketing.addEmployee("Charlie Brown", "Marketing Manager");
            marketing.addEmployee("David Lee", "SEO Specialist");
        }

        // Displaying company details
        company.showCompanyDetails();

        // Deleting the company (all departments and employees are removed)
        company.deleteCompany();
    }
}
