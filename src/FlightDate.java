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
            } while (!checkInput.checkValid(departDate) || !checkInput.checkDepart(departDate));
            return departDate;
        }


    public static void confirmDate(String date) {
        System.out.println("You have chosen " + date + " as your departure date.");
    }

    public String toString() {
            return date;
    }

}



