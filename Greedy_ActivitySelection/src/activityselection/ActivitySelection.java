/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activityselection;

/**
 *
 * @author sdhandap
 */
public class ActivitySelection {



//http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/

// Prints a maximum set of activities that can be done by a single
// person, one at a time.
//  n   -->  Total number of activities
//  s[] -->  An array that contains start time of all activities
//  f[] -->  An array that contains finish time of all activities
    public static void printMaxActivities(int s[], int f[], int n)
   {
    int i, j;
 
    System.out.println("Following activities are selected \n");
 
    // The first activity always gets selected
    i = 0;
    System.out.println( i);
 
    // Consider rest of the activities
    for (j = 1; j < n; j++)
    {
      // If this activity has start time greater than or equal to the finish
      // time of previously selected activity, then select it
      if (s[j] >= f[i])
      {
          System.out.println( j);
          i = j;
      }
    }
}
/*

http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Greedy/actSelectionGreedy.htm

Theorem: Algorithm GREED-ACTIVITY-SELECTOR produces solution of maximum size for the activity-selection problem.

Proof Idea: Show the activity problem satisfied
I. Greedy choice property.
II. Optimal substructure property

Proof:
    I.  Let S = {1, 2, . . . , n} be the set of activities. 
Since activities are in order by finish time. 
It implies that activity 1 has the earliest finish time. 
Suppose, A is a subset of S is an optimal solution and let activities in A are ordered by finish time.
Suppose, the first activity in A is k.
If k = 1, then A begins with greedy choice and we are done (or to be very precise, there is nothing to proof here).
If k not=1, we want to show that there is another solution B that begins with greedy choice, activity 1.
Let B =  A - {k} U {1}. Because f1 =< fk, the activities in B are disjoint and since B has same number of
 activities as A, i.e., |A| = |B|, B is also optimal.

    II.  Once the greedy choice is made, the problem reduces to finding an optimal solution for the problem. 
If A is an optimal solution to the original problem S, then A` = A - {1} is an optimal solution 
to the activity-selection problem S` = {i in S: Si >= fi}.
why?
If we could find a solution B` to S` with more activities then A`, adding 1 to B` would
 yield a solution B to S with more activities than A, there by contradicting the optimality.

*/
 
// driver program to test above function
    public static void main(String args[]) {
	
	    int s[] =  {1, 3, 0, 5, 8, 5};
	    int f[] =  {2, 4, 6, 7, 9, 9};
	    int n = s.length;
	    printMaxActivities(s, f, n);

	}
}