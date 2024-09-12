package batomalaque.it2b;
import java.util.Scanner;

public class Reservation {
    private static int nextId = 1;
    private int bookingId;
    private String guestName;
    private String roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean paymentStatus;
    private String status;

    public Reservation(String guestName, String roomType, LocalDate checkInDate, LocalDate checkOutDate, boolean paymentStatus, String status) {
        this.bookingId = nextId++;
        this.guestName = guestName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.paymentStatus = paymentStatus;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    public String toString() {
        return "Booking ID: " + bookingId +
               ", Guest Name: " + guestName +
               ", Room Type: " + roomType +
               ", Check-in Date: " + checkInDate +
               ", Check-out Date: " + checkOutDate +
               ", Payment Status: " + (paymentStatus ? "Paid" : "Unpaid") +
               ", Status: " + status;
    }
}


