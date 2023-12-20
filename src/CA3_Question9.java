import java.util.Stack;

/**
 * Name: Bianca Valicec
 * Class Group: SD2B
 * Question 9 – Backtracking through a Maze (Stack)
 * Implement a backtracking algorithm, using a Stack, to find a path through a maze from start to exit.
 * Refer to description of algorithm (from textbook) in the accompanying PDF.
 */

/*
Direction enum used to indicate direction.
 */
enum DIRECTION {NORTH, SOUTH, EAST, WEST};

//class path{
//    private int[] position;
//    private DIRECTION;
//
//    public path(int[] position, DIRECTION direction){
//        this.position = position;
//        this.direction = direction;
//    }
//
//    public int[] getPosition(){
//        return position;
//    }
//
//    public DIRECTION getDirection(){
//        return direction;
//    }
//
//    public void setPosition(int[] position){
//        this.position = position;
//    }
//
//    public void setDirection(DIRECTION direction){
//        this.direction = direction;
//    }
//}

public class CA3_Question9 {
    public static void display(int[][] image) {
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }

    public void solve(int x, int y, DIRECTION dir) {
        //create the 8x8 maze from the pdf
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };

        //create a stack to store the path
        Stack<int[]> possiblePaths = new Stack<>();
        //push the starting position to the stack
        possiblePaths.push(new int[]{3, 4});

    }
}
