import java.util.Scanner;

public class FlightMenu {

    public static void start() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1. Book a flight");
            System.out.println("2. View all booked flights");
            System.out.println("3. Find flight by ID");
            System.out.println("4. Cancel a flight");
            System.out.println("5. Exit");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    String departDate;

                    String deptDate = FlightDate.askDepart();
                    String deptAirport = FlightAirport.AskAirport();

                    AllFlights.bookFlight(deptDate, deptAirport);

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
