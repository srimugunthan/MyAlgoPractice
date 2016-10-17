/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexrotationstring;

/**
 *
 * @author sdhandap
 */
public class LexRotationString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String txt = "banana";

        String txttxt = txt + txt;
        SuffixArray suffixArr = new SuffixArray();
        suffixArr.buildSuffixArray(txttxt);

        
        System.out.println("Following is suffix array for " + txttxt);
        suffixArr.printArr();
        
        System.out.println("Minimum  lexicographic string = "+suffixArr.findFirstLen(txt.length()));
    }

}
