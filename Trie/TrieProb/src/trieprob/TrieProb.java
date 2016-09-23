/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieprob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdhandap All categories: https://a2oj.com/categories the list:
 * https://a2oj.com/category?ID=49 Prob: http://www.spoj.com/problems/PHONELST/
 */
public class TrieProb {

    static String INPUT_FILENAME = "./input.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TrieNode myTrie = new TrieNode();
        System.out.println(myTrie.getnumchild());
        try {
            File fIn = new File(INPUT_FILENAME);
            FileInputStream fIs = new FileInputStream(fIn);

            BufferedReader br = new BufferedReader(new InputStreamReader(fIs));
            
            
//             InputStream inputStream
//                    = TrieProb.class.getClassLoader().getResourceAsStream("input.txt");
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            
            
            int count = 0;
            String inPhNum = br.readLine();
            while (inPhNum != null) {
                System.out.println(inPhNum);
                if (myTrie.search(inPhNum) != true) {
                    myTrie.insert(inPhNum);
                } else {
                    System.out.println("Wrong ph num :" + inPhNum);
                }
                inPhNum = br.readLine();
            }
            
            myTrie.printTrie();

        } catch (IOException ex) {
            Logger.getLogger(TrieProb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
