import java.util.*;
/**
 *  Name: Bianca Valicec
 *  Class Group: SD2B
 *  Question 7 – Multi-Company Stock Shares Tax Calculation (Queue)
 *  Extend Question 6 to a program that can handle shares of multiple companies. The user
 *  enters commands buy symbol quantity price and sell symbol quantity. Hint: Keep a
 *  Map<String, Queue<Block>> that manages a separate queue for each stock symbol
 */
public class CA3_Question7
{
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String command="";
        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to buy shares here
            }
            else if(command.equals("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to sell shares and calculate profit here
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}
