/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intervaltreeprob;

/**
 *
 * @author sdhandap
 */
 public class Pair {

        public int s;
        public int e;

        Pair(int x, int y) {
            s = x;
            e = y;
        }
        
        @Override
        public String toString() {
            return ( "("+ Integer.toString(s) + " , " + Integer.toString(e)+")" );
        }
    }
