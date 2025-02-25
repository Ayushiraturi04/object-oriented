package level_1;

class Person {
    private String name;
    private int age;

    // Parameterized Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor (Cloning another person's attributes)
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display person details
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Main class to test the Person class
public class Persons {
    public static void main(String[] args) {
        // Creating an original person object
        Person person1 = new Person("Alice", 25);
        System.out.println("Original Person:");
        person1.display();

        // Creating a new person using the copy constructor
        Person person2 = new Person(person1);
        System.out.println("Cloned Person:");
        person2.display();
    }
}
