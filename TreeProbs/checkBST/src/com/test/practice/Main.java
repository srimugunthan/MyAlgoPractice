package com.test.practice;

import apple.laf.JRSUIUtils;

public class Main {

    public static  class TreeNode {
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

        TreeNode createTree(int arr[]){
            return createBST(arr,0, arr.length-1);
        }
    }

    static boolean checkBST(TreeNode root){

        if(root == null)
            return true;
        if(root.left != null){

            if(root.left.data > root.data )
                return false;
        }
        if(root.right != null){
            if(root.right.data < root.data)
                return  false;

        }

        return (checkBST(root.left) && checkBST(root.right));

    }


    public static void main(String[] args) {
	// write your code here
        int arr[] = {1,2,3,4,5,6,7,8};
        TreeNode binaryTreeroot = new TreeNode();

        binaryTreeroot = binaryTreeroot.createTree(arr);

        System.out.print(checkBST(binaryTreeroot));

    }
}
