/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topologicalsort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://courses.cs.washington.edu/courses/cse326/03wi/lectures/RaoLect20.pdf
 * Pseudocode: 
 * 1. Store each vertex’s InDegree (# of incoming edges) in an array
 * 2. While there are vertices remaining:
     -> Find a vertex with In-Degree zero and output it
     -> Reduce In-Degree of all vertices adjacent to it by 1
     -> Mark this vertex  
* 
*  Problems:
 * http://www.spoj.com/problems/SCAVHUNT
 * http://www.spoj.com/problems/TOPOSORT
 *
 * In below imple:
 * that a vertex is pushed to stack only 
 * when all of its adjacent vertices (and their adjacent vertices and so on) are already in stack.
 *
 * Correctness proof
 * http://cs.stackexchange.com/questions/10720/a-procedure-for-topological-sort-proof-for-its-correctness
 */
public class TopologicalSort {

    // list representation
    static class Graph {

        private int numV;   // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency List

        //Constructor
        Graph(int numvertices) {
            numV = numvertices;
            adj = new LinkedList[numvertices];
            for (int i = 0; i < numvertices; ++i) {
                adj[i] = new LinkedList();
            }
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
        }

    }
    
    

    // A recursive function used by topologicalSort
    static void topologicalSortUtil(Graph g, int v, boolean visited[],
                             Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = g.adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(g,i, visited, stack);
        }
 
        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }
    
     // recursive topologicalSortUtil()
    static void topologicalSort(Graph g)
    {
        Stack stack = new Stack();
 
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[g.numV];
        for (int i = 0; i < g.numV; i++)
            visited[i] = false;
 
        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < g.numV; i++)
            if (visited[i] == false)
                topologicalSortUtil(g,i, visited, stack);
 
        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }
 
    
    
    public static void main(String[] args) {

        // Create a graph given in the above diagram
        
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Graph created. Following is a Topological "
                + "sort of the given graph");

        topologicalSort(g);
    }

}
