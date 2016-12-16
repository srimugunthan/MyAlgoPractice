/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weightedjobsched;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * // source: http://www.geeksforgeeks.org/weighted-job-scheduling/
 */
public class WeightedJobSched {

    /**
     * @param args the command line arguments
     */
    // A job has start time, finish time and profit.
    static class Job {

        int start, finish, profit;

        Job(int x, int y, int z) {
            start = x;
            finish = y;
            profit = z;
        }
    };

    static int latestNonConflict(ArrayList<Job> arr, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (arr.get(j).finish <= arr.get(i - 1).start) {
                return j;
            }
        }
        return -1;
    }

    // A recursive function that returns the maximum possible
// profit from given array of jobs.  The array of jobs must
// be sorted according to finish time.
    static int findMaxProfitRec(ArrayList<Job> arr, int n) {
        // Base case
        if (n == 1) {
            return arr.get(n - 1).profit;
        }

        // Find profit when current job is inclueded
        int inclProf = arr.get(n - 1).profit;
        int i = latestNonConflict(arr, n);
        if (i != -1) {
            inclProf += findMaxProfitRec(arr, i + 1);
        }

        // Find profit when current job is excluded
        int exclProf = findMaxProfitRec(arr, n - 1);

        return Math.max(inclProf, exclProf);
    }

    static int findMaxProfit(ArrayList<Job> arr, int n) {
        // Sort jobs according to finish time
        Collections.sort(arr, (Job s1, Job s2) -> Integer.signum(s1.finish - s2.finish));

        return findMaxProfitRec(arr, n);
    }

    // The main function that returns the maximum possible
// profit from given array of jobs
    static int findMaxProfitMemo(ArrayList<Job> arr, int n) {
        // Sort jobs according to finish time
        Collections.sort(arr, (Job s1, Job s2) -> Integer.signum(s1.finish - s2.finish));

    // Create an array to store solutions of subproblems.  table[i]
        // stores the profit for jobs till arr[i] (including arr[i])
        int[] table = new int[n];
        table[0] = arr.get(0).profit;

        // Fill entries in M[] using recursive property
        for (int i = 1; i < n; i++) {
            // Find profit including the current job
            int inclProf = arr.get(i).profit;
            int l = latestNonConflict(arr, i);
            if (l != -1) {
                inclProf += table[l];
            }

            // Store maximum of including and excluding
            table[i] = Math.max(inclProf, table[i - 1]);
        }

        // Store result and free dynamic memory allocated for table[]
        int result = table[n - 1];

        return result;
    }

    public static void main(String[] args) {

        ArrayList<Job> arr = new ArrayList<Job>(4);
        arr.add(new Job(3, 10, 20));
        arr.add(new Job(1, 2, 50));
        arr.add(new Job(6, 19, 100));
        arr.add(new Job(2, 100, 200));

        int n = arr.size();

        System.out.println("The optimal profit is " + findMaxProfitMemo(arr, n));

    }

}
