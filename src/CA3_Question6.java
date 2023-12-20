import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Name: Bianca Valicec
 * Class Group: SD2B
 * Question 6 – Stock Shares Tax Calculation (Queue)
 * Suppose you buy 100 shares of a stock at $12 per share, then another 100 at $10 per share,
 * and then sell 150 shares at $15. You have to pay taxes on the gain, but exactly what is the
 * gain? In the United States, the FIFO rule holds: You first sell all shares of the first batch for a
 * profit of $300, then 50 of the shares from the second batch, for a profit of $250, yielding a
 * total profit of $550. Write a program that can make these calculations for arbitrary
 * purchases and sales of shares in a single company. The user enters commands
 * buy quantity price, and sell quantity (which causes the gain to be displayed), and quit. Hint:
 * Keep a queue of objects of a class Block that contains the quantity and price of a block of
 * shares.
 */
public class CA3_Question6 {

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {

        Queue<Block> Shares = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        String command = "";
        do {
            System.out.print("Command >");
            command = in.next();
            if (command.equalsIgnoreCase("buy")) {
                int quantity;
                double price;
                System.out.print("Quantity >");
                while (true) {
                    try {
                        quantity = in.nextInt();
                        if (quantity > 0) {
                            break;
                        } else {
                            System.out.println("Invalid quantity");
                        }
                    } catch (Exception e) {
                        //if the user enters a non-integer, print "Invalid input"
                        System.out.println("Invalid input");
                        //clear the scanner
                        in.nextLine();
                    }
                }
                System.out.print("Price >");
                while (true) {
                    try {
                        price = in.nextDouble();
                        if (price > 0) {
                            break;
                        } else {
                            System.out.println("Invalid price");
                        }
                    } catch (Exception e) {
                        //if the user enters a non-integer, print "Invalid input"
                        System.out.println("Invalid input");
                        //clear the scanner
                        in.nextLine();
                    }
                }
                Shares.add(new Block(quantity, price));
                System.out.println(quantity + " shares bought at $" + price);

            } else if (command.equals("sell")) {
                int quantity;
                double price, gain = 0;
                if (Shares.isEmpty()) {
                    System.out.println("No shares to sell");
                } else {
                    System.out.print("Quantity >");
                    while (true) {
                        try {
                            quantity = in.nextInt();
                            if (quantity > 0) {
                                break;
                            } else {
                                System.out.println("Invalid quantity");
                            }
                        } catch (Exception e) {
                            //if the user enters a non-integer, print "Invalid input"
                            System.out.println("Invalid input");
                            //clear the scanner
                            in.nextLine();
                        }
                    }
                    System.out.print("Price >");
                    while (true) {
                        try {
                            price = in.nextDouble();
                            if (price > 0) {
                                break;
                            } else {
                                System.out.println("Invalid price");
                            }
                        } catch (Exception e) {
                            //if the user enters a non-integer, print "Invalid input"
                            System.out.println("Invalid input");
                            //clear the scanner
                            in.nextLine();
                        }
                    }
                    //loop until the quantity is 0
                    while (quantity != 0) {
                        //if the quantity is greater than the quantity of the first block, calculate the gain and remove the block
                        if (quantity > Shares.peek().getQuantity()) {
                            gain += (Shares.peek().getQuantity() * price) - (Shares.peek().getQuantity() * Shares.peek().getPrice());
                            quantity -= Shares.peek().getQuantity();
                            Shares.remove();
                        }
                        //if the quantity is less than the quantity of the first block, calculate the gain and subtract the quantity from the block
                        else if (quantity < Shares.peek().getQuantity()) {
                            gain += (quantity * price) - (quantity * Shares.peek().getPrice());
                            Shares.peek().setQuantity(Shares.peek().getQuantity() - quantity);
                            quantity = 0;
                        }
                        //if the quantity is equal to the quantity of the first block, calculate the gain and remove the block
                        else {
                            gain += (quantity * price) - (quantity * Shares.peek().getPrice());
                            quantity = 0;
                            Shares.remove();
                        }
                    }
                    //print the gain
                    System.out.println("Gain: $" + gain);
                }
            }
        }
        while (!command.equalsIgnoreCase("quit"));
    }
}