package Level_2;

class Student {
    // Attributes
    String name;
    int rollNumber;
    int marks;

    // Constructor
    public Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade
    public char calculateGrade() {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else if (marks >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }

    // Method to display student details
    public void display() {
        System.out.println("Name of student: " + name);
        System.out.println("Roll Number of student: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    // Main method
    public static void main(String[] args) {
        Student s1 = new Student("Ayushi", 5, 85);
        s1.display();
    }
}
