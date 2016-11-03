/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbalance;



import java.util.ArrayList;

import CtCILibrary.TreeNode;
/*
 4.1 Implement a function to check if a tree is balanced. For the purposes of this question,
 a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
 from the root by more than one.
 */

public class Checkbalance {

     public static  int subtreeheight(TreeNode node, int curheight)
    {
        if(node == null)
        {
         return curheight;   
        }
        else
        {
            return Math.max(subtreeheight(node.left,curheight+1), subtreeheight(node.right,curheight+1));
        }
        
    }
    public static boolean isBalanced(TreeNode bst) {
        
         return (subtreeheight(bst.left,0) == subtreeheight(bst.right,0));

        
    }

    public static void main(String[] args) {
        // Create balanced tree
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);

        root.print();
        System.out.println("Is balanced? " + isBalanced(root));

        root.insertInOrder(4); // Add 4 to make it unbalanced
        root.print();

        System.out.println("Is balanced? " + isBalanced(root));
    }

}