import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        // Sample rooms
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
    }

    public List<Room> searchAvailableRooms(Date startDate, Date endDate) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            boolean isRoomBooked = false;
            for (Reservation reservation : reservations) {
                if (reservation.getRoom().equals(room) &&
                    !(endDate.before(reservation.getStartDate()) ||
                      startDate.after(reservation.getEndDate()))) {
                    isRoomBooked = true;
                    break;
                }
            }
            if (!isRoomBooked && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public boolean makeReservation(Room room, String guestName, Date startDate, Date endDate) {
        if (room.isAvailable() && searchAvailableRooms(startDate, endDate).contains(room)) {
            room.setAvailable(false);
            reservations.add(new Reservation(room, guestName, startDate, endDate));
            return true;
        }
        return false;
    }

    public Reservation viewBookingDetails(int roomNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().getRoomNumber() == roomNumber) {
                return reservation;
            }
        }
        return null;
    }

    public void simulatePaymentProcessing(Reservation reservation) {
        System.out.println("Processing payment for reservation: " + reservation);
        // Simulate payment processing logic here
    }
}
