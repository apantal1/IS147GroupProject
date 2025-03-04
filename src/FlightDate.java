/*
date class methods

checkValid(): checks if a date is in the valid format & is in the present day
checkDepart(): checks if departure date is in the departure window (180 days)
checkArrive(): checks if arrival date is after the departure date and in the arrival window (14 days after depart date)

askDepart(): asks for depart date. Throws error if depart date is invalid.
askArrive(): asks for arrival date. Throws error if arrival date is invalid

sendRequest(): sends request to Flight.listFlights() if date is valid
 */

import java.util.*;
import java.time.*;
import java.time.format.*;

public class FlightDate {
    int month;
    int day;
    int year;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


    //checkValid()
    public static Boolean checkValid(String scanDate) {
        try {
            //checks if date is formatted correctly
            LocalDate inputtedDate = LocalDate.parse(scanDate, formatter);

            //checks if date exists
            String[] parts = scanDate.split("/");
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            LocalDate.of(year, month, day);

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in MM/dd/yyyy format.");
            return false;
        } catch(DateTimeException e) {
            System.out.println("That date does not exist. Please enter a valid date in MM/dd/yyyy format.");

            return false;
        }

        return true;
    }

    public static void askDepart() {
        Scanner input = new Scanner(System.in);
        String departDate;
        do {
            System.out.println("Enter your desired departure date (MM/dd/yyyy): ");
            departDate = input.nextLine();
        } while (!checkValid(departDate) || !checkDepart(departDate));
    }


    public static Boolean checkDepart(String departDate) {
        LocalDate inputtedDate = LocalDate.parse(departDate, formatter);
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(180);
        if (inputtedDate.isBefore(today)) {
            System.out.println("That day has passed. Please choose a day after " + LocalDate.now().format(formatter) + " and before " + endDate.format(formatter));
            return false;
        } else if (inputtedDate.isAfter(endDate)) {
            System.out.println("That day is too far into the future. Please choose a day after " + LocalDate.now().format(formatter) + " and before " + endDate.format(formatter));
            return false;
        } else{
            System.out.println("You have chosen " + departDate + " as your departure date.");

            return true;
        }
    }

}



