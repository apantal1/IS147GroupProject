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

        //--------------------- SCANNER CLASS --------------------------------
        Scanner input = new Scanner(System.in);

        //--------------------- LOOP --------------------------------
        while (true) {
            System.out.println("1. Book a flight");
            System.out.println("2. View all booked flights");
            System.out.println("3. Find flight by ID");
            System.out.println("4. Cancel a flight");
            System.out.println("5. Exit");

            int choice = input.nextInt();

            switch (choice) {
                case 1:

                    //--------------------- VARIABLES --------------------------------
                    String deptDate;
                    String deptTime;
                    String deptAirport;

                        deptDate = FlightDate.askDepart();
                        deptAirport = FlightAirport.AskAirport();
                        deptTime = FlightTime.AskTime();
                        AllFlights.checkBooked(deptDate, deptAirport, deptTime);


                    System.out.println();

                    break;
                case 2:
                    AllFlights.listFlights();
                    break;
                case 3:
                    System.out.print("Flight ID: ");
                    int id = input.nextInt();
                    System.out.println(AllFlights.getFlightById(id));
                    break;
                case 4:
                    System.out.print("Flight ID to cancel: ");
                    id = input.nextInt();
                    input.nextLine();

                    if (AllFlights.cancelFlight(id)) {
                        System.out.println("Flight canceled");
                    } else {
                        System.out.println("FLight not found");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();

        }
    }
}
