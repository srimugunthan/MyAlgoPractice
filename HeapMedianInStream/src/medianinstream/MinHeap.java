/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medianinstream;

/**
 *
 * http://www.sanfoundry.com/java-program-implement-min-heap/
 */
public class MinHeap {

    private int[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
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
        
        //if ((2*pos > size) && ((2*pos)+1 > size))
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

    /* 
    insert if O(logn)
    */
    public void insert(int element) {
        Heap[++size] = element;
        int current = size;

        /* sift-up operation */
        while (true) {
            if (current == 1) {
                break;
            }
            int p = parent(current);
            if (Heap[p] <= Heap[current]) {
                break;
            }
            swap(p, current);
            current = p;
        }
//        while (Heap[current] < Heap[parent(current)]) {
//            swap(current, parent(current));
//            current = parent(current);
//        }
    }

    /* complexit is O(logn)*/
    public int deleteMin() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        siftDown(FRONT);
        return popped;
    }
    
    public int extractTop() {
        return deleteMin();
    }
            
    /* complexity is O(1) */
    public int findMin() {
        
        return Heap[FRONT];
    }
    
    
    //http://stackoverflow.com/questions/13025163/why-siftdown-is-better-than-siftup-in-heapify
    /*
     *
     Actually, building a heap with repeated calls of siftDown has a complexity of O(n)
    whereas building it with repeated calls of siftUp has a complexity of O(nlogn).

This is due to the fact that when you use siftDown, the time taken by each call
    decreases with the depth of the node because these nodes are closer to the leaves.
    When you use siftUp, the number of swaps increases with the depth of the node 
    because if you are at full depth, you may have to swap all the way to the root. 
    As the number of nodes grows exponentially with the depth of the tree, using siftUp
    gives a more expensive algorithm.

Moreover, if you are using a Max-heap to do some sort of sorting where you pop
    the max element of the heap and then reheapify it, it's easier to do so by using siftDown.
    You can reheapify in O(logn) time by popping the max element, putting the 
    last element at the root node (which was empty because you popped it) and 
    then sifting it down all the way back to its correct spot.
     */
    
    // https://johnderinger.wordpress.com/2012/12/28/heapify/
    //heapify: create a heap out of given array of elements
    public  void heapify() {
        // last index in the array
        int end = Heap.length - 1;
        // start is assigned the index of the last parent node
        // which in our case is index[3] value(2)
        int start = (end - 1) / 2; // |2|binary heap

        while (start >= 0) {
            // sift down the node at index start to the proper place
            // such that all nodes below the start index are in heap
            // order
            siftDown(Heap, start, end - 1);
            // decrement to the next lowest parent node
            start--;
        }
        // after sifting down the root all nodes/elements
        //  are in heap order
    }

    public  void siftDown(int[] data, int start, int end) {
        int root = start;
        // while the root has at least one child
        while ((2 * root + 1) <= end) {
            // root*2+1 points to the left child
            int child = 2 * root + 1;
            // take the highest of the left or right child
            if (child + 1 <= end && data[child] < data[child + 1]) {
                // then point to the right child instead
                child = child + 1;
            }

            // out of max-heap order
            // swap the child with root if child is greater
            if (data[root] < data[child]) {
                int tmp = data[root];
                data[root] = data[child];
                data[child] = tmp;

                // return the swapped root to test against
                //  it's new children
                root = child;
            } else {
                return;
            }
        } // End while
    }

    
    
    private void siftDown(int pos)
    {
        if (!isLeaf(pos) )
        { 
            if ( Heap[pos] > Heap[leftChild(pos)]  || Heap[pos] > Heap[rightChild(pos)])
            {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)])
                {
                    swap(pos, leftChild(pos));
                    siftDown(leftChild(pos));
                }else
                {
                    swap(pos, rightChild(pos));
                    siftDown(rightChild(pos));
                }
            }
        }
    }
    
    public void minHeapify()
    {
        for (int pos = (size / 2); pos >= 1 ; pos--)
        {
            siftDown(pos);
        }
    }
    
    public void print()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i] 
                + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            System.out.println();
        } 
    }
    
    /* building a heap is O(n) op
    http://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity
    
    */

//    public static void main(String args[]) {
//        System.out.println("The Min Heap is ");
//        MinHeap minHeap = new MinHeap(100);
//        
//        int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
//        for(int i = 0; i < A.length; i++){
//            minHeap.insert(A[i]);
//        }
//        
//        
////        minHeap.insert(5);
////        minHeap.insert(3);
////        minHeap.insert(17);
////        minHeap.insert(10);
////        minHeap.insert(84);
////        minHeap.insert(19);
////        minHeap.insert(6);
////        minHeap.insert(22);
////        minHeap.insert(9);
////        minHeap.minHeapify();
//
//        minHeap.print();
//        System.out.println("The Min val is " + minHeap.deleteMin());
//    }
    /*
    heapsort(){
        Idea:
            -put elements into a max-heap
            -element A[1] is the maximum element
            -exchange A[1] with the last element in the array
            -decrease the size of the heap by one
            -maintain the heap order property by calling Max-Heapify
    }
*/
}
