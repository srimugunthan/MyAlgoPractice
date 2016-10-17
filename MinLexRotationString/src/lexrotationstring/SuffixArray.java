/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexrotationstring;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author sdhandap
 */
public class SuffixArray {

    class suffix {

        int index;
        String suff;
    }

    // A comparison function used by sort() to compare two suffixes
    class suffixComparator implements Comparator<suffix> {

        @Override
        public int compare(suffix suffix1, suffix suffix2) {

            String s1 = suffix1.suff;
            String s2 = suffix2.suff;
            return s1.compareTo(s2);
        }
    }
    int suffixArr[];
    suffix suffixes[];

    SuffixArray() {

    }

// This is the main function that takes a string 'txt' of size n as an
// argument, builds and return the suffix array for the given string
    void buildSuffixArray(String txt) {
        int n = txt.length();
        // A structure to store suffixes and their indexes
        suffixes = new suffix[n];

        // Store suffixes and their indexes in an array of structures.
        // The structure is needed to sort the suffixes alphabatically
        // and maintain their old indexes while sorting
        for (int i = 0; i < n; i++) {
            suffixes[i] = new suffix();
            suffixes[i].index = i;
            suffixes[i].suff = txt.substring(i);

        }

        // Sort the suffixes using the comparison function
        // defined above.
        Arrays.sort(suffixes, new suffixComparator());

        // Store indexes of all sorted suffixes in the suffix array
        suffixArr = new int[n];
        for (int i = 0; i < n; i++) {
            suffixArr[i] = suffixes[i].index;
        }

    }

// A utility function to print an array of given size
    void printArr() {
        for (int i = 0; i < suffixArr.length; i++) {
            System.out.println(suffixArr[i] + " " + suffixes[suffixArr[i]].suff);
        }

    }

    String findFirstLen(int length) {
        String retString = null;
        for (int i = 0; i < suffixArr.length; i++) {
            
            if (suffixes[i].suff.length() == length) {
                retString = suffixes[i].suff;
                  break;
            }
          
        }
        return retString;

    }
// Driver program to test above functions
//    public static void main(String args[]) {
//        String txt = "banana";
//
//        SuffixArray suffixArr = new SuffixArray();
//        suffixArr.buildSuffixArray(txt);
//
//        System.out.println("Following is suffix array for " + txt);
//        suffixArr.printArr();
//
//    }

}
