/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmpsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdhandap
 */
public class SPOJ_EPALIN {
    // http://www.spoj.com/problems/EPALIN/
    //http://jiteshsunhala.blogspot.in/2015/07/spoj-problem-epalin.html

    static String INPUT_FILENAME = "./input.txt";

    static String findShortestPalin(String s) {
        String res = s;
        String revStr = new StringBuffer(s).reverse().toString();
        String tempstr = revStr + "#" + s;
        int M = tempstr.length();
        int lps[] = new int[M];
        KMPSearch kmp = new KMPSearch();
        kmp.computeLPSArray(tempstr, M, lps);

        int noOfChars = s.length() - lps[M - 1];
        for (int i = noOfChars - 1; i >= 0; i--) {
            res = res + s.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        try {
            File fIn = new File(INPUT_FILENAME);
            FileInputStream fIs = new FileInputStream(fIn);

            BufferedReader br = new BufferedReader(new InputStreamReader(fIs));

            String line = br.readLine();
            while (line != null) {

                System.out.println(findShortestPalin(line));
                line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(SPOJ_EPALIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
