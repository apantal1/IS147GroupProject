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

import java.util.*;

public class FlightMenu {
    //--------------------- Scanner Class --------------------------------
    public static Scanner input = new Scanner(System.in);

    //--------------------- method overloading --------------------------------
    public static int getChoice(int choice) {
        return choice;
    }

    public static int getChoice(String choice) {
        while (!checkChoice(choice)) {
           choice = input.nextLine();
        }
        return Integer.parseInt(choice);
    }

    public static boolean checkChoice(String choice) {
        try {
            Integer.parseInt(choice);
        } catch (NumberFormatException  e) {
            CheckInput.throwError("NumberFormatException");
            return false;
        }
        return true;
    }

    public static void start() {


        //--------------------- loop --------------------------------
        while (true) {
            System.out.println("1. Book a flight");
            System.out.println("2. View all booked flights");
            System.out.println("3. Find flight by ID");
            System.out.println("4. Cancel a flight");
            System.out.println("5. Exit");

            int choice = getChoice(input.nextLine());


            //--------------------- switch statement --------------------------------
            switch (choice) {
                case 1:

                    //--------------------- Variables,Constants --------------------------------

                    String deptDate = FlightDate.askDepart();
                    String deptAirport = FlightAirport.askAirport();
                    String deptTime = FlightTime.AskTime();

                    //--------------------- Method passing argument by values --------------------------------

                    System.out.println("You are booking a flight for " + deptDate + " at " + deptTime + " departing from " + deptAirport);
                    System.out.println("Confirm? (y for yes, n for no)");
                    if(input.nextLine().equals("y")) {
                        CheckInput.checkBooked(deptDate, deptAirport, deptTime);

                    }

                    break;
                case 2:
                    if(AllFlights.getFlights().isEmpty()) {
                        System.out.println("There are no flights currently booked.");
                    } else {
                        AllFlights.listFlights();
                    }
                    break;
                case 3:
                    System.out.print("Flight ID: ");
                    int id = getChoice(input.nextInt());
                    System.out.println(AllFlights.getFlightById(id));
                    break;
                case 4:
                    System.out.print("Flight ID to cancel: ");
                    id = getChoice(input.nextInt());
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
