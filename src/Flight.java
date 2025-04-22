public class Flight {
    int id;
    String date;
    String airport;

    int seatsAvailable = 30;

    public Flight(int departId, String departDate, String departAirport) {
        id = departId;
        date = departDate;
        airport = departAirport;
        seatsAvailable--;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public int getId() {
        return id;
    }

    public String getDate(){
        return date;
    }

    public String getAirport() {
        return airport;
    }

    public int seatsAvailable() {
        return seatsAvailable;
    }


    @Override
    public String toString() {
        return id + " " + date + " " + airport;
    }
}

