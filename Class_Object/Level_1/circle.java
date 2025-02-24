package Level_1;

class circle {
    // Attributes
    double radius;

    // constructor
    public circle(double radius) {
        this.radius = radius;
    }

    // Method for area
    public double calculatearea() {
        return Math.PI * Math.pow(radius, 2);
    }

    // Method for circumference
    public double calculatecircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display
    public void display() {
        System.out.println("radius:" + radius);
        System.out.println("Area of circle:" + calculatearea());
        System.out.println("radius:" + calculatecircumference());
    }

    public static void main(String[] args) {
        circle c = new circle(5.0);
        c.display();
    }

}
