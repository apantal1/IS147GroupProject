abstract class Flight {
    int id;
    private String date;
    private String airport;
    private String time;


    static int seatsAvailable = 1;

    public Flight(int departId, int seatsAvailable) {
        id = departId;
    }

    public int getId() {
        return id;
    }

    public String getDate(){
        return date;
    }

    public String getTime() { return time;}

    public String getAirport() {
        return airport;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    //--------------------- ASSIGNMENT OPERATORS --------------------------------
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
        return "Flight ID: " + id + " |  Flight Date: " + date + " | Flight Airport: " + airport + " | Flight Time: " + time + " | Seats Available: " + seatsAvailable;
    }


}

