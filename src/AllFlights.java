import java.util.ArrayList;
import java.util.List;

public class AllFlights {
    private static List<Flight> flights = new ArrayList<>();
    private static int nextId = 1;

    public static Flight bookFlight(int month, int day, int year) {
        Flight flight = new Flight(nextId++, month, day, year);
        flights.add(flight);
        return flight;
    }

    public static List<Flight> getFlights() {
        return flights;
    }

    public static void listFlights() {
        System.out.println("Available Flights:");
        String flightList = "";
        for (Flight r : getFlights()) {
            System.out.println(flightList = r.getId() + " - " + r.getDate() + " - " + r.seatsAvailable);
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