/*
date class methods

checkValid(): checks if a date is in the valid format & is in the present day
checkDepart(): checks if departure date is in the departure window (180 days)
checkArrive(): checks if arrival date is after the departure date and in the arrival window (14 days after depart date)

askDepart(): asks for depart date. Throws error if depart date is invalid.
askArrive(): asks for arrival date. Throws error if arrival date is invalid

sendRequest(): sends request to Flight.listFlights() if date is valid
 */

import java.time.*;
import java.time.format.*;
import  java.util.*;

public class FlightDate {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");

    public static String[] splitDate(String scanDate) {
        return scanDate.split("/");
    }

    public static int getMonth(String scanDate) {
        return Integer.parseInt(splitDate(scanDate)[0]);
    }

    public static int getDay(String scanDate) {
        return Integer.parseInt(splitDate(scanDate)[1]);
    }

    public static int getYear(String scanDate) {
        return Integer.parseInt(splitDate(scanDate)[2]);
    }

    public static void askDepart() {
        Scanner input = new Scanner(System.in);
        String departDate;
        do {
            System.out.println("Enter your desired departure date (MM/dd/yyyy): ");
            departDate = input.nextLine();
        } while (!checkValid(departDate) || !checkDepart(departDate));
    }

    //checkValid()
    public static Boolean checkValid(String scanDate) {
        try {
            //checks if date is formatted correctly
            LocalDate inputtedDate = LocalDate.parse(scanDate, formatter);
            LocalDate.of(getYear(scanDate), getMonth(scanDate), getDay(scanDate));

            //checks if date exists

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in MM/dd/yyyy format.");
            return false;
        } catch(DateTimeException e) {
            System.out.println("That date does not exist. Please enter a valid date in MM/dd/yyyy format.");

            return false;
        }

        return true;
    }



    public static Boolean checkDepart(String departDate) {
        LocalDate inputtedDate = LocalDate.parse(departDate, formatter);
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(360);
        if (inputtedDate.isBefore(today)) {
            System.out.println("That day has passed. Please choose a day after " + LocalDate.now().format(formatter) + " and before " + endDate.format(formatter));
            return false;
        } else if (inputtedDate.isAfter(endDate)) {
            System.out.println("That day is too far into the future. Please choose a day after " + LocalDate.now().format(formatter) + " and before " + endDate.format(formatter));
            return false;
        } else{
            System.out.println("You have chosen " + departDate + " as your departure date.");
            AllFlights.bookFlight(getMonth(departDate), getDay(departDate), getYear(departDate));
            return true;
        }
    }


    public static void askArrive() {
        Scanner input = new Scanner(System.in);
        String arrivalDate;
        do {
            System.out.println("Enter your desired arrival date (MM/dd/yyyy):");
            arrivalDate = input.nextLine();
        } while (!checkArrive(arrivalDate) || !checkValid(arrivalDate));

    }

    public static boolean checkArrive(String arrivalDate) {
        LocalDate arrive = LocalDate.parse(arrivalDate, formatter);
        LocalDate depart = LocalDate.parse(AllFlights.getLastBookedDate(), formatter);

        LocalDate endDate = depart.plusDays(31);

        if (arrive.isBefore(depart)) {
            System.out.println("That date is before the departure date. Please enter the date after the departure date in MM/dd/yyyy format.");
            return false;
        } else {
            AllFlights.bookFlight(getMonth(arrivalDate), getDay(arrivalDate), getYear(arrivalDate));
            System.out.println("You have chosen " + arrivalDate + " as your arrival date.");
            return true;
        }


    }

}



