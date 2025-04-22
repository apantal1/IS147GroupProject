import  java.util.*;

public class FlightAirport {
    String airport;
    public static Scanner input = new Scanner(System.in);

    public FlightAirport(String airport) {
        this.airport = airport;
    }

    public void setAirport(String uAirport) {
        airport = uAirport;
    }

    public static String AskAirport() {
        String airport;
        int LAX = 1;
        int BWI = 2;
        do {
            System.out.println("Enter the desired departure airport:");
            System.out.println("LAX");
            System.out.println("BWI");
            airport = input.nextLine();
        } while (!checkInput.checkAirport(airport));

        return airport;
    }


}


