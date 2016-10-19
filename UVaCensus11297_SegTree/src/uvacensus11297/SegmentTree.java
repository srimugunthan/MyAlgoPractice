/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvacensus11297;

import java.lang.Math;

/**
 *
 *
 */
public class SegmentTree {

    int st[]; // The array that stores segment tree nodes
    int sumst[];

    // A recursive function that constructs Segment Tree for array[ss..se].
// si is index of current node in segment tree st
    int constructSTUtil(int arr[], int ss, int se, int si) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the minimum of two values in this node
        int mid = (ss + (se - ss) / 2);
        st[si] = min(constructSTUtil(arr, ss, mid, si * 2 + 1),
                constructSTUtil(arr, mid + 1, se, si * 2 + 2));
        return st[si];
    }

    int constructSTUtilSum(int arr[], int ss, int se, int si) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (ss == se) {
            sumst[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = (ss + (se - ss) / 2);
        sumst[si] = constructSTUtilSum(arr, ss, mid, si * 2 + 1)
                + constructSTUtilSum(arr, mid + 1, se, si * 2 + 2);
        return sumst[si];
    }


    /* A recursive function to update the nodes which have the given 
       index in their range. The following are parameters
        st, si, ss and se are same as getSumUtil()
        i    --> index of the element to be updated. This index is in
                 input array.
       diff --> Value to be added to all nodes which have i in range */
    void updateSumValueUtil(int ss, int se, int i, int diff, int si) {
        // Base Case: If the input index lies outside the range of 
        // this segment
        if (i < ss || i > se) {
            return;
        }

        // If the input index is in range of this node, then update the
        // value of the node and its children
        sumst[si] = sumst[si] + diff;
        if (se != ss) {
            int mid = (ss + (se - ss) / 2);
            updateSumValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateSumValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    // The function to update a value in input array and segment tree.
    // It uses updateValueUtil() to update the value in segment tree
    void updateSumValue(int arr[], int n, int i, int new_val) {
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        int diff = new_val - arr[i];

        // Update the value in array
        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateSumValueUtil(0, n - 1, i, diff, 0);
    }

    /* Constructor to construct segment tree from given array. This
       constructor  allocates memory for segment tree and calls
       constructSTUtil() to  fill the allocated memory */
    SegmentTree(int arr[], int n) {
        // Allocate memory for segment tree
        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;

        st = new int[max_size]; // Memory allocation
        sumst = new int[max_size]; // Memory allocation

        //build(arr, 0, 0, n - 1);
        constructSTUtil(arr, 0, n - 1, 0);
        constructSTUtilSum(arr, 0, n - 1, 0);

    }

    // A utility function to get minimum of two numbers
    int min(int x, int y) {
        return (x < y) ? x : y;
    }

    int getSumUtil(int ss, int se, int qs, int qe, int si) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se) {
            return sumst[si];
        }

        // If segment of this node is outside the given range
        if (se < qs || ss > qe) {
            return 0;
        }

        // If a part of this segment overlaps with the given range
        int mid = (ss + (se - ss) / 2);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1)
                + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    int getSum(int n, int qs, int qe) {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    int RMQUtil(int ss, int se, int qs, int qe, int index) {
        // If segment of this node is a part of given range, then return
        // the min of the segment
        if (qs <= ss && qe >= se) {
            return st[index];
        }

        // If segment of this node is outside the given range
        if (se < qs || ss > qe) {
            return Integer.MAX_VALUE;
        }

        // If a part of this segment overlaps with the given range
        int mid = (ss + (se - ss) / 2);
        return min(RMQUtil(ss, mid, qs, qe, 2 * index + 1),
                RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
    }

// Return minimum of elements in range from index qs (quey start) to
// qe (query end). It mainly uses RMQUtil()
    int RMQ(int n, int qs, int qe) {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }

        return RMQUtil(0, n - 1, qs, qe, 0);
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        int arr[] = {1, 3, 2, 7, 9, 11};
        int n = arr.length;
        System.out.println("Segment tree");
        SegmentTree tree = new SegmentTree(arr, n);

        // Build segment tree from given array
        //tree.constructST(arr, n);
        int qs = 1;  // Starting index of query range
        int qe = 5;  // Ending index of query range

        // Print minimum value in arr[qs..qe]
        System.out.println("Minimum of values in range [" + qs + ", "
                + qe + "] is = " + tree.RMQ(n, qs, qe) + " sum = " + tree.getSum(n, qs, qe ));
    }

}
