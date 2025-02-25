package level_1;

class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    // Default Constructor
    public HotelBooking() {
        this.guestName = "Unknown";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized Constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy Constructor (Cloning another booking)
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Method to display booking details
    public void display() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }
}

// Main class to test the HotelBooking system
public class HotelBookings {
    public static void main(String[] args) {
        // Using Default Constructor
        HotelBooking booking1 = new HotelBooking();
        System.out.println("Default Booking:");
        booking1.display();

        // Using Parameterized Constructor
        HotelBooking booking2 = new HotelBooking("Alice", "Deluxe", 3);
        System.out.println("Parameterized Booking:");
        booking2.display();

        // Using Copy Constructor
        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("Cloned Booking:");
        booking3.display();
    }
}