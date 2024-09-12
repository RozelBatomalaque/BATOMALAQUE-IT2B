package batomalaque.it2b;
import java.util.Scanner;

public class BookingHandler {
  
    private static final int NUM_ROOMS = 100;
    private Map<Integer, Reservation> reservations;
    private Scanner scanner;

    public BookingHandler() {
        reservations = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nHotel Booking Management System");
            System.out.println("1. Check availability");
            System.out.println("2. Book a room");
            System.out.println("3. Cancel a booking");
            System.out.println("4. View all bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    checkAvailability();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    viewBookings();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkAvailability() {
        System.out.print("Available rooms: ");
        for (int i = 1; i <= NUM_ROOMS; i++) {
            if (!reservations.containsKey(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private void bookRoom() {
        System.out.print("Enter room number to book (1-10): ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        if (roomNumber < 1 || roomNumber > NUM_ROOMS) {
            System.out.println("Invalid room number.");
            return;
        }
        if (reservations.containsKey(roomNumber)) {
            System.out.println("Room " + roomNumber + " is already booked.");
            return;
        }
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter room type (e.g., Single, Double): ");
        String roomType = scanner.nextLine();
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        LocalDate checkInDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Is the payment made? (true/false): ");
        boolean paymentStatus = scanner.nextBoolean();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter booking status (e.g., Confirmed, Pending): ");
        String status = scanner.nextLine();

        Reservation reservation = new Reservation(guestName, roomType, checkInDate, checkOutDate, paymentStatus, status);
        reservations.put(roomNumber, reservation);
        System.out.println("Room " + roomNumber + " successfully booked for " + guestName + ".");
    }

    private void cancelBooking() {
        System.out.print("Enter room number to cancel booking (1-10): ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); 
        if (roomNumber < 1 || roomNumber > NUM_ROOMS) {
            System.out.println("Invalid room number.");
            return;
        }
        Reservation reservation = reservations.remove(roomNumber);
        if (reservation == null) {
            System.out.println("Room " + roomNumber + " is not booked.");
        } else {
            System.out.println("Booking for room " + roomNumber + " by " + reservation.getGuestName() + " has been canceled.");
        }
    }

    private void viewBookings() {
        if (reservations.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Reservation reservation : reservations.values()) {
                System.out.println(reservation);
            }
        }
    }

    public static void main(String[] args) {
        BookingHandler handler = new BookingHandler();
        handler.start();
    }
}
 
    
