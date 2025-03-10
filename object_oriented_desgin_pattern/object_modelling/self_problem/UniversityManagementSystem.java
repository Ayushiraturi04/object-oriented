import java.util.ArrayList;

// Course class (Courses exist independently and are associated with Students and Professors)
class Course {
    String courseName;
    private Professor professor; // Each course is taught by one professor
    private ArrayList<Student> students; // List of students enrolled in the course

    // Constructor to initialize course details
    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>(); // Initializing student list
    }

    // Method to assign a professor to the course
    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    // Method to enroll a student in the course
    public void enrollStudent(Student student) {
        students.add(student);
    }

    // Method to display course details
    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println("  - " + student.getName());
        }
        System.out.println();
    }
}

// Professor class (Professors are associated with courses they teach)
class Professor {
    private String name;

    // Constructor to initialize professor details
    public Professor(String name) {
        this.name = name;
    }

    // Get professor name
    public String getName() {
        return name;
    }
}

// Student class (Students are aggregated within the university and associated
// with courses)
class Student {
    private String name;
    private ArrayList<Course> courses; // List of courses the student is enrolled in

    // Constructor to initialize student details
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>(); // Initializing course list
    }

    // Method to enroll in a course
    public void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this); // Registering student in the course
    }

    // Method to view enrolled courses
    public void viewCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Course course : courses) {
                System.out.println("  - " + course.courseName);
            }
        }
        System.out.println();
    }

    // Get student name
    public String getName() {
        return name;
    }
}

// University class (Aggregates Students and Professors)
class University {
    private String universityName;
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Course> courses;

    // Constructor to initialize university details
    public University(String universityName) {
        this.universityName = universityName;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to add a professor
    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    // Method to add a course
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Method to display university details
    public void showUniversityDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Courses Offered:");
        for (Course course : courses) {
            course.showCourseDetails();
        }
    }
}

// Main class to demonstrate the University Management System
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating a university
        University university = new University("Global University");

        // Creating students
        Student alice = new Student("Alice Johnson");
        Student bob = new Student("Bob Smith");
        university.addStudent(alice);
        university.addStudent(bob);

        // Creating professors
        Professor drMiller = new Professor("Dr. Miller");
        Professor drAdams = new Professor("Dr. Adams");
        university.addProfessor(drMiller);
        university.addProfessor(drAdams);

        // Creating courses
        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");
        university.addCourse(math);
        university.addCourse(physics);

        // Assigning professors to courses
        math.assignProfessor(drMiller);
        physics.assignProfessor(drAdams);

        // Students enrolling in courses
        alice.enrollCourse(math);
        bob.enrollCourse(math);
        bob.enrollCourse(physics);

        // Displaying university details
        System.out.println();
        university.showUniversityDetails();

        // Displaying student details
        alice.viewCourses();
        bob.viewCourses();
    }
}
