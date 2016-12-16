/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinchange;

import java.util.Arrays;

/**
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
public class CoinChange {

    // Returns the count of ways we can sum  S[0...m-1] coins to get sum n
    static int countWays(int S[], int m, int n) {
        // If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0) {
            return 1;
        }

        // If n is less than 0 then no solution exists
        if (n < 0) {
            return 0;
        }

        // If there are no coins and n is greater than 0, then no solution exist
        if (m <= 0 && n >= 1) {
            return 0;
        }

        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return countWays(S, m - 1, n) + countWays(S, m, n - S[m - 1]);
    }

    static long countWaysMemo(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)
 
        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
 
        // Base case (If given value is 0)
        table[0] = 1;
 
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
 
        return table[n];
    }
    
    // Driver Function to test above function
    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        System.out.println(countWaysMemo(arr, m, n));
    }

}
