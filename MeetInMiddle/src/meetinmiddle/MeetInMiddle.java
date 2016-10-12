
package meetinmiddle;

import java.util.Arrays;

/**
 *
 * https://www.quora.com/What-is-meet-in-the-middle-algorithm-w-r-t-competitive-programming
 * http://www.infoarena.ro/blog/meet-in-the-middle
 * http://www.geeksforgeeks.org/meet-in-the-middle/
 * http://users.informatik.uni-halle.de/~ahyjb/krypto/English/4.5.1.e.html

 */
public class MeetInMiddle {

    long X[];
    long Y[];

    // Find all possible sum of elements of a[] and store
// in x[]
    void calcsubarray(long a[], long x[], int n, int c) {

        for (int i = 0; i < (1 << n); i++) {
            long s = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    s += a[j + c];
                }
            }
            x[i] = s;
        }
    }
    
        public  int lower_bound(long[] arr, long key) {
        int len = arr.length;
        int lo = 0;
        int hi = len-1;
        int mid = (lo + hi)/2;
        while (true) {
            
            if ( arr[mid] > key ) {
                hi = mid-1;
                if (hi < lo)
                    return mid;
            } else {
                lo = mid+1;
                if (hi < lo)
                    return mid<len-1?mid+1:-1;
            }
            mid = (lo + hi)/2;
        }
    }
        

    // Returns the maximum possible sum less or equal to S
    long solveSubsetSum(long a[],  long S) {
        // Compute all subset sums of first and second
        // halves
        int n = a.length;
        X = new long[2000005];
        Y = new long[2000005];
        calcsubarray(a, X, n / 2, 0);
        calcsubarray(a, Y, n - n / 2, n / 2);

        int size_X = 1 << (n / 2);
        int size_Y = 1 << (n - n / 2);

        // Sort Y (we need to do doing binary search in it)
        Arrays.sort(Y);

        // To keep track of the maximum sum of a subset
        // such that the maximum sum is less than S
        long max = 0;

        // Traverse all elements of X and do Binary Search
        // for a pair in Y with maximum sum less than S.
        for (int i = 0; i < size_X; i++) {
            if (X[i] <= S) {
                // lower_bound() returns the first address
                // which has value greater than or equal to
                // S-X[i].
                
                
                //int p = Arrays.binarySearch(Y, S-X[i]);
                int p = lower_bound(Y, S-X[i]);
                System.out.println(X[i] +" "+ (S-X[i]) +" "+p  +" "+Y[p] +" "+Y[p-1]);
                //int p = lower_bound(Y, Y + size_Y, S - X[i]) - Y;

                // If S-X[i] was not in array Y then decrease
                // p by 1
                if (p == size_Y || Y[p] != (S - X[i])) {
                    p--;
                }

                if ((Y[p] + X[i]) > max) {
                    max = Y[p] + X[i];
                }
            }
        }
        return max;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        long a[] = {3, 34, 4, 12, 5, 2};
        long S = 10;
        MeetInMiddle m = new MeetInMiddle();
        System.out.println("Largest value smaller than or equal to given sum is\n" + m.solveSubsetSum(a, S));
        
    }

}
