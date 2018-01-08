package com.test.practice;

/* adjacency list representation */

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
//debugTODO: https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
public class Graph {

    private int numNodes;
    private LinkedList<Integer> adjList[];
    boolean visited[];
    Graph(int numnodes){

        this.numNodes = numnodes;
        this.adjList = new LinkedList[numnodes];
        this.visited = new boolean[numnodes];
        for(int i = 0; i < numnodes; i++){
            this.adjList[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w){
        this.adjList[v].add(w);
        this.adjList[w].add(v);
    }

    void setVisited(Integer node){

        visited[node] = true;
    }

    void initVisited(){
        for(int i = 0; i < numNodes;i++){
            visited[i] = false;
        }
    }
    boolean visited(int node){
        return visited[node];
    }

    boolean checkCycleUtil (LinkedList<Integer> adjNodes){

        Iterator<Integer> iter = adjNodes.listIterator(0);

        while(iter.hasNext()){
            Integer nextnode = iter.next();
            if(visited(nextnode) == true){
                return true;
            }else {
                setVisited(nextnode);

                if (checkCycleUtil(this.adjList[nextnode]) == true)
                    return true;
            }


        }
        return false;

    }
    boolean checkCycle(){


        for (int i = 0; i < numNodes; i++){
            initVisited();
            LinkedList <Integer>adjNodes = this.adjList[i];
            for(Integer node: adjNodes){

                if(visited(node) == true){
                    return true;
                }
                else {
                    setVisited(node);

                    if(checkCycleUtil(this.adjList[node])) {

                        return true;
                    }
                }
                initVisited();
            }

        }
        return  false;

    }
}


