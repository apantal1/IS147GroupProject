///**
// * The FlightMenu class provides a simple text-based menu for users to interact with flight booking options.
// * Users can choose to book a flight, view all booked flights, cancel a flight, or exit the application.
// * The class utilizes a Scanner object to capture user input and process the selected option.
// * <p>
// * This menu prompts the user for flight details such as whether the flight is a round trip or one-way,
// * and depending on the choice, it calls methods from the FlightDate and AllFlights classes to handle flight operations.
// *
// * @see FlightDate
// * @see AllFlights
// */

import java.util.Scanner;

public class FlightMenu {

    public static void start() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1. Book a flight");
            System.out.println("2. View all booked flights");
            System.out.println("3. Cancel a flight");
            System.out.println("4. Exit");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Is this a round trip flight? (y/n)");
                    char answer = input.nextLine().charAt(0);
                    if(answer == 'y') {
                        FlightDate.askDepart();
                        FlightDate.askArrive();
                    } else if (answer == 'n') {
                        FlightDate.askDepart();
                    } else {
                        System.out.println("Invalid answer. Please input y for round trip and n for one way.");
                    }
                    break;
                case 2:
                    AllFlights.listFlights();
                    break;
                case 3:
                    System.out.print("Reservation ID to cancel: ");
                    int id = input.nextInt();
                    input.nextLine();

                    if (AllFlights.cancelFlight(id)) {
                        System.out.println("Reservation canceled");
                    } else {
                        System.out.println("Reservation not found");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();

        }
    }
}
