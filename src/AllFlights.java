import java.util.ArrayList;
import java.util.List;

public class AllFlights {
    private static List<Flight> flights = new ArrayList<>();
    private static int nextId = 0;

    public static Flight bookFlight(String date, String departAirport) {
        nextId++;
        Flight flight = new Flight(nextId, date, departAirport);
        flights.add(flight);

        System.out.println("You have booked a flight at " + date + " coming from " +  departAirport);
        System.out.println("Your flight id is " + nextId);
        return flight;
    }

    public static List<Flight> getFlights() {
        return flights;
    }

    public static void listFlights() {
        System.out.println("Booked Flights:");
        String flightList = "";
        for (Flight f : getFlights()) {
            System.out.println(flightList = f.getId() + " - " + f.getDate() + " - " + f.getAirport());
        }
    }

    public static Flight getFlightById(int id) {
        for (Flight flight : flights) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        return null;
    }

    public static int getLastBookedFlight() {
        return flights.size();
    }

    public static String getLastBookedDate() {
        return getFlightById(getLastBookedFlight()).getDate();
    }

    public static boolean cancelFlight(int id) {
        Flight flight = getFlightById(id);
        if (flight != null) {
            flights.remove(flight);
            return true;
        }
        return false;
    }


}