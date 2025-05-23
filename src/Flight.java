import java.util.Objects;

//--------------------- abstraction --------------------------------
abstract class Flight {

    int id;

    private String date;
    private String airport;
    private String time;

    static int seatsAvailable = 1;

    //--------------------- constructor --------------------------------
    public Flight(int id, int seatsAvailable) {
        //--------------------- using this keyword --------------------------------
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDate(){
        return date;
    }

    public String getTime() {return FlightTime.getFlightTime(Integer.parseInt(time));}

    public String getAirport() {
        return airport;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    //--------------------- enscapsulation --------------------------------
    // sets depart date
    public void setDate(String departDate) { date = departDate; }

    // sets depart date
    public void setTime(String departTime) { time = departTime; }

    // sets depart airport
    public void setAirport(String departAirport) {
        airport = departAirport;
    }


    @Override
    public String toString() {
        return String.format("Flight ID: " + id + System.lineSeparator()
                + "Flight Date: " + date + System.lineSeparator()
                + "Flight Airport: " + airport +  System.lineSeparator()
                + "Flight Time: " + FlightTime.getFlightTime(Integer.parseInt(time))
        );
    }


}

