/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zalgo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * http://www.spoj.com/problems/NHAY/
 */
public class NHAYprob {

    static String INPUT_FILENAME = "./input.txt";

    public static void main(String[] args) {

        try {
            File fIn = new File(INPUT_FILENAME);
            FileInputStream fIs = new FileInputStream(fIn);

            BufferedReader br = new BufferedReader(new InputStreamReader(fIs));

//             InputStream inputStream
//                    = TrieProb.class.getClassLoader().getResourceAsStream("input.txt");
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int count = 0;
            String line; 
            

            while ((line  = br.readLine()) != null) {
                int n = Integer.parseInt(line);
                String needle = br.readLine();
                String haystack = br.readLine();
                ZAlgo zalgo = new ZAlgo();
                zalgo.Zsearch(haystack, needle);
                
            }

        } catch (IOException ex) {
            Logger.getLogger(NHAYprob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
