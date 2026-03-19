package codealpha_hotelreservation;
    public class Room {
    int roomNumber;
    String category;
    int price;
    boolean isAvailable;

    public Room(int roomNumber, String category, int price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }

    public void displayRoom() {
        System.out.println("Room No: " + roomNumber +
                " | Category: " + category +
                " | Price: $" + price +
                " | Available: " + isAvailable);
    }
}

