package codealpha_hotelreservation;
import java.util.*;
import java.io.*;

public class HotelSystem {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    public HotelSystem() {
        rooms.add(new Room(101, "Standard",1000));
        rooms.add(new Room(102, "Deluxe", 2000));
        rooms.add(new Room(103, "Suite", 3000));

        loadBookings(); // load from file
    }

    public void showAvailableRooms() {
        for (Room r : rooms) {
            if (r.isAvailable) {
                r.displayRoom();
            }
        }
    }

    public void bookRoom(String name, int roomNumber) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber && r.isAvailable) {
                r.isAvailable = false;

                Booking b = new Booking(name, roomNumber);
                bookings.add(b);

                saveBookings();

                System.out.println("ID:" + b.bookingId);
                 System.out.println("Booking Successful!");
                return;
            }
        }
        System.out.println("Room not available!");
    }

    public void cancelBooking(int roomNumber) {
        Iterator<Booking> it = bookings.iterator();

        while (it.hasNext()) {
            Booking b = it.next();
            if (b.roomNumber == roomNumber) {
                it.remove();

                for (Room r : rooms) {
                    if (r.roomNumber == roomNumber) {
                        r.isAvailable = true;
                    }
                }

                saveBookings();
                System.out.println(" Booking Cancelled!");
                return;
            }
        }
        System.out.println(" No booking found!");
    }

    public void showBookings() {
        for (Booking b : bookings) {
            b.displayBooking();
        }
    }

    //  Save to file
    public void saveBookings() {
        try {
            FileWriter fw = new FileWriter("bookings.txt");
            for (Booking b : bookings) {
                fw.write(b.customerName + "," + b.roomNumber + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving file!");
        }
    }

    //  Load from file
    public void loadBookings() {
        try {
            File file = new File("bookings.txt");
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                Booking b = new Booking(data[0], Integer.parseInt(data[1]));
                bookings.add(b);

                for (Room r : rooms) {
                    if (r.roomNumber == b.roomNumber) {
                        r.isAvailable = false;
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading file!");
        }
    }
}