import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AllFlights extends Flight{
     static List<Flight> flights = new ArrayList<>();


    // constructor that calls Flight class
    public AllFlights(int departId, int seatsAvailable) {
        super(departId, seatsAvailable);
    }
    public static int departID = 0;


    // books flight based on given date and airport
    public static void bookFlight(String date, String airport, String time) {
        //--------------------- math class method --------------------------------
        double recieptNum = Math.ceil(Math.random() * 10001);

        //--------------------- arithmetic operator --------------------------------
        //--------------------- create an object --------------------------------
        AllFlights flight = new AllFlights(departID++, seatsAvailable--);

        flight.setDate(date);
        flight.setAirport(airport);
        flight.setTime(time);

        flights.add(flight);

        System.out.printf("You have booked a flight on " + flight.getDate()  + " departing from " + flight.getAirport() + " at " + flight.getTime() +".%nYour flight id is " + departID + ".");
        System.out.println();
        System.out.print("Receipt Number: " );
        System.out.printf("%.0f", recieptNum);
        System.out.println();


    }

    // gets all flights
    public static List<Flight> getFlights() {
        return flights;
    }

    // lists all flights
    public static void listFlights() {
        System.out.println("Booked Flights:");
        String flightList = "";
        for (Flight f : getFlights()) {
            System.out.println(f);
        }
    }

    // gets flights by ID
    public static Flight getFlightById(int id) {
        for (Flight flight : flights) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        return null;
    }

    // cancels flight
    public static boolean cancelFlight(int id) {
        Flight flight = getFlightById(id);

        if (flight != null) {
            flights.remove(flight);
            return true;
        }
        return false;
    }

    public static Flight getFlightbyParams(String date, String airport, String time) {
        for (Flight flight : AllFlights.getFlights()) {
            System.out.println(flight.getAirport());

            if (
                    Objects.equals(flight.getDate(), date) && Objects.equals(flight.getTime(), time) && Objects.equals(flight.getAirport().trim(), airport.trim())) {
                return flight;
            }

        }
        return null;
    }


}