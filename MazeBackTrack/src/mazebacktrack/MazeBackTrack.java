/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazebacktrack;

/**
 *
 * @author sdhandap
 */
public class MazeBackTrack {

   

    public static boolean moveForward(int[][] maze, Coords curCoord) {
        int x = curCoord.x;
        int y = curCoord.y;
        if (maze[x][y + 1] == 1) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean moveRight(int[][] maze, Coords curCoord) {
        int x = curCoord.x;
        int y = curCoord.y;
        if (maze[x + 1][y] == 1) {
            return true;
        } else {
            return false;
        }

    }

    public static int findPath(int[][] maze, Coords curCoordinate) {

        int mazeXlen = maze[0].length;
        int mazeYlen = maze.length;

        if (curCoordinate.equals(0, 0)
                && !moveForward(maze, curCoordinate)
                && !moveRight(maze, curCoordinate)) {
            return -1;
        }

        if (curCoordinate.equals(mazeXlen - 1, mazeYlen - 1)) {
            System.out.println("Success");

            return 0;
        }

        if (moveForward(maze, curCoordinate)) {
            int isPath = findPath(maze, new Coords(curCoordinate.x, curCoordinate.y + 1));
            if (isPath == 0) {
                return 0;
            }

        }

        if (moveRight(maze, curCoordinate)) {
            int isPath = findPath(maze, new Coords(curCoordinate.x + 1, curCoordinate.y));
            if (isPath == 0) {
                return 0;
            }

        }
        maze[curCoordinate.x][curCoordinate.y] = 0;
        return -1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int maze[][] = {{1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 0, 0, 0},
        {1, 1, 1, 1}
        };

        Coords startCoord = new Coords(0, 0);
        int isThereAPath = findPath(maze, startCoord);
        System.out.println("Answer:"+isThereAPath);
    }

}
