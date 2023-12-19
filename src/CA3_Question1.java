import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Bianca Valicec
 * Class Group: SD2B
 * Question 1 – Car Parking (Stack)
 * A homeowner rents out parking spaces in a driveway during special events. The driveway is
 * a “last-in, first-out” LIFO stack. Of course, when a car owner retrieves a vehicle that wasn’t
 * the last one in, the cars blocking it must temporarily move to the street so that the
 * requested vehicle can leave. Write a program that models this behaviour, using one stack for
 * the driveway and one stack for the street. Use integer values as license plate numbers (e.g.
 * 1,2,3,4…). Positive numbers add a car (1,2,3…), negative numbers remove a car(-2,-1,…), zero
 * stops the simulation. Print out the stack after each operation is complete.
 * So, entering “1” means – add car number 1 to the driveway, entering “-2” means - retrieve
 * car number 2 from the driveway.
 */
public class CA3_Question1 {
    public static void runSimulation() {

        //variables
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        Scanner kb = new Scanner(System.in);
        int input;
        int car;

        //loop the simulation until the user enters 0
        do {
            //prompt the user to enter a number in the loop so that it can be stopped
            while (true) {
                try {
                    System.out.println("Enter a number to add a car to the driveway, enter a negative number to remove a car from the driveway, enter 0 to stop the simulation");
                    input = kb.nextInt();
                    break;
                } catch (Exception e) {
                    //if the user enters a non-integer, print "Invalid input"
                    System.out.println("Invalid input");
                    //clear the scanner
                    kb.nextLine();
                }
            }
            //if the input is a positive integer, add it to the driveway
            if (input > 0) {
                driveway.push(input);
                System.out.println("Driveway: " + driveway);
            }
            //if the input is a negative integer, remove it from the driveway
            //print the street and driveway after each operation to show hoe the stacks are functioning
            else if (input < 0) {
                //the car variable is the input multiplied by -1 to make it positive since the negative integer is that cars value but the minus means to remove that instance of car
                car = input * -1;
                if (driveway.contains(car)) {
                    //if the input is in the driveway but not at the top of the stack, move the cars blocking it to the street
                    while (driveway.peek() != car) {
                        street.push(driveway.pop());
                        System.out.println("Driveway: " + driveway);
                        System.out.println("Street: " + street);
                    }
                    //then remove the car from the driveway
                    driveway.pop();
                    //then move the cars from the street back to the driveway
                    while (!street.isEmpty()) {
                        driveway.push(street.pop());
                        System.out.println("Driveway: " + driveway);
                        System.out.println("Street: " + street);

                    }
                } else {
                    //if the input is not in the driveway, print "Car not found"
                    System.out.println("Car not found");
                }

            }
        } while (input != 0);
        //when the user enters 0, print "Simulation stopped"
        System.out.println("Simulation stopped");
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
