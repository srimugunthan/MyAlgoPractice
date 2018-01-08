package com.test.practice;

import java.util.Scanner;



        import java.util.Arrays;
        import java.util.Scanner;

/*Given a positive integer N, count all possible distinct binary strings of length N
        such that there are no consecutive 1’s. */
public class Main {

    static void generate_nbits(int n, int []bitstr){
        if (n <= 0){
            System.out.print(Arrays.toString(bitstr));

            return;
        }
        bitstr[n-1] = 0;
        generate_nbits(n-1, bitstr);
        bitstr[n-1] = 1;
        generate_nbits(n-1, bitstr);
    }


    //https://codereview.stackexchange.com/questions/24690/print-all-binary-strings-of-length-n
    static void printB(int n)
    {
        String B;
        for(int i = 0; i < Math.pow(2,n); i++)
        {
            B = "";
            int temp = i;
            for (int j = 0; j < n; j++)
            {
                if (temp%2 == 1)
                    B = '1'+B;
                else
                    B = '0'+B;
                temp = temp/2;
            }
            System.out.println(B);
        }
    }

    //https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
    // Print all subsets of given set[]
    static void printSubsets(char set[])
    {
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }

    static void generate_nbits_i(int n, int[]bitstr, char set[]){



        for(int binaryVal = 0; binaryVal < Math.pow(2,n); binaryVal++) {
            int temp = binaryVal;
            System.out.println();
            System.out.print("{");
            for (int i = 0; i < n; i++) {

                if(temp%2 == 0){
                    bitstr[n-i-1] = 0;
                }
                else if(temp%2 == 1){
                    bitstr[n-i-1] = 1;
                    System.out.print(set[n-i-1] + " ");
                }
                temp = temp/2;

            }
            System.out.println("}");

        }
    }



    public static void main(String[] args) {
        // write your code here

        int n = 3;
        int []bitstr = new int[n];
        char set[] = {'a','b','c'};
        generate_nbits_i(n,bitstr,set);
        printSubsets(set);
    }
}
