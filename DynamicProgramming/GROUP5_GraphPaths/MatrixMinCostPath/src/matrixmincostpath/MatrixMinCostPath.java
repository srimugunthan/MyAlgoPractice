/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmincostpath;

/**
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class MatrixMinCostPath {

    static int R = 3;
    static int C = 3;

    /* A utility function that returns minimum of 3 integers */
    static int min(int x, int y, int z) {
        if (x < y) {
            return (x < z) ? x : z;
        } else {
            return (y < z) ? y : z;
        }
    }
    /* Returns cost of minimum cost path from (0,0) to (m, n) in mat[R][C]*/

    static int minCost(int cost[][], int m, int n) {
        if (n < 0 || m < 0) {
            return Integer.MAX_VALUE;
        } else if (m == 0 && n == 0) {
            return cost[m][n];
        } else {
            return cost[m][n] + min(minCost(cost, m - 1, n - 1),
                    minCost(cost, m - 1, n),
                    minCost(cost, m, n - 1));
        }
    }

    
      static int minCostMemo(int cost[][], int m, int n)
    {
        int i, j;
        int tc[][]=new int[m+1][n+1];
 
        tc[0][0] = cost[0][0];
 
        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];
 
        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];
 
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i-1][j-1], 
                               tc[i-1][j],
                               tc[i][j-1]) + cost[i][j];
 
        return tc[m][n];
    }
     
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int cost[][] = {{1, 2, 3},
        {4, 8, 2},
        {1, 5, 3}};

        System.out.println(minCost(cost, 2, 2));
    }

}
