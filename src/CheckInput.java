//--------------------- Using Java library class such as Date, Random etc --------------------------------
import java.time.*;
import java.time.format.*;
import java.util.Objects;

public class CheckInput {

    //--------------------- Variables,Constants --------------------------------
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");

    // checks that the date is formatted correctly and that the date exists (ie is not February 30th)
    public static Boolean checkValid(String scanDate) {
        try {
            //checks if date is formatted correctly
            LocalDate inputtedDate = LocalDate.parse(scanDate, formatter);
            int year = inputtedDate.getYear();
            int month = inputtedDate.getMonthValue();
            int day = inputtedDate.getDayOfMonth();
            //checks if date exists
            LocalDate.of(year, month, day);
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

    // checks that depart date meets checkPassed and checkPassedWindow conditions
    public static Boolean checkDepart(String departDate) {
        if (checkPassed(departDate)) {
            throwError("checkPassed");
            return false;
        } else if (checkPassedWindow(departDate)) {
            throwError("checkPassedWindow");
            return false;
        } else{
            return true;
        }
    }

    // checks that depart date meets checkAirport condition
    public static boolean checkAirport (String airport) {
        //--------------------- string class method --------------------------------
        if (Objects.equals(airport, "LAX") || Objects.equals(airport, "BWI")) {
            return true;
        } else {
            throwError("checkAirport");
            return false;
        }
    }

    // checks that depart time meets checkAirport condition
    public static boolean checkTime (String departTime) {
        int time = Integer.parseInt(departTime);

        //--------------------- logical operator --------------------------------
        if (time <= 7 && time >= 0) {
            return true;
        } else {
            throwError("checkTime");
            return false;
        }
    }

    public static boolean checkBooked(String date, String airport, String time) {
        Flight flight = AllFlights.getFlightbyParams(date, airport, time);

        //--------------------- conditional operator --------------------------------
        if (flight != null) {
            if (flight.getSeatsAvailable() <= 0) {
                CheckInput.throwError("booked");
                return false;
            }
        }
        AllFlights.bookFlight(date, airport, time);
        return true;
    }


    // Throws errors for check methods
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
            case "DateTimeParseException" : {
                System.out.println("Invalid date format. Please enter the date in MM/dd/yyyy format.");
                break;
            }
            case "DateTimeException" : {
                System.out.println("That date does not exist. Please enter a valid date in MM/dd/yyyy format.");
                break;
            }
            case "checkAirport" : {
                System.out.println("Error. Please choose LAX or BWI.");
                break;
            }
            case "checkTime" : {
                System.out.println("Error. Please choose an option between 1 and 7");
                break;
            }
            case "NumberFormatException" : {
                System.out.println("Error. Please input a number between 1 and 5.");
                break;
            }
            case "booked" : {
                System.out.println("There are no seats available for this date and time. Please choose another date/time.");
                break;
            }
            default : {
                break;
            }
        }
    }
}
