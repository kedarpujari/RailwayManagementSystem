import java.util.*;

public class RailwayManagementSystem {
    private static List<Train> trains = new ArrayList<>();
    private static List<Passenger> passengers = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static int bookingIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nRailway Management System");
            System.out.println("1. Add Train");
            System.out.println("2. Add Passenger");
            System.out.println("3. Book Ticket");
            System.out.println("4. View All Trains");
            System.out.println("5. View All Passengers");
            System.out.println("6. View All Bookings");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTrain(scanner);
                    break;
                case 2:
                    addPassenger(scanner);
                    break;
                case 3:
                    bookTicket(scanner);
                    break;
                case 4:
                    viewAllTrains();
                    break;
                case 5:
                    viewAllPassengers();
                    break;
                case 6:
                    viewAllBookings();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }

    private static void addTrain(Scanner scanner) {
        System.out.print("Enter Train Number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Train Name: ");
        String trainName = scanner.nextLine();
        System.out.print("Enter Source: ");
        String source = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Capacity: ");
        int capacity = scanner.nextInt();

        Train train = new Train(trainNumber, trainName, source, destination, capacity);
        trains.add(train);
        System.out.println("Train added successfully!");
    }

    private static void addPassenger(Scanner scanner) {
        System.out.print("Enter Passenger ID: ");
        int passengerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Passenger Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        Passenger passenger = new Passenger(passengerId, name, age);
        passengers.add(passenger);
        System.out.println("Passenger added successfully!");
    }

    private static void bookTicket(Scanner scanner) {
        System.out.print("Enter Train Number for booking: ");
        int trainNumber = scanner.nextInt();
        Train train = findTrainByNumber(trainNumber);

        if (train == null) {
            System.out.println("Train not found!");
            return;
        }

        System.out.print("Enter Passenger ID: ");
        int passengerId = scanner.nextInt();
        Passenger passenger = findPassengerById(passengerId);

        if (passenger == null) {
            System.out.println("Passenger not found!");
            return;
        }

        Booking booking = new Booking(bookingIdCounter++, train, passenger);
        bookings.add(booking);
        System.out.println("Booking successful! Booking ID: " + booking.getBookingId());
    }

    private static void viewAllTrains() {
        if (trains.isEmpty()) {
            System.out.println("No trains available.");
        } else {
            for (Train train : trains) {
                System.out.println(train.toString());
            }
        }
    }

    private static void viewAllPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers available.");
        } else {
            for (Passenger passenger : passengers) {
                System.out.println(passenger.toString());
            }
        }
    }

    private static void viewAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking.toString());
            }
        }
    }

    private static Train findTrainByNumber(int trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        return null;
    }

    private static Passenger findPassengerById(int passengerId) {
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerId() == passengerId) {
                return passenger;
            }
        }
        return null;
    }
}
