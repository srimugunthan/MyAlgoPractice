/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medianinstream;

/*
http://www.spoj.com/problems/XMEDIAN/
not the same output as the solution in :
 http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
*/

public class MedianInStream {

    
    
    // Signum function
    // = 0  if a == b  - heaps are balanced
    // = -1 if a < b   - left contains less elements than right
    // = 1  if a > b   - left contains more elements than right
    public static int Signum(int a, int b) {
        if (a == b) {
            return 0;
        }

        return a < b ? -1 : 1;
    }

// Function implementing algorithm to find median so far.
    public static int getMedian(int elemInsert, int curMedian, MaxHeap lessMaxHeap, MinHeap bigMinHeap) {
        // Are heaps balanced? If yes, sig will be 0

        int sig = Signum(lessMaxHeap.getCount(), bigMinHeap.getCount());
        switch (sig) {
            case 1: // There are more elements in left (max) heap

                if (elemInsert < curMedian) // current element fits in left (max) heap
                {
                    // Remore top element from left heap and
                    // insert into right heap
                    bigMinHeap.insert(lessMaxHeap.extractTop());

                    // current element fits in left (max) heap
                    lessMaxHeap.insert(elemInsert);
                } else {
                    // current element fits in right (min) heap
                    bigMinHeap.insert(elemInsert);
                }

                // Both heaps are balanced
                curMedian = (lessMaxHeap.getTop() + bigMinHeap.getTop()) / 2;

                break;

            case 0: // The left and right heaps contain same number of elements

                if (elemInsert < curMedian) // current element fits in left (max) heap
                {
                    lessMaxHeap.insert(elemInsert);
                    curMedian = lessMaxHeap.getTop();
                } else {
                    // current element fits in right (min) heap
                    bigMinHeap.insert(elemInsert);
                    curMedian = bigMinHeap.getTop();
                }

                break;

            case -1: // There are more elements in right (min) heap

                if (elemInsert < curMedian) // current element fits in left (max) heap
                {
                    lessMaxHeap.insert(elemInsert);
                } else {
                    // Remove top element from right heap and
                    // insert into left heap
                    lessMaxHeap.insert(bigMinHeap.extractTop());

                    // current element fits in right (min) heap
                    bigMinHeap.insert(elemInsert);
                }

                // Both heaps are balanced
                curMedian = (lessMaxHeap.getTop() + bigMinHeap.getTop()) / 2;

                break;
        }

        // No need to return, m already updated
        return curMedian;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};

        int m = 0; // effective median
        MaxHeap lessMaxHeap = new MaxHeap(100);
        MinHeap bigMinHeap = new MinHeap(100);

        for (int i = 0; i < A.length; i++) {
            
            System.out.println(A[i]);
            m = getMedian(A[i], m, lessMaxHeap, bigMinHeap);

            System.out.println("Running median" + m);
        }

    }

}
