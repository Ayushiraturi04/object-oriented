package level_1;

class Circle {
    double radius;

    // Default constructor (calls parameterized constructor with default value)
    public Circle() {
        this(1.0); // Constructor chaining: Calls the parameterized constructor
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate and return area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Method to display the circle details
    public void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
    }
}

// Main class to test the Circle class
public class Circler {
    public static void main(String[] args) {
        // Creating Circle object using the default constructor
        Circle circle1 = new Circle();
        circle1.display(); // Displays default radius (1.0)

        // Creating Circle object using the parameterized constructor
        Circle circle2 = new Circle(5.5);
        circle2.display(); // Displays user-provided radius (5.5)
    }
}
