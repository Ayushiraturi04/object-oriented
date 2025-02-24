package Level_1;

class employee {
    // Attributes
    String name;
    int id;
    double salary;

    // Constructor
    public employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary:" + salary);
    }

    public static void main(String[] args) {
        // Creating an Employee object
        employee emp1 = new employee("Ayushi", 101, 50000);
        emp1.displayDetails();
    }
}
