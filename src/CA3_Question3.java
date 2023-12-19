import java.io.FileNotFoundException;
/**
 *  Name: Bianca Valicec
 *  Class Group: SD2B
 *  Question 3 – Java Identifier Count (Map)
 *  Write a program that reads a Java source file and produces an index of all identifiers in the
 *  file. (Identifiers are variable names, class names and keywords etc.) For each identifier, print
 *  all lines - with the line number - in which it occurs. For simplicity, we will consider each string
 *  consisting only of letters, numbers, and underscores an identifier. Declare a Scanner in for
 *  reading from the source file and call in.useDelimiter("[^A-Za-z0-9_]+"). Then each call to
 *  next returns an identifier.
 */

public class CA3_Question3
{
    public static void readFile(String fileName)
    {

    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
