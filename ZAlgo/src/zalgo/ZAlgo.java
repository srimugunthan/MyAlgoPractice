/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zalgo;

/**
 * Tutorial:
 * https://shiv4289.wordpress.com/2013/09/17/z-algorithm-for-pattern-matching/
 * http://www.geeksforgeeks.org/z-algorithm-linear-time-pattern-searching-algorithm/
 * http://www.utdallas.edu/~besp/demo/John2010/z-algorithm.htm
https://www.cs.umd.edu/class/fall2011/cmsc858s/Lec02-zalg.pdf
 */

/*
ZMatch(T, P):
    S = P$T
    Compute all Zi for S
    return all i-|P|-1 such that Zi = |P|


 Why does this work?
• Zi = |P| if and only if the string starting at i matches P.
*/
public class ZAlgo {

    //  Fills Z array for given string str[]
    void getZarr(String str, int Z[]) {
        int n = str.length();
        int L, R, k;

        // [L,R] make a window which matches with prefix of s
        L = R = 0;
        for (int i = 1; i < n; ++i) {
            // if i>R nothing matches so we will calculate.
            // Z[i] using naive way.
            if (i > R) {
                L = R = i;

                // R-L = 0 in starting, so it will start
                // checking from 0'th index. For example,
                // for "ababab" and i = 1, the value of R
                // remains 0 and Z[i] becomes 0. For string
                // "aaaaaa" and i = 1, Z[i] and R become 5
                while (R < n && str.charAt(R - L) == str.charAt(R)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                // k = i-L so k corresponds to number which
                // matches in [L,R] interval.
                k = i - L;

                // if Z[k] is less than remaining interval
                // then Z[i] will be equal to Z[k].
                // For example, str = "ababab", i = 3, R = 5
                // and L = 2
                if (Z[k] < R - i + 1) {
                    Z[i] = Z[k];
                } // For example str = "aaaaaa" and i = 2, R is 5,
                // L is 0
                else {
                    //  else start from R  and check manually
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }

    void Zsearch(String text, String pattern) {
        // Create concatenated string "P$T"
        String concat = pattern + "$" + text;
        int l = concat.length();

        // Construct Z array
        int Z[] = new int[l];
        getZarr(concat, Z);

        //  now looping through Z array for matching condition
        for (int i = 0; i < l; ++i) {
            // if Z[i] (matched region) is equal to pattern
            // length  we got the pattern
            if (Z[i] == pattern.length()) {
                System.out.println("Pattern found at index " + (i - pattern.length() - 1));
            }
        }
    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        String text = "GEEKS FOR GEEKS";
//        String pattern = "GEEK";
//        ZAlgo zalgo = new ZAlgo();
//        zalgo.Zsearch(text, pattern);
//
//    }

}
