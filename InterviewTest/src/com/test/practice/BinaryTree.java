package com.test.practice;



public class BinaryTree<T> implements IBinaryTree {

    T data;
    BinaryTree<T> left;
    BinaryTree<T> right;









    public void setLeftChild(BinaryTree left) {
        this.left = left;

    }

    public void setRightChild(BinaryTree right) {
        this.right = right;

    }

    public static<T> BinaryTree <T> createMinimalBST(T [] arr, int start, int end){
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryTree subtree =new BinaryTree<T>();

        subtree.data = arr[mid];

        subtree.setLeftChild(createMinimalBST(arr, start, mid - 1));
        subtree.setRightChild(createMinimalBST(arr, mid + 1, end));
        return subtree;
    }




    T traverseInorder(T item, int found){



        if(this.left != null){

            (this.left).traverseInorder(item, found);
        }

        System.out.println(this.data);

        if(this.right != null){

            (this.right).traverseInorder(item, found);
        }

    }








//
    @Override
    public IBinaryTree<T> getLeft(){
        return this.left;

    }

    @Override
    public IBinaryTree<T> getRight() {

        return this.right;
    }


    @Override
    public T getData(){

        return data;
    }


    public  int  getCount(IBinaryTree <T> tree){
        if(tree == null){
            return 0;
        }
        else {

            return 1 + getCount(tree.getLeft()) + getCount(tree.getRight());
        }

    }



}
