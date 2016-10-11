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
public class IntervalTree {

    IntervalNode root;

    public class Interval {

        int low;
        int high;

        Interval(int x, int y) {
            low = x;
            high = y;
        }

        Interval(Pair pair1) {
            low = pair1.s;
            high = pair1.e;
        }
         @Override
        public String toString() {
            return ( "("+ Integer.toString(low) + " , " + Integer.toString(high)+")" );
        }
    };

    public class IntervalNode {

        IntervalNode right;
        IntervalNode left;
        Interval value;

        IntervalNode(Pair pairval) {
            value = new Interval(pairval);

            left = null;
            right = null;

        }
    }

    IntervalTree() {
        this.root = null;
    }

    void treeInsert(IntervalNode node, Pair pair1) {

        if (root == null) {
            root = new IntervalNode(pair1);

        } else {
            /* search recursively from the root to the correct position*/
            if (node.value.low < pair1.s) {
                if (node.left == null) {

                    IntervalNode newnode = new IntervalNode(pair1);
                    node.left = newnode;

                } else {
                    treeInsert(node.left, pair1);
                }
            } else {
                if (node.right == null) {

                    IntervalNode newnode = new IntervalNode(pair1);
                    node.right = newnode;

                } else {
                    treeInsert(node.right, pair1);
                }

            }

        }

    }

    boolean searchIfOverlap(IntervalNode node, Pair pair1) {

        if (node == null) {
            return false;
        } else {
            /*search recursively for left and right subtree */
            /*when to go left and when to turn right*/
            if(node.value.low == pair1.s &&node.value.high == pair1.e)
                return false;

            if ((node.value.low < pair1.e) && (pair1.s < node.value.high)) {
                /*what if node's start value is greater than pair1's start*/
                System.out.println(node.value + "conflicts"+pair1);
                return true;
            } else {
                if(node.value.low < pair1.e) {
                    /* try both the left and right subtree*/
                    if(searchIfOverlap(node.left, pair1) == true)
                        return true;
                    if(searchIfOverlap(node.right, pair1) == true)
                        return true;
                }
                else {
                    /* try only the left subtree*/
                      if(searchIfOverlap(node.right, pair1) == true)
                          return true;
                }

            }
        }
        return false;

    }

    IntervalTree(ArrayList< Pair> arr) {

        for (int i = 0; i < arr.size(); i++) {
            treeInsert(root, arr.get(i));
        }

    }
}
