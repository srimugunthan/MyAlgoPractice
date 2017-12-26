package com.test.practice;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode createBST(int[] arr, int start, int end) {
            if (end < start) {
                return null;
            }

            int mid;
            mid = start + (end - start) / 2;
            TreeNode node = new TreeNode();
            node.data = arr[mid];
            node.left = createBST(arr, start, mid - 1);
            node.right = createBST(arr, mid + 1, end);
            return node;
        }


        TreeNode createTree(int[] arr) {

            return createBST(arr, 0, arr.length - 1);

        }

    }

    static void levelOrderTraversal(TreeNode root)  {


        LinkedBlockingQueue<TreeNode> visitedQ = new LinkedBlockingQueue<>();
        try {
            visitedQ.put(root);

            while (!visitedQ.isEmpty()) {
                TreeNode subtree = visitedQ.take();
                System.out.print(subtree.data);
                if (subtree.left != null)
                    visitedQ.put(subtree.left);
                if (subtree.right != null)
                    visitedQ.put(subtree.right);


            }
        }catch( InterruptedException ex){
            System.out.println(ex);
        }


    }
   static  boolean isidentical(TreeNode root1, TreeNode root2){

        if(root1 == null || root2 == null){
            if(root1 == null && root2 == null)
                return true;
            else
                return false;
        }


        if(root1.data == root2.data){
            if((isidentical(root1.left, root2.left) == true) && (isidentical(root1.right, root2.right) == true))
                    return true;

        }
        return false;

    }



    /* check if one tree root1 is subtree of another root2*/
    static boolean checksubtree(TreeNode root1, TreeNode root2){

        if(root1 == null && root2 == null)
            return true;
        else if(root1 == null || root2 == null)
            return false;


        /* check if root1 is in second tree root2*/



        if(isidentical(root1, root2) == true)
            return true;

        else{
            if(checksubtree(root1, root2.left) == true)
                return true;
            else if (checksubtree(root1, root2.right) == true)
                return true;

            return false;

        }





    }

    public static void main(String[] args) {


        int arr[] = {1,2,3,4,5,6,7,8};
        TreeNode binaryTreeRoot = new TreeNode();
        binaryTreeRoot = binaryTreeRoot.createTree(arr);
        System.out.println(checksubtree(binaryTreeRoot.left.right,binaryTreeRoot));




    }
}
