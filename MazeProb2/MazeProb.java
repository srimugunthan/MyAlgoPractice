/*

                                                                                                                       
    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    @@           @@;;;;;;;;;;;;@@;;;;;;;;;;;;;;@@;;;;;;;;;;;@ 
    @@           @@;;;;;;;;;;;;@@;;;;;;;;;;;;;;@@;;;;;;;;;;;@ 
    @@           @@;;;;;;;;;;;;@@;;;;;;;;;;;;;;@@;;;;;;;;;;;@ 
    @@           @@;;;;;;;;;;;;@@;;;;;;;;;;;;;;@@;;;;;;;;;;;@      
    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    @@           @@            @@;;;;;;;;;;;;;;@@           @
    @@           @@            @@;;;;;;;;;;;;;;@@           @
    @@           @@            @@;;;;;;;;;;;;;;@@           @
    @@           @@            @@;;;;;;;;;;;;;;@@           @
    @@           @@            @@;;;;;;;;;;;;;;@@           @
    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    @@;;;;;;;;;;;@@            @@;;;;;;;;;;;;;;@@;;;;;;;;;;;@
    @@;;;;;;;;;;;@@            @@;;;;;;;;;;;;;;@@;;;;;;;;;;;@
    @@;;;;;;;;;;;@@            @@;;;;;;;;;;;;;;@@;;;;;;;;;;;@
    @@;;;;;;;;;;;@@            @@;;;;;;;;;;;;;;@@;;;;;;;;;;;@
    @@;;;;;;;;;;;@@            @@;;;;;;;;;;;;;;@@;;;;;;;;;;;@
    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    @@           @@            @@              @@           @
    @@           @@            @@              @@           @
    @@           @@            @@              @@           @
    @@           @@            @@              @@           @
    @@           @@            @@              @@           @
    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

*/

 
class MazeProb{

	// Maze size 4x4
	private static final int N = 4;
 
	//bool solveMazeUtil(int maze[N][N], int x, int y, int sol[N][N]);
 
	/* A utility function to print solution matrix sol[N][N] */
        public static void printSolution(int[][] sol)
	{
		for (int i = 0; i < N; i++)
		{
		        for (int j = 0; j < N; j++)
	                      System.out.print(" "+ sol[i][j] +" ");
			System.out.println();
		}
	}
 
	/* A utility function to check if x,y is valid index for N*N maze */
	public static boolean isValid(int[][] maze, int x, int y)
	{
	    // if (x,y outside maze) return false
	    if(x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1)
        	return true;
 
	    return false;
	}
 
	/* This function solves the Maze problem using Backtracking. 
	 It mainly uses solveMazeUtil() to solve the problem. It returns
	 false if no path is possible, otherwise return true and prints
	 the path in the form of 1s. Please note that there may be more
	 than one solutions, this function prints one of the feasible
	 solutions.
	*/
        public static boolean solveMaze(int[][] maze)
	{
	    int sol[][] = { {0, 0, 0, 0},
        	{0, 0, 0, 0},
        	{0, 0, 0, 0},
        	{0, 0, 0, 0}
    	    };
 
	    if(solveMazeUtil(maze, 0, 0, sol) == false)
	    {
        	System.out.print("Solution doesn't exist");
        	return false;
	    }
 
	    printSolution(sol);
	    return true;
	}
 
	/* A recursive utility function to solve Maze problem */
        public static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol)
	{
	    // if (x,y is goal) return true
	    if(x == N-1 && y == N-1)
	    {
	        sol[x][y] = 1;
	        return true;
	    }
 
	    // Check if maze[x][y] is valid
	    if(isValid(maze, x, y) == true)
	    {
	        // mark x,y as part of solution path
        	sol[x][y] = 1;
 	
        	/* Move forward in x direction */
        	if (solveMazeUtil(maze, x+1, y, sol) == true)
        	    return true;
 	        /* If moving in x direction doesn't give solution then
 	          Move down in y direction  */
 	       if (solveMazeUtil(maze, x, y+1, sol) == true)
 	           return true;
 
 	       /* If none of the above movements work then BACKTRACK: 
 	           unmark x,y as part of solution path */
 	       sol[x][y] = 0;
 	       return false;
 	   }   
 
 	   return false;
	}		
 


	// driver program to test above function
	public static void main(String args[]) {
	
	    int maze[][]  =  { {1, 0, 0, 0},
        	{1, 1, 0, 1},
        	{0, 1, 0, 0},
        	{1, 1, 1, 1}
	    };
 
	    solveMaze(maze);

	}
}
