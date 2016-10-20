/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slidewindowmax;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * http://poj.org/problem?id=2823
 * http://codercareer.blogspot.in/2012/02/no-33-maximums-in-sliding-windows.html
 * 
 *
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 * Given an array and an integer k, find the maximum for each and every
 * contiguous subarray of size k.
 *
 * Examples:
 *
 * Input : arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6} k = 3 Output : 3 3 4 5 5 5 6
 */
public class SlideWindowMax {

    // all subarrays of size k
    static void printKMax(int arr[], int n, int k) {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e., 
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order

        Deque<Integer> Qi = new ArrayDeque<Integer>();
        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < k; ++i) {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.getLast()]) {
                Qi.removeLast();  // Remove from rear
            }
            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.println(arr[Qi.getFirst()] + " ");

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.getFirst() <= i - k) {
                Qi.removeFirst();  // Remove from front of queue
            }
            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.getLast()]) {
                Qi.removeLast();
            }

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        System.out.println(arr[Qi.getFirst()]);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Driver program to test above functions

        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int n = arr.length;
        int k = 3;
        printKMax(arr, n, k);

    }

}
