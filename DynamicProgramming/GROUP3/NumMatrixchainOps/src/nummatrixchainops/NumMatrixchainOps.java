/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nummatrixchainops;

/**
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 */
public class NumMatrixchainOps {

      // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int MatrixChainOrder(int p[], int i, int j)
    {
        if (i == j)
            return 0;
 
        int min = Integer.MAX_VALUE;
 
        // place parenthesis at different places between first
        // and last matrix, recursively calculate count of
        // multiplications for each parenthesis placement and
        // return the minimum count
        for (int k=i; k<j; k++)
        {
            int count = MatrixChainOrder(p, i, k) +
                        MatrixChainOrder(p, k+1, j) +
                        p[i-1]*p[k]*p[j];
 
            if (count < min)
                min = count;
        }
 
        // Return minimum count
        return min;
    }
    
// Dynamic Programming Python implementation of Matrix
// Chain Multiplication.
// See the Cormen book for details of the following algorithm
    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int MatrixChainOrderMemo (int p[], int n)
    {
        /* For simplicity of the program, one extra row and one
        extra column are allocated in m[][].  0th row and 0th
        column of m[][] are not used */
        int m[][] = new int[n][n];
 
        int i, j, k, L, q;
 
        /* m[i,j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */
 
        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;
 
        // L is chain length.
        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                if(j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
 
        return m[1][n-1];
    }
    
     // Driver program to test above function
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 2, 3, 4, 3};
        int n = arr.length;
 
        System.out.println("Minimum number of multiplications is "+
                           MatrixChainOrderMemo(arr, n));
 
    }
    
    
}

