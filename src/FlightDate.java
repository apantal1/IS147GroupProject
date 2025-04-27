import  java.util.*;

public class FlightDate {

    String date;

    public FlightDate(String departDate) {
        date = departDate;
    }

    public static Scanner input = new Scanner(System.in);

    //--------------------- Return value from method --------------------------------
    // asks the user when they would like to depart
        public static String askDepart() {
            String departDate;
            do {
                System.out.println("Enter your desired departure date (MM/dd/yyyy): ");
                departDate = input.nextLine();
            } while (!CheckInput.checkValid(departDate) || !CheckInput.checkDepart(departDate));
            return departDate;
        }

    @Override
    public String toString() { return date; }

}



