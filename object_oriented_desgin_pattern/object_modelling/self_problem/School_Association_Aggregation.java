import java.util.ArrayList;

// Course class (Students can enroll in multiple courses)
class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents; // Students enrolled in this course

    // Constructor to initialize course
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    // Method to enroll a student in the course
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    // Display enrolled students
    public void showStudents() {
        System.out.println("Course: " + courseName + " - Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println(student.getName());
        }
    }

    // Get course name
    public String getCourseName() {
        return courseName;
    }
}

// Student class (Each student can enroll in multiple courses)
class Student {
    private String name;
    private ArrayList<Course> courses; // Courses this student is enrolled in

    // Constructor to initialize student
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Method to enroll in a course
    public void enroll(Course course) {
        courses.add(course);
        course.enrollStudent(this); // Establish two-way association
    }

    // Display student's enrolled courses
    public void showCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }

    // Get student name
    public String getName() {
        return name;
    }
}

// School class (Aggregation: A school has multiple students)
class School {
    private String name;
    private ArrayList<Student> students; // Students in the school

    // Constructor to initialize school
    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    // Method to add a student to the school
    public void addStudent(Student student) {
        students.add(student);
    }

    // Display students in the school
    public void showStudents() {
        System.out.println("School: " + name + " - Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}

public class School_Association_Aggregation {
    public static void main(String[] args) {
        // Creating a school
        School school = new School("Greenwood High");

        // Creating students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Creating courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Enrolling students in courses
        student1.enroll(math);
        student1.enroll(science);

        student2.enroll(science);

        // Adding students to the school (Aggregation)
        school.addStudent(student1);
        school.addStudent(student2);

        // Displaying details
        school.showStudents();
        System.out.println();

        student1.showCourses();
        System.out.println();

        student2.showCourses();
        System.out.println();

        math.showStudents();
        System.out.println();

        science.showStudents();
    }
}
