package com.test.practice;

public class Main {

    public static void main(String[] args) {
//	// write your code here
//        Graph g1 = new Graph(5);
//        g1.addEdge(1, 0);
//        g1.addEdge(0, 2);
//        g1.addEdge(2, 0);
//        g1.addEdge(0, 3);
//        g1.addEdge(3, 4);
//
//        System.out.println(g1.checkCycle());

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.checkCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}
