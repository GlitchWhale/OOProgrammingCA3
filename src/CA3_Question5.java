import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Name: Bianca Valicec
 * Class Group: SD2B
 * Question 5 – Airport Flights (Queue)
 * An airport has only one runway. When it is busy, planes wishing to take off or land have to
 * wait. Implement a simulation, using two queues, one each for the planes waiting to take off
 * and land. Landing planes get priority. The user enters commands takeoff flightSymbol,
 * land flightSymbol, next, and quit. The first two commands place the flight in the
 * appropriate queue. The next command finishes the current takeoff or landing and enables
 * the next one, printing the action (takeoff or land) and the flight symbol.
 * For example:
 * takeoff( “Flight-100”); // is queued
 * takeoff(“Flight-220”); // is queued
 * land(“Flight-320”); // is queued
 * next(); // will complete the takeoff/landing of the current flight and initiate landing of the next prioritized flight i.e. Flight-320
 */

public class CA3_Question5 {

    public static void main(String[] args) {
        Queue<String> takeOff = new LinkedList<>();
        Queue<String> land = new LinkedList<>();
        Scanner kb = new Scanner(System.in);
        String input;
        String flight;
        boolean loop;

        //ask the user to enter a command until they enter quit
        do {
            System.out.println("Enter a command (takeoff, land, next, quit)");
            input = kb.nextLine();
            //if the user enters takeoff, prompt them to enter a flight symbol and add it to the takeoff queue
            switch (input) {
                case "takeoff" -> {
                    loop = true;
                    while (loop) {
                        System.out.println("Enter a flight symbol, enter back to stop adding flights");
                        flight = kb.nextLine();
                        takeOff.add(flight);
                        System.out.println(flight + " added to takeoff queue");
                        if (flight.equals("back")) {
                            loop = false;
                        }
                    }
                }
                //if the user enters land, prompt them to enter a flight symbol and add it to the land queue
                case "land" -> {
                    loop = true;
                    while (loop) {
                        System.out.println("Enter a flight symbol, enter back to stop adding flights");
                        flight = kb.nextLine();
                        land.add(flight);
                        System.out.println(flight + " added to land queue");
                        if (flight.equals("back")) {
                            loop = false;
                        }
                    }
                }
                //complete the takeoff or landing of the current flight and initiate landing of the next prioritized flight
                case "next" -> {
                    //I don't understand if you land all flights then takeoff all flights or if you land one then takeoff one
                }
            }
        } while (!input.equals("quit"));
    }
}
