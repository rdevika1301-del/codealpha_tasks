package codealpha_hotelreservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelSystem system = new HotelSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== HOTEL MENU =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    system.showAvailableRooms();
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Room Number: ");
                    int room = sc.nextInt();
                    system.bookRoom(name, room);
                    break;

                case 3:
                    System.out.print("Enter Room Number: ");
                    int cancelRoom = sc.nextInt();
                    system.cancelBooking(cancelRoom);
                    break;

                case 4:
                    system.showBookings();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    System.exit(0);
            }
        }
    }
}