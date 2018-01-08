package com.test.practice;



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

    static void generate_nbits_i(int n, int[]bitstr){



        for(int binaryVal = 0; binaryVal < Math.pow(2,n); binaryVal++) {
            int temp = binaryVal;
            for (int i = 0; i < n; i++) {

                if(temp%2 == 0){
                    bitstr[n-i-1] = 0;
                }
                else if(temp%2 == 1){
                    bitstr[n-i-1] = 1;
                }
                temp = temp/2;

            }
            System.out.println(Arrays.toString(bitstr));
        }
    }



    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int []bitstr = new int[n];
        generate_nbits_i(n,bitstr);
        printB(n);
    }
}
