/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binomialcoeff;

/**
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 */
public class BinomialCoeff {

    static int binomialCoeff(int n, int k) {
        // Base Cases
        if (k == 0 || k == n) {
            return 1;
        }

        // Recur
        return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
    }

    static int binomialCoeffMemo(int n, int k) {
        int C[][] = new int[n + 1][k + 1];
        int i, j;

        // Calculate  value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= Math.min(i, k); j++) {
                // Base Cases
                if (j == 0 || j == i) {
                    C[i][j] = 1;
                } // Calculate value using previosly stored values
                else {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }

        return C[n][k];
    }

    /**
     * @param args the command line arguments
     */
    /* Driver program to test above function*/
    public static void main(String args[]) {
        int n = 5, k = 2;
        System.out.println("Value of C(" + n + "," + k + ") is " + binomialCoeffMemo(n, k));
    }
}
