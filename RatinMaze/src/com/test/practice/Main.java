package com.test.practice;

public class Main {

    //Debug: https://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
    final int N = 4;
    boolean solveMazehelper(int maze[][], int x, int y,
                          int sol[][]){
        if(x == N-1 && y == N-1){
            if(maze[x][y] == 1)
                return true;
        }
        else if(x > N-1 || y > N-1) {
            return false;
        }
        else{
            /* go right*/
            sol[x][y] =1;


            if(solveMazehelper(maze, x+1, y, sol) == false)
            {
                /* try down*/


                if(solveMazehelper(maze, x, y+1, sol) == false){

                    sol[x][y] =0;
                    return false;
                 }

            }
        }
        return false;
    }

    void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] +
                        " ");
            System.out.println();
        }
    }

    void solveMaze(int maze[][]){

        int curposx = 0;
        int curposy= 0;

        int sol[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        if(solveMazehelper(maze, curposx, curposy, sol) == true){
            System.out.println("solution is:");
            printSolution(sol);
        }else
        {
            System.out.println("no sol");
        }


    }

    public static void main(String[] args) {
	// write your code here
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        Main test = new Main();
        test.solveMaze(maze);
    }
}
