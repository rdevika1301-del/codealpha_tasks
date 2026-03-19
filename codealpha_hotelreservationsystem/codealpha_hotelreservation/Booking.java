package codealpha_hotelreservation;

 public class Booking {
    static int idCounter = 1;

    int bookingId;
    String customerName;
    int roomNumber;

    public Booking(String customerName, int roomNumber) {
        this.bookingId = idCounter++;
        this.customerName = customerName;
        this.roomNumber = roomNumber;
    }

    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId +
                " | Name: " + customerName +
                " | Room: " + roomNumber);
    }
} 
    

