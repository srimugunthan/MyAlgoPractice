package com.dstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    static long count(int S[], int m, int n, int chosen[]){
        // If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0) {
            System.out.println(chosen)
            return 1;
        }

        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n is greater than 0, then no solution exist
        if (m <=0 && n >= 1)
            return 0;

        int with[] = chosen;

        int[] without = IntStream.range(0, m )
                .mapToObj(i -> chosen[i])
                .toArray(int[]::new);

        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return count( S, m - 1, n, with ) + count( S, m, n-S[m-1], without);


    }


    // Driver Function to test above function
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        int chosen[] = new int [arr.length]
        System.out.println(count(arr, m, n,chosen));
    }

}
