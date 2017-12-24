package com.test.practice;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;

public class Main {


    public static class TreeNode{
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

    void printTree(TreeNode root){

    }

    static int findMaxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+ Math.max(findMaxDepth(root.left), findMaxDepth(root.right));


    }

    static int findMinValue(TreeNode root){

        if(root == null)
            return Integer.MAX_VALUE;
        return Math.min(root.data, Math.min(findMinValue(root.left), findMinValue(root.right)));


    }

    static void printPostOrder(TreeNode root){

        if(root == null)
            return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.data);
    }

    static void printInOrder(TreeNode root){
        if(root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);

    }

    static void printPreOrder(TreeNode root){

        if(root == null){
            return;
        }
        System.out.println(root.data);
        printPreOrder(root.left);
        printPostOrder(root.right);

    }

    static void printAllPaths(TreeNode root, ArrayList nodesAlongPAth){
        if(root == null ){
            System.out.println(nodesAlongPAth);
            return;
        }


        nodesAlongPAth.add(root.data);
        if(root.left == null && root.right == null){
            System.out.println(nodesAlongPAth);
            return;
        }


            printAllPaths(root.left,nodesAlongPAth);

            printAllPaths(root.right,nodesAlongPAth);



    }

    static TreeNode searchFor(TreeNode root,int item){

        if(root == null){
            return null;
        }
        if(root.data == item){
            return root;
        }
        else{
            if(item < root.data) {
                return searchFor(root.left,item);
            }
            if(item >root.data){
                return searchFor(root.right,item );
            }
        }
        return null;

    }


    public static void main(String[] args) {
	// write your code here
        Main testthis = new Main();
        int arr[] = {1,2,3,4,5,6,7,8};
        TreeNode binaryTreeRoot = new TreeNode();
        binaryTreeRoot = binaryTreeRoot.createTree(arr);

        printPostOrder(binaryTreeRoot);
        System.out.println(findMaxDepth(binaryTreeRoot));
        TreeNode searchres = searchFor(binaryTreeRoot,4);
        System.out.println(searchres.data);
        System.out.println(findMinValue(binaryTreeRoot));
        ArrayList nodes = new ArrayList<Integer>();
        printAllPaths(binaryTreeRoot, nodes);
    }
}
