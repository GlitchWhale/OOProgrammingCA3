import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Name: Bianca Valicec
 * Class Group: SD2B
 * Question 3 – Java Identifier Count (Map)
 * Write a program that reads a Java source file and produces an index of all identifiers in the
 * file. (Identifiers are variable names, class names and keywords etc.) For each identifier, print
 * all lines - with the line number - in which it occurs. For simplicity, we will consider each string
 * consisting only of letters, numbers, and underscores an identifier. Declare a Scanner in for
 * reading from the source file and call in.useDelimiter("[^A-Za-z0-9_]+"). Then each call to
 * next returns an identifier.
 */

public class CA3_Question3 {
    public static void readFile(String fileName) throws FileNotFoundException {
        //create a map to store the identifiers and the line numbers they occur on
        Map<String, Set<Integer>> index = new HashMap<>();
        //variables
        Scanner in = new Scanner(new File(fileName));
        int lineNumber = 1;
        String input;
            //loop through the file
            while (in.hasNextLine()) {
                //read the line
                input = in.nextLine();
                //create a scanner to read the line
                Scanner line = new Scanner(input);
                //set the delimiter to read only letters, numbers and underscores
                line.useDelimiter("[^A-Za-z0-9_]+");
                //loop through the line
                while (line.hasNext()) {
                    //store the token
                    String token = line.next();
                    //if the token is not in the map, add it to the map
                    if (!index.containsKey(token)) {
                        index.put(token, new HashSet<>());
                    }
                    //add the line number to the set
                    index.get(token).add(lineNumber);
                }
                //increment the line number
                lineNumber++;
            }
            //print the map
            for (String key : index.keySet()) {
                System.out.println(key + " " + index.get(key));
            }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
