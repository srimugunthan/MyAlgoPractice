package com.test.practice;

public class Main {

    public static void main(String[] args) {



        Integer [] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10,11,12};
        BinaryTree <Integer> rootOftree = new BinaryTree();
        rootOftree = rootOftree.createMinimalBST(array,0, array.length-1);
        System.out.println("count = "+rootOftree.getCount(rootOftree));

        rootOftree.traverseInorder();



    }
}
