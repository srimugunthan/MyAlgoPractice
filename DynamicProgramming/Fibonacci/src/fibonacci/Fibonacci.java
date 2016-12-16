/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-1/
 */
public class Fibonacci {

    static int MAX = 50;
    static int lookup[];

    /* Function to initialize NIL values in lookup table */
    static void _initialize() {
        int i;
        lookup = new int[MAX];
        for (i = 0; i < MAX; i++) {
            lookup[i] = -1;
        }
    }

    /* function for nth Fibonacci number */
    static int fib(int n) {
        if (lookup[n] == -1) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = fib(n - 1) + fib(n - 2);
            }
        }

        return lookup[n];
    }

    static int fibIter(int n) {
        int f[];
        f = new int[n+1];
        int i;
        f[0] = 0;
        f[1] = 1;
        for (i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 40;
        _initialize();
        System.out.println("Fibonacci number is %d " + fibIter(n));

    }

}
