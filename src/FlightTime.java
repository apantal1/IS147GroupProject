public class FlightTime extends FlightDate {
    String time;

    public FlightTime(String departTime) {
        super(departTime);
    }

    public static void listDepartureTimes() {
        String[][] availableFlights = new String[7][2];
        availableFlights[0][0] = "1";
        availableFlights[1][0] = "2";
        availableFlights[2][0] = "3";
        availableFlights[3][0] = "4";
        availableFlights[4][0] = "5";
        availableFlights[5][0] = "6";
        availableFlights[6][0] = "7";

        availableFlights[0][1] = "5:00 am";
        availableFlights[1][1] = "8:00 am";
        availableFlights[2][1] = "11:00 am";
        availableFlights[3][1] = "02:00 am";
        availableFlights[4][1] = "05:00 pm";
        availableFlights[5][1] = "08:00 pm";
        availableFlights[6][1] = "11:00 pm";

        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 2; j++) {
                System.out.print(availableFlights[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String AskTime() {
        String time;
        do {
            System.out.println("Enter the desired departure time:");
            listDepartureTimes();
            time = input.nextLine();
        } while (!checkInput.checkTime(time));

        return time;
    }

    public String toString() {
        return time;
    }

}
