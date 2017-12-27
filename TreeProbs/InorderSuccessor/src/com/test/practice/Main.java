package com.test.practice;

public class Main {

    //https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/


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


    public static TreeNode getInorderSuccessor(TreeNode root, int item) {
        if (root == null )
            return null;

        TreeNode node = search(item,root);
        if(node == null)
            return null;
        if (node.right != null) {
            /* case 1 is easy. right node is not null. traverse to right and from there reach the leftmost node*/
            TreeNode temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            /*case 2: hard. right node is null.
                    successor is one of parent.
                    but which parent?
                    the most nearest parent which has this node on the left subtree.
                    https://stackoverflow.com/questions/5471731/in-order-successor-in-binary-search-tree

                    how to get there? if you have parent pointers it is easy.
                    in case you dont have parent pointers
             */


            TreeNode searchParent = root;
            TreeNode successor = null;
            while (searchParent != node && searchParent != null) {
                if (searchParent.data > node.data) {
                    successor = searchParent;
                    searchParent = searchParent.left;
                } else {
                    searchParent = searchParent.right;
                }
            }


            return successor;


        }
    }





    static void printInOrder(TreeNode root){
        if(root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);

    }


    public static TreeNode search(int item, TreeNode binaryRoot){
        TreeNode searchnode = binaryRoot;
        TreeNode retnode;
        if(searchnode == null)
            return null;
        if(searchnode.data > item)
            retnode = search(item,searchnode.left);
        else if(searchnode.data < item)
            retnode = search(item, searchnode.right);
        else
            retnode = searchnode;

        return retnode;

    }


    public static void main(String[] args) {
        // write your code here
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode binaryTreeRoot = new TreeNode();
        binaryTreeRoot = binaryTreeRoot.createTree(arr);
        printInOrder(binaryTreeRoot);
        System.out.println((getInorderSuccessor(binaryTreeRoot,8)));


    }
}
