package com.test.practice;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {



    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode createBST(int[] arr, int start, int end){
            if(end < start) {
                return null;
            }

            int mid;
            mid = start + (end - start)/2;
            TreeNode node = new TreeNode();
            node.data = arr[mid];
            node.left = createBST(arr, start, mid-1);
            node.right  = createBST(arr, mid+1,end);
            return node;
        }


        TreeNode createTree(int [] arr){

            return createBST(arr,0, arr.length-1);

        }

    }


    static void levelOrderTraversal(TreeNode root, LinkedBlockingQueue<TreeNode> visitedQ) throws InterruptedException{





        visitedQ.put(root);

        while(!visitedQ.isEmpty()){
            TreeNode subtree = visitedQ.take();
            System.out.println(subtree.data);
            if(subtree.left != null)
              visitedQ.put(subtree.left);
            if(subtree.right != null)
              visitedQ.put(subtree.right);


        }


    }

    static void reverseLevelOrder(TreeNode root, LinkedBlockingQueue<TreeNode> visitedQ) throws InterruptedException{

        Stack<TreeNode> stack = new Stack<>();


        visitedQ.put(root);

        while(!visitedQ.isEmpty()){
            TreeNode subtree = visitedQ.take();
            stack.push(subtree);
            if(subtree.left != null)
                visitedQ.put(subtree.left);
            if(subtree.right != null)
                visitedQ.put(subtree.right);


        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.data);
        }

    }

    public static void main(String[] args) throws  InterruptedException {
	// write your code here
        int arr[] = {1,2,3,4,5,6,7,8};
        TreeNode binaryTreeRoot = new TreeNode();
        binaryTreeRoot = binaryTreeRoot.createTree(arr);
        LinkedBlockingQueue visitedQ = new LinkedBlockingQueue<TreeNode>();
        reverseLevelOrder(binaryTreeRoot, visitedQ);

    }
}
