import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Name: Bianca Valicec
 * Class Group: SD2B
 * Question 4 – Nested HTML Tags (Stack)
 * Write a program that checks whether a sequence of HTML tags is properly nested. For each
 * opening tag, such as <p>, there must be a closing tag </p>. A tag such as <p> may have
 * other tags inside, for example :
 * <p> <ul> <li> </li> </u> <a> </p>
 * The inner tags must be closed before the outer ones. Your program should process a file
 * containing tags. For simplicity, assume that the tags are separated by spaces, and that there is
 * no text inside the tags.
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException {
        Stack<String> tags = new Stack<>();
        String input;
        File file = new File(filename);
        //read the file

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
                        return false;
                    }
                    //if the stack is not empty, check if the closing tag matches the top of the stack
                    else {
                        //if the closing tag matches the top of the stack, pop the top of the stack
                        if (token.equals("</" + tags.peek().substring(1))) {
                            tags.pop();
                        }
                        //if the closing tag does not match the top of the stack, the tags are not balanced
                        else {
                            return false;
                        }
                    }
                }
            }
        }
        return tags.isEmpty();
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        //added more test files with different types of invalid tags
        String[] files = {"valid_tags.txt", "invalid_tags1.txt", "invalid_tags2.txt", "invalid_tags3.txt"};
        for (String fName : files) {
            System.out.print(fName + ": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}
