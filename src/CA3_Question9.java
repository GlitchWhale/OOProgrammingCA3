/**
 *  Name: Bianca Valicec
 *  Class Group: SD2B
 *  Question 9 – Backtracking through a Maze (Stack)
 *  Implement a backtracking algorithm, using a Stack, to find a path through a maze from start to exit.
 *  Refer to description of algorithm (from textbook) in the accompanying PDF.
 */

/*
Direction enum used to indicate direction.
 */
enum DIRECTION {NORTH, SOUTH,EAST,WEST};

public class CA3_Question9
{
    public static void display(int[][] image)
    {
        for (int x = 0; x < image.length; x++)
        {
            for (int y = 0; y < image[0].length; y++)
            {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }
    public void solve(int x, int y, DIRECTION dir)
    {

    }
}
