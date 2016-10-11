/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

/**
 *
 * @author sdhandap
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    
    /* mistakes:
     1. midpt calculation:
            midpt = midpt-midpt/2 (X)
            midpt = end-start/2    (X)
            midpt = end+start/2    (X)
    2. array spit
        did (start, midpt) and (midpt, end) (X)
        (start, midpt) and (midpt+1, end)  (_/)
    3. end condition:
        while(midpt is within 0 and len) (X)
        while(start <= end && start >= 0 and end <= len-1)
    
        while(start <= end) and a special case for start==end (_/)
    
        
        
    
    
    */
    static public int binsearch(int x, int arr[]) {
        int len = arr.length;
        int start = 0;
        int end = len - 1;
        int midpt = len / 2;
        System.out.println("start " + start + "midpt " + midpt + "end " + end);
        while (start <= end ) {
            int prevStart = start;
            int prevEnd =end;
                  
            if(start == end) {
                if(x != arr[start])
                    return -1;
            }
            if (x < arr[midpt]) {
                end = midpt;
                midpt = (int) Math.floor((float)(start + end)/ 2);

            } else if (x > arr[midpt]) {
                start = midpt + 1;
                midpt = (int) Math.ceil((float)(start + end)/ 2);
            } else {
                return midpt;
            }
            System.out.println("start " + start + "midpt " + midpt + "end " + end);
            
            
        }
        return -1;

    }
    
    // Returns index of x if it is present in arr[], else
    // return -1
    public static int binarySearch( int x,int arr[])
    {
        int l = 0, r = arr.length - 1;
        while (l <= r)
        {
            int m = l + (r-l)/2;
 
            // Check if x is present at mid
            if (arr[m] == x)
                return m;
 
            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        // if we reach here, then element was not present
        return -1;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        int arr[] = {3, 5, 7, 10};
        System.out.println(binarySearch(6, arr));
        System.out.println(binarySearch(5, arr));
        System.out.println(binarySearch(2, arr));
        System.out.println(binarySearch(19, arr));
        //System.out.println(binsearch(19, arr));

    }

}
