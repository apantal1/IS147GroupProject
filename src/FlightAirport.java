//--------------------- inheritance --------------------------------
public class FlightAirport extends FlightDate {
    String airport;

    public FlightAirport(String airport) {
        //--------------------- super keyword --------------------------------
        super(airport);
    }

    public static String askAirport() {
        String airport;
        do {
            System.out.println("Enter the desired departure airport:");
            System.out.println("LAX");
            System.out.println("BWI");
            airport = input.nextLine().toUpperCase();
        } while (!CheckInput.checkAirport(airport));

        return airport;
    }

    @Override
    public String toString() { return airport; }

}


