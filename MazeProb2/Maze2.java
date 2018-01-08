import java.util.*;
import java.lang.*;

public class MazeProblem {


    private static class Coord {
        private int x;
        private int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }


    private static ArrayList<Coord> pathList = new ArrayList<Coord>();

    private static boolean recurseMaze(int maze[][], Coord curCordinate, boolean backtracking, int backtrackPath) {
        int curX = curCordinate.getX();
        int curY = curCordinate.getY();

        int numRows = maze.length;
        int numCols = maze[0].length;

        System.out.println("curX =" + curX + "  curY =" + curY + "numR =" + numRows + " numCols =" + numCols + "btrac=" + backtrackPath);

        if (curX >= (numRows - 1) && curY >= (numCols - 1)) {
            pathList.add(new Coord(curX, curY));
            return true;
        }
        if (backtracking == true && backtrackPath == 2 && curX == 0 && curY == 0) {
            return false;
        }

        if (curX + 1 < numRows && maze[curX + 1][curY] == 1) {

            if ((backtracking == false) || backtracking == true && backtrackPath <= 0) {
                System.out.println("    Trypath : curX =" + (curX + 1) + "  curY =" + curY);
                curX = curX + 1;
                pathList.add(curCordinate);
                return recurseMaze(maze, new Coord(curX, curY), false, 1);
            }


        }
        if (curY + 1 < numCols && maze[curX][curY + 1] == 1) {

            if ((backtracking == false) || backtracking == true && backtrackPath <= 1) {
                System.out.println("    Trypath2 : curX =" + (curX) + "  curY =" + (curY + 1));
                curY = curY + 1;
                pathList.add(curCordinate);
                return recurseMaze(maze, new Coord(curX, curY), false, 2);
            }

        }


                /* backtrack */
        if (pathList.size() > 0) {
            pathList.remove(pathList.size() - 1);
        }

        Coord backtrackCoord = (pathList.get(pathList.size() - 1));
        System.out.println("    Backtrack : curX =" + (backtrackCoord.getX()) + "  curY =" + (backtrackCoord.getY()));
        return recurseMaze(maze, backtrackCoord, true, backtrackPath);


    }


    private static boolean solveMaze(int maze[][]) {

        pathList.add(new Coord(0, 0));
        boolean result = recurseMaze(maze, new Coord(0, 0), false, 0);


        for (Coord xy : pathList) {
            System.out.println(xy.getX() + "    " + xy.getY());
        }

        if (result) {
            System.out.println("Path computed success");
            return true;
        } else {
            System.out.println("Path compute FAIL");
            return false;
        }


    }


    public static void main(String args[]) {
        int maze[][] = {
                {
                        1, 0, 0, 0
                },
                {
                        1, 1, 0, 1
                },
                {
                        1, 0, 0, 0
                },
                {
                        1, 1, 1, 1
                }

        };

        solveMaze(maze);
    }
}