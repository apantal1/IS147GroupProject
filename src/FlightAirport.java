//--------------------- inheritance --------------------------------
public class FlightAirport extends FlightDate {
    String airport;

    public FlightAirport(String airport) {
        //--------------------- super keyword --------------------------------
        super(airport);
        this.airport = airport;
    }

    public static String AskAirport() {
        String airport;
        do {
            System.out.println("Enter the desired departure airport:");
            System.out.println("LAX");
            System.out.println("BWI");
            airport = input.nextLine().toUpperCase();
        } while (!checkInput.checkAirport(airport));

        return airport;
    }

    public String toString() {
        return airport;
    }


}


