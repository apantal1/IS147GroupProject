import java.time.*;
import java.time.format.*;
import  java.util.*;

public class FlightDate {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");

    // Splits the date given by the user into month day and year variables
    public static String[] splitDate(String scanDate) {
        return scanDate.split("/");
    }

    // returns the month of the flight
    public static int getMonth(String scanDate) {
        return Integer.parseInt(splitDate(scanDate)[0]);
    }

    // returns the day of the flight
    public static int getDay(String scanDate) {
        return Integer.parseInt(splitDate(scanDate)[1]);
    }

    // returns the year of the flight
    public static int getYear(String scanDate) {
        return Integer.parseInt(splitDate(scanDate)[2]);
    }

    // asks the user when they would like to depart
    public static void askDepart() {
        Scanner input = new Scanner(System.in);
        String departDate;
        do {
            System.out.println("Enter your desired departure date (MM/dd/yyyy): ");
            departDate = input.nextLine();
        } while (!checkValid(departDate) || !checkDepart(departDate));
    }

    //asks the users when they would like to arrive (if round trip = true)
    public static void askArrive() {
        Scanner input = new Scanner(System.in);
        String arrivalDate;
        do {
            System.out.println("Enter your desired arrival date (MM/dd/yyyy):");
            arrivalDate = input.nextLine();
        } while (!checkValid(arrivalDate) || !checkArrive(arrivalDate));

    }

    // checks that the date is formatted correctly and that the date exists (ie is not February 30th)
    public static Boolean checkValid(String scanDate) {
        try {
            //checks if date is formatted correctly
            LocalDate inputtedDate = LocalDate.parse(scanDate, formatter);
            //checks if date exists
            LocalDate.of(getYear(scanDate), getMonth(scanDate), getDay(scanDate));
        } catch (DateTimeParseException e) {
            throwError("DateTimeParseException");
            return false;
        } catch(DateTimeException e) {
            throwError("DateTimeException");
            return false;
        }
        return true;
    }

    // checks that the date has not passed
    public static Boolean checkPassed(String scanDate) {
        return LocalDate.parse(scanDate, formatter).isBefore(LocalDate.now());
    }

    // checks that the date is within the booking window (180 days)
    public static Boolean checkPassedWindow(String scanDate) {
        return LocalDate.parse(scanDate, formatter).isAfter(LocalDate.now().plusDays(180));
    }

    // checks that the arrival date is not before the departure date
    public static Boolean checkBeforeDeparture(String scanDate) {
        return LocalDate.parse(scanDate, formatter).isBefore(LocalDate.parse(AllFlights.getLastBookedDate(), formatter));
    }

    // checks that the arrival date is not after the booking window (31 days after departure)
    public static Boolean checkPassedArrivalWindow(String scanDate) {
        return LocalDate.parse(scanDate,formatter).isAfter(LocalDate.parse(AllFlights.getLastBookedDate(), formatter).plusDays(31));
    }

    public static Boolean checkDepart(String departDate) {
        if (checkPassed(departDate)) {
            throwError("checkPassed");
            return false;
        } else if (checkPassedWindow(departDate)) {
            throwError("checkPassedWindow");
            return false;
        } else{
            bookFlight(departDate, false);
            return true;
        }
    }

    public static boolean checkArrive(String arrivalDate) {

        if (checkPassed(arrivalDate)) {
            throwError("checkPassed");
            return false;
        } else if(checkBeforeDeparture(arrivalDate)) {
            throwError("checkBeforeDeparture");
            return false;
        } else if(checkPassedArrivalWindow(arrivalDate)){
            throwError("checkPassedArrivalWindow");
            return false;
        } else {
            bookFlight(arrivalDate, true);
            return true;
        }
    }

    public static void bookFlight(String date, Boolean isArrive) {
            AllFlights.bookFlight(getMonth(date), getDay(date), getYear(date));
            if (isArrive) {
                System.out.println("You have chosen " + date + " as your arrival date.");
            } else {
            System.out.println("You have chosen " + date + " as your departure date.");
        }
    }

    // Throws errors for check date methods
    public static void throwError(String error) {
        switch (error) {
            case "checkPassed"  : {
                System.out.println("That day has passed. Please choose a day after " + LocalDate.now().format(formatter) + " and before " + LocalDate.now().plusDays(180).format(formatter));
                break;
            }
            case "checkPassedWindow" : {
                System.out.println("That day is too far into the future. Please choose a day after " + LocalDate.now().format(formatter) + " and before " + LocalDate.now().plusDays(180).format(formatter));
                break;
            }
            case "checkBeforeDeparture"  : {
                System.out.println("That date is before the departure date. Please enter the date after " + AllFlights.getLastBookedDate() + " in MM/dd/yyyy format.");
                break;
            }
            case "checkPassedArrivalWindow"  : {
                System.out.println("That date is too far in the future. Please select a date before " + AllFlights.getLastBookedDate()  + " in MM/dd/yyyy format.");
                break;
            }
            case "DateTimeParseException" : {
                System.out.println("Invalid date format. Please enter the date in MM/dd/yyyy format.");
                break;
            }
            case "DateTimeException" : {
                System.out.println("That date does not exist. Please enter a valid date in MM/dd/yyyy format.");
                break;
            }
            default : {
                break;
            }
        }
    }
}



