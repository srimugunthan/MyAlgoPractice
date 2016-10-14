/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medianinstream;

/**
 *
 * @author sdhandap
 */
public class MaxHeap {

    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    public int getTop(){
        return Heap[FRONT];
    }
    
    public int getCount() {
        return size;
    }
    
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void siftDown(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    siftDown(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    siftDown(rightChild(pos));
                }
            }
        }
    }

    public int deleteMax() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        siftDown(FRONT);
        return popped;
    }
    
    public int extractTop() {
        return deleteMax();
    }

    public void maxHeapify() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            siftDown(pos);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void insert(int element) {
        Heap[++size] = element;
        int current = size;

         /* sift-up operation */
        while (true) {
            if (current == 1) {
                break;
            }
            int p = parent(current);
            if (Heap[p] >= Heap[current]) {
                break;
            }
            swap(p, current);
            current = p;
        }
        
//        while (Heap[current] > Heap[parent(current)]) {
//            swap(current, parent(current));
//            current = parent(current);
//        }
    }

    public static void main(String... arg) {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(100);
        
        int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        for(int i = 0; i < A.length; i++){
            maxHeap.insert(A[i]);
        }
        
        
//        maxHeap.insert(5);
//        maxHeap.insert(3);
//        maxHeap.insert(17);
//        maxHeap.insert(10);
//        maxHeap.insert(84);
//        maxHeap.insert(19);
//        maxHeap.insert(6);
//        maxHeap.insert(22);
//        maxHeap.insert(9);
        // maxHeap.maxHeap();

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.deleteMax());
    }

}
