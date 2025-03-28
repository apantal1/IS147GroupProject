public class Flight {
    private int id;
    int month;
    int day;
    int year;

    int seatsAvailable = 30;

    public Flight(int id, int month, int day, int year) {
        this.id = id;
        this.month = month;
        this.day = day;
        this.year = year;
        seatsAvailable--;
    }

    public int getId() {
        return id;
    }

    public String getDate(){
        return month + "/" + day + "/" + year;
    }

    public int seatsAvailable() {
        return seatsAvailable;
    }
}

