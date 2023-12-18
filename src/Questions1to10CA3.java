import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Questions1to10CA3 {
    public static void main(String[] args) {
//        question1();
//        question2();
//        question3();
//        question4();
        question5();
//        question6();
//        question7();
//        question8();
//        question9();
//        question10();
    }

    public static void question1() {
        //  Question 1 – Car Parking (Stack)
        //  A homeowner rents out parking spaces in a driveway during special events. The driveway is
        //  a “last-in, first-out” LIFO stack. Of course, when a car owner retrieves a vehicle that wasn’t
        //  the last one in, the cars blocking it must temporarily move to the street so that the
        //  requested vehicle can leave. Write a program that models this behaviour, using one stack for
        //  the driveway and one stack for the street. Use integer values as license plate numbers (e.g.
        //  1,2,3,4…). Positive numbers add a car (1,2,3…), negative numbers remove a car(-2,-1,…), zero
        //  stops the simulation. Print out the stack after each operation is complete.
        //  So, entering “1” means – add car number 1 to the driveway, entering “-2” means - retrieve
        //  car number 2 from the driveway.

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
                        System.out.println("Driveway: " + driveway);
                        System.out.println("Street: " + street);
                        driveway.push(street.pop());
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

    public static void question2() {
        //    Question 2 - Flood Fill (Stack)
//     In a paint program, a “flood fill” fills all empty pixels of a drawing with a given colour,
//      stopping when it reaches occupied pixels. In this exercise, you will implement a simple
//      variation of this algorithm, flood-filling a 10 × 10 array of integers that are initially 0.
//      Prompt for the starting row and column (the starting cell for the flood fill).
//          • Push the (row, column) pair onto a stack. You will need to provide a simple Pair class
//              (storing row and column).
//          • Repeat the following operations until the stack is empty.
//                  o Pop off the (row, column) pair from the top of the stack.
//                  o If it has not yet been filled, fill the corresponding cell location with a number
//                  1, 2, 3, and so on (this number is incremented at each step to show the order
//                  in which the square is filled).
//                  o Push the coordinates of any unfilled neighbours in the north, east, south, or
//                  west direction on the stack.
//          • When you are done (i..e stack is empty), print the entire 2D array.

        //variables
        int[][] pixels = new int[10][10];
        Stack<Pair> coordinates = new Stack<>();
        Scanner kb = new Scanner(System.in);
        int row;
        int column;
        int count = 1;
        int choice = 1;

        //loop until the user enters 0
        while (choice != 0) {
            //prompt the user to enter a row and column, catch any exceptions, and loop until the user enters a valid row and column that is in the array
            while (true) {
                try {
                    System.out.println("Enter a row");
                    row = kb.nextInt();
                    System.out.println("Enter a column");
                    column = kb.nextInt();
                    //check if the row and column are in the array
                    if (row >= 0 && row < pixels.length && column >= 0 && column < pixels[0].length) {
                        break;
                    }
                    //if the row and column are not in the array, print "Invalid input"
                    else {
                        System.out.println("Invalid input");
                    }
                } catch (Exception e) {
                    //if the user enters a non-integer, print "Invalid input"
                    System.out.println("Invalid input");
                    //clear the scanner
                    kb.nextLine();
                }

            }


            //push the row and column to the stack
            coordinates.push(new Pair(row, column));

            //loop until the stack is empty
            while (!coordinates.isEmpty()) {
                //display the stack before each pop and format it so that it is easier to read
                System.out.println("\nCoordinates: " + coordinates);
                //pop the top of the stack
                Pair pair = coordinates.pop();
                //if the cell is not filled, fill it
                if (pixels[pair.getRow()][pair.getColumn()] == 0) {
                    pixels[pair.getRow()][pair.getColumn()] = count;
                    count++;
                }
                //push the coordinates of any unfilled neighbours in the north, east, south, or west direction on the stack
                //check if the cell is in the array
                //check if the cell is not filled
                //if the cell is in the array and not filled, push it to the stack

                //check if the cell to the north is in the array and not filled
                if (pair.getRow() - 1 >= 0 && pixels[pair.getRow() - 1][pair.getColumn()] == 0) {
                    coordinates.push(new Pair(pair.getRow() - 1, pair.getColumn()));
                }
                //check if the cell to the east is in the array and not filled
                if (pair.getColumn() + 1 < pixels[0].length && pixels[pair.getRow()][pair.getColumn() + 1] == 0) {
                    coordinates.push(new Pair(pair.getRow(), pair.getColumn() + 1));
                }
                //check if the cell to the south is in the array and not filled
                if (pair.getRow() + 1 < pixels.length && pixels[pair.getRow() + 1][pair.getColumn()] == 0) {
                    coordinates.push(new Pair(pair.getRow() + 1, pair.getColumn()));
                }
                //check if the cell to the west is in the array and not filled
                if (pair.getColumn() - 1 >= 0 && pixels[pair.getRow()][pair.getColumn() - 1] == 0) {
                    coordinates.push(new Pair(pair.getRow(), pair.getColumn() - 1));
                }
                //print the array if the stack is empty
                if (coordinates.isEmpty()) {
                    System.out.println("\n");
                    for (int[] pixel : pixels) {
                        System.out.println();
                        for (int j = 0; j < pixels[0].length; j++) {
                            //format the array so that it is easier to read
                            System.out.printf("%4d", pixel[j]);
                        }
                    }
                }
            }
            //prompt the user to enter 0 to stop the program or 1 to continue
            System.out.println("\nEnter 0 to stop the program or 1 to continue");
            choice = kb.nextInt();
            //clear the stack
            coordinates.clear();
            //reset the count
            count = 1;
            //reset the array
            pixels = new int[10][10];
        }
    }

    public static void question3() {
//    Question 3 – Java Identifier Count (Map)
//     Write a program that reads a Java source file and produces an index of all identifiers in the
//      file. (Identifiers are variable names, class names and keywords etc.) For each identifier, print
//      all lines - with the line number - in which it occurs. For simplicity, we will consider each string
//      consisting only of letters, numbers, and underscores an identifier. Declare a Scanner in for
//      reading from the source file and call in.useDelimiter("[^A-Za-z0-9_]+"). Then each call to
//      next returns an identifier.
    }

    public static void question4() {
//  Question 4 – Nested HTML Tags (Stack)
//  Write a program that checks whether a sequence of HTML tags is properly nested. For each
//  opening tag, such as <p>, there must be a closing tag </p>. A tag such as <p> may have
//  other tags inside, for example :
//  <p> <ul> <li> </li> </u> <a> </p>
//  The inner tags must be closed before the outer ones. Your program should process a file
//  containing tags. For simplicity, assume that the tags are separated by spaces, and that there is
//  no text inside the tags.

        //variables
        Stack<String> tags = new Stack<>();
        String filename;
        String input;
        boolean balanced = true;
        String message = "";
        int choice = 1;

        //create loop to keep the program running until the user enters 0
        while (choice != 0) {
            //prompt the user to enter a filename
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter a filename");
            filename = kb.nextLine();

            //loop until the user enters a valid filename that exists
            while (!new File("src/" + filename + ".txt").exists()) {
                System.out.println("File not found, enter a valid filename");
                filename = kb.nextLine();
            }
            File file = new File("src/" + filename + ".txt");
            //read the file
            try {
                //create a scanner to read the file
                Scanner fileReader = new Scanner(file);
                //loop through the file
                while (fileReader.hasNextLine()) {
                    //read the line
                    input = fileReader.nextLine();
                    System.out.println(input);
                    //create a string tokenizer to read the line
                    StringTokenizer st = new StringTokenizer(input, " ");
                    //loop through the string tokenizer
                    while (st.hasMoreTokens()) {
                        //store the token
                        String token = st.nextToken();
                        //if the token is an opening tag, push it to the stack
                        if (token.charAt(0) == '<' && token.charAt(1) != '/' && token.charAt(token.length() - 1) == '>') {
                            tags.push(token);
                        }
                        //if the token is a closing tag, check if it matches the top of the stack
                        else if (token.charAt(0) == '<' && token.charAt(1) == '/' && token.charAt(token.length() - 1) == '>') {
                            //if the stack is empty, the tags are not balanced
                            if (tags.isEmpty()) {
                                balanced = false;
                            }
                            //if the stack is not empty, check if the closing tag matches the top of the stack
                            else {
                                //if the closing tag matches the top of the stack, pop the top of the stack
                                if (token.equals("</" + tags.peek().substring(1))) {
                                    tags.pop();
                                }
                                //if the closing tag does not match the top of the stack, the tags are not balanced
                                else {
                                    balanced = false;
                                }
                            }
                        }
                    }
                }
            }
            //if the file is not found, throw a runtime exception
            catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            //first check if the tags aren't balanced, then check if the stack is empty, otherwise the tags are not balanced
            if (!balanced) {
                message = "The tags are not balanced";
            } else if (tags.isEmpty()) {
                message = "The tags are balanced";
            } else {
                message = "The tags are not balanced";
            }
            System.out.println(message);
            //prompt the user to enter 0 to stop the program or 1 to continue
            System.out.println("\nEnter 0 to stop the program or 1 to continue");
            choice = kb.nextInt();
        }
    }

    public static void question5() {
        //  Question 5 – Airport Flights (Queue)
        //  An airport has only one runway. When it is busy, planes wishing to take off or land have to
        //  wait. Implement a simulation, using two queues, one each for the planes waiting to take off
        //  and land. Landing planes get priority. The user enters commands takeoff flightSymbol,
        //  land flightSymbol, next, and quit. The first two commands place the flight in the
        //  appropriate queue. The next command finishes the current take-off or landing and enables
        //  the next one, printing the action (takeoff or land) and the flight symbol.
        //  For example:
        //  takeoff( “Flight-100”); // is queued
        //  takeoff(“Flight-220”); // is queued
        //  land(“Flight-320”); // is queued
        //  next(); // will complete the takeoff/landing of the current flight and initiate landing of the next prioritized flight’ i.e. Flight-320

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
                        System.out.println(flight+" added to takeoff queue");
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
                        System.out.println(flight+" added to land queue");
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

    public static void question6() {
        //  Question 6 – Stock Shares Tax Calculation (Queue)
        //  Suppose you buy 100 shares of a stock at $12 per share, then another 100 at $10 per share,
        //  and then sell 150 shares at $15. You have to pay taxes on the gain, but exactly what is the
        //  gain? In the United States, the FIFO rule holds: You first sell all shares of the first batch for a
        //  profit of $300, then 50 of the shares from the second batch, for a profit of $250, yielding a
        //  total profit of $550. Write a program that can make these calculations for arbitrary
        //  purchases and sales of shares in a single company. The user enters commands
        //  buy quantity price, and sell quantity (which causes the gain to be displayed), and quit. Hint:
        //  Keep a queue of objects of a class Block that contains the quantity and price of a block of
        //  shares.
    }

    public static void question7() {
//  Question 7 – Multi-Company Stock Shares Tax Calculation (Queue)
//  Extend Question 6 to a program that can handle shares of multiple companies. The user
//  enters commands buy symbol quantity price and sell symbol quantity. Hint: Keep a
//  Map<String, Queue<Block>> that manages a separate queue for each stock symbol
    }

    public static void question8() {
        //  Question 8 Arithmetic Expression Calculator (Stack)
        //  Implement a calculator to evaluate arithmetic expressions for the operators + - * / and
        //  parenthesis ( ). See the accompanying PDF document which is an extract from a book
        //  explaining the algorithm
    }

    public static void question9() {
        //  Question 9 – Backtracking through a Maze (Stack)
        //  Implement a backtracking algorithm, using a Stack, to find a path through a maze from start to exit.
        //  Refer to description of algorithm (from textbook) in the accompanying PDF.
    }

    public static void question10() {
//  Question 10 – Shortest Distance to City (Map, TreeSet, PriorityQueue)
//  Consider the problem of finding the least expensive routes to all cities in a network from a given
//  starting point.
//  For example, in this network, the least expensive route from Pendleton to Peoria has cost 8
//  (going through Pierre and Pueblo). The following helper class expresses the distance to
//  another city:
//  public class DistanceTo implements Comparable {
//  private String target;
//  private int distance;
//  public DistanceTo(String city, int dist) {
//  target = city;
//  distance = dist; }
//  public String getTarget() { return target; }
//  public int getDistance() { return distance; }
//  public int compareTo(DistanceTo other) {
//  return distance - other.distance; } }
//  All direct connections between cities are stored in a Map<String,TreeSet<DistanceTo>>.
//  The algorithm now proceeds as follows:
//  Let from be the starting point.
//  Add DistanceTo(from, 0) to a priority queue.
//  Construct a map shortestKnownDistance from city names to distances.
//  While the priority queue is not empty
//  Get its smallest element.
//  If its target is not a key in shortestKnownDistance
//  Let d be the distance to that target.
//  Put (target, d) into shortestKnownDistance.
//  For all cities c that have a direct connection from target
//  Add DistanceTo(c, d + distance from target to c) to the priority queue.
//  When the algorithm has finished, shortestKnownDistance contains the shortest distance
//  from the starting point to all reachable targets. Your task is to write a program that
//  implements this algorithm. Your program should read in lines, from a file, of the form:
//  city1 city2 distance
//  The starting point is the first city in the first line. Print the shortest distances to all other cities.
    }
}
