import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        
        // Search for available rooms
        Date startDate = new Date(2024, 8, 31);
        Date endDate = new Date(2024, 9, 5);
        System.out.println("Available rooms: " + hotel.searchAvailableRooms(startDate, endDate));
        
        // Make a reservation
        Room roomToBook = hotel.searchAvailableRooms(startDate, endDate).get(0); // Book the first available room
        boolean success = hotel.makeReservation(roomToBook, "John Doe", startDate, endDate);
        if (success) {
            System.out.println("Reservation successful.");
        } else {
            System.out.println("Reservation failed.");
        }
        
        // View booking details
        Reservation reservation = hotel.viewBookingDetails(roomToBook.getRoomNumber());
        System.out.println("Booking details: " + reservation);
        
        // Process payment
        if (reservation != null) {
            hotel.simulatePaymentProcessing(reservation);
        }
    }
}
