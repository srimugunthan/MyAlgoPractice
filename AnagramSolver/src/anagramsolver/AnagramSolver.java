/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagramsolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 *
 * http://javahungry.blogspot.com/2013/08/anagram-solver-jumbled-words-to-find.html
 * https://gist.github.com/qaproxy/422a1437b2c0314a4ece
 *
 * https://github.com/MichaelBoselowitz/Python-Jumble-Solver/blob/master/Python-Jumble-Solver.py
 *
 * Similar probs: words with vowels in order: https://github.com/archer884/vchk
 *
 * Spell checker https://github.com/hekoru/pyspellcheck
 *
 */
public class AnagramSolver {

    static class MyDictionary {

        Set<String> words;

        MyDictionary() {
            try {
                FileInputStream fis = new FileInputStream(new File("/usr/share/dict/words"));
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                words = new LinkedHashSet();
                String line;
                while ((line = br.readLine()) != null) {
                    words.add(line);
                }
            } catch (IOException f) {
                System.out.println("IO exception");
            }
        }

        boolean checkValidWord(String word) {
            return words.contains(word);

        }
    }

    static void permute_helper(int level, String permuted,
            boolean used[], String original, MyDictionary dict) {
        int length = original.length();
        if (level == length) {
            
            if (dict.checkValidWord(permuted)) {
                System.out.println(permuted);
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    permute_helper(level + 1, permuted + original.charAt(i),
                            used, original, dict);
                    used[i] = false;
                }
            }
        }
    }

    static void solveJumble(String word, MyDictionary dict) {

        boolean used[] = new boolean[word.length()];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }

        permute_helper(0, "", used, word, dict);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // read input word
        // permute the word
        // search in dict.   print if in dict
        try {
//            File dir = new File(".");
//            File fin = new File(dir.getCanonicalPath() + File.separator + "in.txt");
//            FileInputStream fis = new FileInputStream(fin);
            InputStreamReader fis = new InputStreamReader(System.in);

            // BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            BufferedReader br = new BufferedReader(fis);
            String line = null;
            line = br.readLine();
            String inputWord = line;

            MyDictionary mydict = new MyDictionary();
            solveJumble(inputWord, mydict);

        } catch (IOException f) {
            System.out.println("IO exception");
        }

    }

}
