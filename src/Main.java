//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //input for depart date



        System.out.println("Welcome to the Altitude Airline booking system!");
        System.out.printf("You can book a departure date to 180 days in advance%n(" + LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "), and a round trip arrival date up to 14 days after%nyour desired departure date.%n");

        FlightDate.askDepart();
    }
}