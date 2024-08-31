import java.util.Date;

public class Reservation {
    private Room room;
    private String guestName;
    private Date startDate;
    private Date endDate;

    public Reservation(Room room, String guestName, Date startDate, Date endDate) {
        this.room = room;
        this.guestName = guestName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + room +
                ", guestName='" + guestName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
