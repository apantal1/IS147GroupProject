import java.time.*;
import java.time.format.*;
import java.util.Objects;

public class checkInput {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");

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

    public static boolean checkAirport (String airport) {
        if (Objects.equals(airport, "LAX") || Objects.equals(airport, "BWI")) {
            return true;
        } else {
            throwError("checkAirport");
            return false;
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
                case "checkAirport" : {
                    System.out.println("Error. Please choose LAX or BWI.");
                    break;
                }
                default : {
                    break;
                }
            }
        }
}
