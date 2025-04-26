import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AllFlights extends Flight{
     static List<Flight> flights = new ArrayList<>();


    // constructor that calls Flight class
    public AllFlights(int departId, int seatsAvailable) {
        super(departId, seatsAvailable);
    }

    public static Flight getFlightbyParams(String date, String airport, String time) {
        for (Flight flight : flights) {
            System.out.println(flight.getAirport());

            if (
                   Objects.equals(flight.getDate(), date) && Objects.equals(flight.getTime(), time) && Objects.equals(flight.getAirport().trim(), airport.trim())) {
                return flight;
            }

        }
        return null;
    }

    public static boolean checkBooked(String date, String airport, String time) {
        Flight flight = getFlightbyParams(date, airport, time);
        if (flight != null) {
            if (flight.getSeatsAvailable() <= 0) {
                checkInput.throwError("booked");
                return false;
            }
        }
        bookFlight(date, airport, time);
        return true;
    }


    // books flight based on given date and airport
    public static void bookFlight(String date, String airport, String time) {

        //--------------------- MATH METHOD --------------------------------
         int departID = 0;

            AllFlights flight = new AllFlights(departID++, seatsAvailable--);

            flight.setDate(date);
            flight.setAirport(airport);
            flight.setTime(time);


        flights.add(flight);

            System.out.println("You have booked a flight at " + date + " coming from " + airport);
            System.out.println("Your flight id is " + departID);


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

    // get last booked flight
    public static int getLastBookedFlight() {
        return flights.size();
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



}