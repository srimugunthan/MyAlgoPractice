/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intervaltreeprob;

import java.util.ArrayList;

/**
 *
 * @author sdhandap
 */

/* mistakes:
 1. considered all possible conflicting pairs. should consider only if it conflicts iwth previous apptmts
 2. the conflicting condition is wrong.
*/
public class IntervalTreeProb {

    /**
     *
     *
     * Given n appointments, merge all conflicting appointments Input:
     * appointments[] = { {1, 5} {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}}
     * Output: Following are conflicting intervals
     * [3,7] Conflicts with [1,5]
     * [2,6] Conflicts with [1,5]
     * [5,6] Conflicts with [3,7]
     * [4,100] Conflicts with [1,5]
     * 
     * An appointment is conflicting, if it conflicts with any of the previous appointments in array.
     *
     * 
     */
    static boolean checkConflictmy(Pair pair1, Pair pair2) {
        if ((pair2.s > pair1.s) && (pair2.s < pair1.e)) {
            System.out.print(" cond1 true ");
            return true;
        } else if ((pair1.s > pair2.s) && (pair1.s < pair2.e)) {
            System.out.print(" cond2 true ");
            return true;
        } else {
            return false;
        }

    }

    static boolean checkConflict(Pair pair1, Pair pair2) {
//        if( ( pair2.s > pair1.s) && (pair2.s <  pair1.e)) {
//            System.out.print(" cond1 true ");
//            return true;
//        }
//        else if ((pair1.s > pair2.s) &&( pair1.s <  pair2.e)){
//            System.out.print(" cond2 true ");
//            return true;
//        }
        if ((pair1.s < pair2.e) && (pair2.s < pair1.e)) {

            return true;
        } else {
            return false;
        }

    }

    static void naive_On2soln(ArrayList<Pair> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i+1; j < input.size(); j++) {
                if (checkConflict(input.get(i), input.get(j)) == true) {
                    System.out.println(input.get(i) + "conflicts" + input.get(j));
                }
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Pair> input = new ArrayList<Pair>();
        input.add(new Pair(1, 5));

        input.add(new Pair(3, 7));
        input.add(new Pair(2, 6));
        input.add(new Pair(10, 15));
        input.add(new Pair(5, 6));
        input.add(new Pair(4, 100));

        naive_On2soln(input);
        System.out.println("========");
        IntervalTree itree = new IntervalTree(input);
        for (int i = 0; i < input.size(); i++) {
            itree.searchIfOverlap(itree.root, input.get(i));
        }
    }

}


