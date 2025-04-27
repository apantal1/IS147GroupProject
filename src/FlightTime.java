public class FlightTime extends FlightDate {
    String time;

    public FlightTime(String departTime) {
        super(departTime);
    }

    public static String[][] flightTimes() {
        String[][] flightTimes = new String[7][2];
        flightTimes[0][0] = "1";
        flightTimes[1][0] = "2";
        flightTimes[2][0] = "3";
        flightTimes[3][0] = "4";
        flightTimes[4][0] = "5";
        flightTimes[5][0] = "6";
        flightTimes[6][0] = "7";

        flightTimes[0][1] = "5:00 am";
        flightTimes[1][1] = "8:00 am";
        flightTimes[2][1] = "11:00 am";
        flightTimes[3][1] = "02:00 am";
        flightTimes[4][1] = "05:00 pm";
        flightTimes[5][1] = "08:00 pm";
        flightTimes[6][1] = "11:00 pm";

        return flightTimes;
    }

    public static void listFlightTimes() {
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 2; j++) {
                System.out.print(flightTimes()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String AskTime() {
        String time;
        do {
            System.out.println("Enter the desired departure time:");
            listFlightTimes();
            time = input.nextLine();
        } while (!checkInput.checkTime(time));

        return time;
    }

    public static String getFlightTime(int menu) {
        return flightTimes()[menu][1];
    }

    public String toString() {
        return time;
    }

}
