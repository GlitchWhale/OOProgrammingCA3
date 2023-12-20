import java.util.*;

/**
 * Name: Bianca Valicec
 * Class Group: SD2B
 * Question 7 – Multi-Company Stock Shares Tax Calculation (Queue)
 * Extend Question 6 to a program that can handle shares of multiple companies. The user
 * enters commands buy symbol quantity price and sell symbol quantity. Hint: Keep a
 * Map<String, Queue<Block>> that manages a separate queue for each stock symbol
 */
public class CA3_Question7 {
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {

        Map<String, Queue<Block>> Shares = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String command = "";
        do {
            System.out.print("Command >");
            command = in.next();
            if (command.equalsIgnoreCase("buy")) {
                int quantity;
                double price;
                System.out.print("Company >");
                String company = in.next();
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
                // Code to buy shares here
                //if the company is not in the map, add it
                Shares.putIfAbsent(company, new LinkedList<>());
                //add the block to the queue
                Shares.get(company).add(new Block(quantity, price));
                System.out.println(quantity + " shares bought at $" + price + " for " + company);
            } else if (command.equals("sell")) {
                int quantity;
                double price;
                System.out.print("Company >");
                String company = in.next();
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
                // Code to sell shares and calculate profit here
                if (Shares.containsKey(company)) {
                    Queue<Block> blocks = Shares.get(company);
                    int qtyLeft = quantity;
                    double profit = 0;
                    //loop until the quantity of shares to sell is 0 or there are no more blocks
                    while (qtyLeft > 0 && !blocks.isEmpty()) {
                        //get the first block
                        Block block = blocks.peek();
                        //if the quantity of shares in the first block is less than or equal to the quantity of shares to sell, remove the block and add the profit to the total profit
                        if (block.getQuantity() <= qtyLeft) {
                            qtyLeft -= block.getQuantity();
                            profit += block.getQuantity() * (price - block.getPrice());
                            blocks.remove();
                        }
                        //if the quantity of shares in the first block is greater than the quantity of shares to sell, subtract the quantity of shares to sell from the block and add the profit to the total profit
                        else {
                            block.setQuantity(block.getQuantity() - qtyLeft);
                            profit += qtyLeft * (price - block.getPrice());
                            qtyLeft = 0;
                        }
                    }
                    System.out.println(quantity + " shares sold at $" + price + " for " + company);
                    System.out.println("Profit: $" + profit);
                } else {
                    System.out.println("No shares for " + company);
                }
            }
        } while (!command.equalsIgnoreCase("quit"));
    }
}
