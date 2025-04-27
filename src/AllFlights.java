import java.util.ArrayList;
import java.util.List;

public class AllFlights extends Flight{
     static List<Flight> flights = new ArrayList<>();


    // constructor that calls Flight class
    public AllFlights(int departId, int seatsAvailable) {
        super(departId, seatsAvailable);
    }
    public static int departID = 0;


    public static boolean checkBooked(String date, String airport, String time) {
        Flight flight = getFlightbyParams(date, airport, time);

        //--------------------- conditional operator --------------------------------
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