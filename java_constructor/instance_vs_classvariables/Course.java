package instance_vs_classvariables;

class Course {
    // Instance variables
    private String courseName;
    private int duration;
    private double fee;

    // Class variable
    private static String instituteName = "Default Institute";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee:" + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class method to update institute name
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    // Main method to test the class
    public static void main(String[] args) {
        Course.updateInstituteName("Tech Academy");

        Course c1 = new Course("Java Programming", 3, 299.99);
        Course c2 = new Course("Web Development", 4, 399.99);

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}
