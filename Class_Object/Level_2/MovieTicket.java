package Level_2;

// Movie class to store ticket details and perform booking
class Movie {
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean isBooked;

    // Constructor to initialize ticket details
    public Movie(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = false; // Initially, the seat is not booked
    }

    // Method to book a ticket
    public void bookTicket() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Ticket booked successfully for " + movieName + " (Seat: " + seatNumber + ").");
            System.out.println("Total Price:" + price);
        } else {
            System.out.println("Sorry, Seat " + seatNumber + " is already booked.");
        }
    }

    // Method to display ticket details
    public void displayTicketDetails() {
        System.out.println("Ticket Details");
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price:" + price);
        System.out.println("Booking Status: " + (isBooked ? "Booked" : "Available"));
    }
}

// Main class to execute the ticket booking system
public class MovieTicket {
    public static void main(String[] args) {
        // Predefined ticket details
        Movie ticket1 = new Movie("Interstellar", "12", 250.0);
        Movie ticket2 = new Movie("Inception", "13", 300.0);

        // Booking tickets
        ticket1.bookTicket();
        ticket2.bookTicket();

        // Displaying ticket details
        ticket1.displayTicketDetails();
        ticket2.displayTicketDetails();
    }
}
