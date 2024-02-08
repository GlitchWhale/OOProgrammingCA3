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

class path {
    private int[] position;
    private DIRECTION direction;

    public path(int[] position, DIRECTION direction) {
        this.position = position;
        this.direction = direction;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    public String toString() {
        return "Position: " + position[0] + ", " + position[1] + " Direction: " + direction;
    }
}

public class CA3_Question9 {

    //function for checking if the current position is an exit
    public static boolean isExit(int[] position, int mazeSize) {
        return (position[0] == 0 || position[0] == mazeSize - 1 || position[1] == 0 || position[1] == mazeSize - 1);
    }

    //function for displaying the maze
    public static void display(int[][] image) {
        //print border between displays
        System.out.println("-------------------------------------------------");
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve(3, 4, DIRECTION.WEST);
    }

    public static void solve(int x, int y, DIRECTION dir) {
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
        Stack<path> possiblePaths = new Stack<>();
        //push the starting position and direction to the stack, and add any other possible paths from this point to the stack not in the same direction
        possiblePaths.push(new path(new int[]{x, y}, dir));
        //check if there are other paths from the starting position without the same direction added to the stack
        if (maze[x][y - 1] == 0 && dir != DIRECTION.WEST) {
            possiblePaths.push(new path(new int[]{x, y - 1}, DIRECTION.WEST));
        }
        if (maze[x][y + 1] == 0 && dir != DIRECTION.EAST) {
            possiblePaths.push(new path(new int[]{x, y + 1}, DIRECTION.EAST));
        }
        if (maze[x - 1][y] == 0 && dir != DIRECTION.NORTH) {
            possiblePaths.push(new path(new int[]{x - 1, y}, DIRECTION.NORTH));
        }
        if (maze[x + 1][y] == 0 && dir != DIRECTION.SOUTH) {
            possiblePaths.push(new path(new int[]{x + 1, y}, DIRECTION.SOUTH));
        }

//while the stack is not empty
        while (!possiblePaths.isEmpty()) {
            //pop the top of the stack
            path currentPath = possiblePaths.pop();
            //get the position of the current path
            int[] currentPosition = currentPath.getPosition();
            //get the direction of the current path
            DIRECTION currentDirection = currentPath.getDirection();
            //follow the current position and direction to a dead end or exit
            do {
                //change current position to 8 to indicate that the path has been followed
                maze[currentPosition[0]][currentPosition[1]] = 8;
                //display the maze
                display(maze);
                if (currentDirection == DIRECTION.NORTH || currentDirection == DIRECTION.SOUTH) {
                    System.out.println("Current position: " + currentPosition[0] + ", " + currentPosition[1] + " Direction: " + currentDirection);
                    System.out.println(possiblePaths.toString());
                    //if the west and east directions are walls continue moving
                    if (maze[currentPosition[0]][currentPosition[1] - 1] == 1 && maze[currentPosition[0]][currentPosition[1] + 1] == 1) {
                        //if the north or south hits a wall, break the loop
                        if (maze[currentPosition[0] - 1][currentPosition[1]] == 1 || maze[currentPosition[0] + 1][currentPosition[1]] == 1) {
                            break;
                        }
                        //else move in the current direction
                        else {
                            if (currentDirection == DIRECTION.NORTH) {
                                currentPosition[0]--;
                            } else {
                                currentPosition[0]++;
                            }
                        }
                    }

                    //if the east or west is a path add it to the stack and break the loop
                    else if (maze[currentPosition[0]][currentPosition[1] - 1] == 0) {
                        possiblePaths.push(new path(new int[]{currentPosition[0], currentPosition[1] - 1}, DIRECTION.WEST));
                        break;
                    } else if (maze[currentPosition[0]][currentPosition[1] + 1] == 0) {
                        possiblePaths.push(new path(new int[]{currentPosition[0], currentPosition[1] + 1}, DIRECTION.EAST));
                        break;
                    }

                    //else keep moving in the current direction
                    else {
                        if (currentDirection == DIRECTION.NORTH) {
                            currentPosition[0]--;
                        } else {
                            currentPosition[0]++;
                        }
                    }

                } else if (currentDirection == DIRECTION.EAST || currentDirection == DIRECTION.WEST) {
                    //if the north and south directions are walls continue moving
                    if (maze[currentPosition[0] - 1][currentPosition[1]] == 1 && maze[currentPosition[0] + 1][currentPosition[1]] == 1) {
                        //if the east direction is a wall, break the loop
                        if (maze[currentPosition[0]][currentPosition[1] + 1] == 1|| maze[currentPosition[0]][currentPosition[1] - 1] == 1) {
                            break;
                        }
                        //else move in the current direction
                        else {
                            if (currentDirection == DIRECTION.EAST) {
                                currentPosition[1]++;
                            } else {
                                currentPosition[1]--;
                            }
                        }
                    }
                    //if the north or south is a path add it to the stack
                    else if (maze[currentPosition[0] - 1][currentPosition[1]] == 0) {
                        possiblePaths.push(new path(new int[]{currentPosition[0] - 1, currentPosition[1]}, DIRECTION.NORTH));
                        break;
                    } else if (maze[currentPosition[0] + 1][currentPosition[1]] == 0) {
                        possiblePaths.push(new path(new int[]{currentPosition[0] + 1, currentPosition[1]}, DIRECTION.SOUTH));
                        break;
                    } else {
                        if (currentDirection == DIRECTION.EAST) {
                            currentPosition[1]++;
                        } else {
                            currentPosition[1]--;
                        }
                    }

                }
            } while (!isExit(currentPosition, maze.length));
            if (isExit(currentPosition, maze.length)) {
                System.out.println("Exit found at " + currentPosition[0] + ", " + currentPosition[1]);
                return;
            }
        }
    }
}