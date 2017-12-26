package com.test.practice;

import java.util.ArrayList;


public class Test {


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

    static void printPathsRec(TreeNode root, int paths[], int pathlen ){

        if(root == null)
            return;

        paths[pathlen] = root.data;
        pathlen++;

        if((root.left == null) && root.right ==null){


            for(int i= 0; i < pathlen;i++)
                System.out.print(paths[i]);
            System.out.println();

        }

        if(root.left != null){
            printPathsRec(root.left, paths, pathlen);
        }
        if(root.right != null){
            printPathsRec(root.right, paths, pathlen);
        }

    }

    static void printPathsRecSum(TreeNode root, int paths[], int pathlen , int pathSum){

        if(root == null)
            return;

        paths[pathlen] = root.data;
        pathlen++;

        if((root.left == null) && root.right ==null){


            int sum = 0;
            for(int i = 0; i < pathlen;i++)
                sum = sum +paths[i];

            if(sum == pathSum) {
                for (int i = 0; i < pathlen; i++)
                    System.out.print(paths[i]);
                System.out.println();
            }

        }

        if(root.left != null){
            printPathsRecSum(root.left, paths, pathlen, pathSum);
        }
        if(root.right != null){
            printPathsRecSum(root.right, paths, pathlen, pathSum);
        }

    }


    static void printPaths(TreeNode root, int pathSum){
        int [] paths = new int[100];
        printPathsRec(root, paths,0);


        System.out.println();

        printPathsRecSum(root, paths,0,pathSum);
    }

    public static void main(String[] args) {


        int arr[] = {1,2,3,4,5,6,7,8};
        TreeNode binaryTreeRoot = new TreeNode();
        binaryTreeRoot = binaryTreeRoot.createTree(arr);

        System.out.println();
        ArrayList nodes = new ArrayList<Integer>();
        //printAllPaths(binaryTreeRoot, nodes);
        printPaths(binaryTreeRoot,7);

    }
}
