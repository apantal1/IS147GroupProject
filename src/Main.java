//Displays a welcome message and booking system details for Altitude Airline.
// The program provides the user with the option to book a departure date up to 180 days
// in advance, and a return trip arrival date up to 14 days after the departure date.
// <p>
// This method uses the current system date formatted as MM/dd/yyyy to inform users about the
// booking policy for departure and return dates.
// @see FlightMenu

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


//--------------------- PROJECT REQUIREMENTS --------------------------------
//1 Scanner Class --> FlightMenu ln 17
//2 Variables,Constants Variables --> thru project, Constant --> checkInput ln 8
//3 switch statement --> FlightMenu ln 55
//4 conditional operator --> AllFlights ln 30
//5 Operators(logical, arithmetical, assignment) logical --> checkInput ln 67, arithmetical --> AllFlights ln 50, assignment thru project
//6 String class method --> checkInput ln 53
//7 Math class method --> AllFlights ln 46
//8 Loop --> FLightMenu ln 44
//9 Method passing argument by values --> FlightMenu ln 65
//9 Return value from method --> FlightDate ln 15
//10 Method overloading --> FlightMenu ln 10
//11 Array --> FlightTime ln 8
//12 *Add multiple classes (min 3 files) --> FlightMenu, Flight, AllFlights
//13 Create an Object --> AllFlights ln 49
//14 *Constructor --> Flight ln 9
//15 *Super Keyword --> FlightAirport ln 5
//16 *Abstraction --> Flight ln 1
//17 Inheritance --> FlightAirport ln 1
//18 *Encapsulation --> Flight ln 35
//19 Using Java library class such as Date, Random etc --> checkInput ln 1 (LocalDate)
//20 Static variable and Static methods --> thru project
//21 Using this keyword --> Flight ln 14
//22 Modifier --> thru project
//23 Println ,printf methods --> thru project
//24 UML Diagrams
//25 Java Docs
//26 Github project Screenshot will breakdown of tasks
//27 Project Github link

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
        System.out.printf("You can book a departure date to 180 days in %nadvance (" + LocalDate.now().plusDays(180).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + ")%n");

        FlightMenu.start();

        System.out.println("Thank you for using the booking service. Please come again!");

    }
}
