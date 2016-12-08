/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmpsearch;

/**
 *
 * https://www.quora.com/What-are-some-good-problems-that-uses-Knuth-Morris-Pratt-Algorithm-on-TopCoder-Codeforces-CodeChef-and-SPOJ
 */
public class KMPSearch {
    
    //lps calculation explanation: https://www.youtube.com/watch?v=GTJr8OvyEVQ
       void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0
 
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else  // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar 
                // to search step.
                if (len != 0)
                {
                    len = lps[len-1];
 
                    // Also, note that we do not increment
                    // i here
                }
                else  // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
       

     void KMP_Search(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
 
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0;  // index for pat[]
 
        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat,M,lps);
 
        int i = 0;  // index for txt[]
        while (i < N)
        {
            if (pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                System.out.println("Found pattern "+
                              "at index " + (i-j));
                j = lps[j-1];
            }
 
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i))
            {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
    }
     
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        String txt = "ABABDABACDABABCABAB";
//        String pat = "ABABCABAB";
//        new KMPSearch().KMP_Search(pat,txt);
//    }
//    
}
