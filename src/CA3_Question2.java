import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Bianca Valicec
 * Class Group: SD2B
 * Question 2 - Flood Fill (Stack)
 * In a paint program, a “flood fill” fills all empty pixels of a drawing with a given colour,
 * stopping when it reaches occupied pixels. In this exercise, you will implement a simple
 * variation of this algorithm, flood-filling a 10 × 10 array of integers that are initially 0.
 * Prompt for the starting row and column (the starting cell for the flood fill).
 *    • Push the (row, column) pair onto a stack. You will need to provide a simple Pair class
 *      (storing row and column).
 *    • Repeat the following operations until the stack is empty.
 *      o Pop off the (row, column) pair from the top of the stack.
 *      o If it has not yet been filled, fill the corresponding cell location with a number
 *        1, 2, 3, and so on (this number is incremented at each step to show the order
 *        in which the square is filled).
 *      o Push the coordinates of any unfilled neighbours in the north, east, south, or
 *        west direction on the stack.
 *        • When you are done (i..e stack is empty), print the entire 2D array.
 */
public class CA3_Question2 {
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][] floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                arr[x][y] = 0;
            }
        }
        return arr;
    }

    /*
        Helper function to display the image
     */
    public static void display(int[][] arr) {
        System.out.println("\n");
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    private static void fill(int r, int c, int[][] pixels, Stack<Pair> coordinates) {

        int count = 1;
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
        }
    }

    public static void start() {
        int[][] pixels = floodFillStart();
        Stack<Pair> coordinates = new Stack<>();
        Scanner kb = new Scanner(System.in);
        int row;
        int column;
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

            //call the fill function
            fill(row, column, pixels, coordinates);
            //print the array if the stack is empty
            if (coordinates.isEmpty()) {
                display(pixels);
            }

            //prompt the user to enter 0 to stop the program or 1 to continue
            System.out.println("\nEnter 0 to stop the program or 1 to continue");
            choice = kb.nextInt();
            //clear the stack
            coordinates.clear();
            //reset the array
            pixels = floodFillStart();
        }
    }

    public static void main(String[] args) {
        start();
    }

}
