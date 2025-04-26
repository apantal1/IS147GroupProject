//Displays a welcome message and booking system details for Altitude Airline.
// The program provides the user with the option to book a departure date up to 180 days
// in advance, and a return trip arrival date up to 14 days after the departure date.
// <p>
// This method uses the current system date formatted as MM/dd/yyyy to inform users about the
// booking policy for departure and return dates.
// @see FlightMenu

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * The {@code Main} class is the entry point for the Altitude Airline booking system.
 * It displays a welcome message, shows booking guidelines, and starts the flight menu interface.
 */
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //input for depart date

        System.out.println("Welcome to the Altitude Airline booking system!");
        System.out.printf("You can book a departure date to 180 days in %nadvance (" + LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + ")%n");

        FlightMenu.start();
    }
}
