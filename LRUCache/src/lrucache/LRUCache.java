/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrucache;

import java.util.HashMap;

/**
 *
 * http://www.spoj.com/problems/LRUCACHE/
 *
 * Ref: http://androidsrc.net/lru-cache-java-implementation/
 * http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 *
 */
public class LRUCache {

    // To represent Node of DoublyLinkedList
    class DoublyLinkedListNode {

        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;
        int key;
        int value;

        public DoublyLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // First node of DoublyLinkedList
    private DoublyLinkedListNode start;
    // Last node of DoublyLinkedList
    private DoublyLinkedListNode end;
    // Map for key and DoublyLinkedList node mapping
    private HashMap<Integer, DoublyLinkedListNode> nodeMap;

    // Capacity of LRUCache
    private int capacity;
    // Current size of LRUCache
    private int currentSize;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        currentSize = 0;
        nodeMap = new HashMap<Integer, DoublyLinkedListNode>();
    }

    /* To add node in front of queue */
    private void addToFront(DoublyLinkedListNode insertNode) {
        insertNode.next = start;
        insertNode.prev = null;
        if (start != null) {
            start.prev = insertNode;
        }
        start = insertNode;
        if (end == null) {
            end = insertNode;
        }
        nodeMap.put(insertNode.key, insertNode);
    }

    /* To reorder existing node to front of queue */
    private void bringToFront(DoublyLinkedListNode node) {
        // detach node from list
        DoublyLinkedListNode prevNode = node.prev;
        DoublyLinkedListNode nextNode = node.next;
        // handle next node
        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            start = nextNode;
        }
        // hanlde prev node
        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            end = prevNode;
        }
        // add to front of ist
        addToFront(node);
    }

    /* To get item value in LRUCache */
    private int get(int key) {
        if (nodeMap.containsKey(key)) {
            DoublyLinkedListNode node = nodeMap.get(key);
            bringToFront(node);
            return node.value;
        } else {
            return -1;
        }
    }


    /* To print all current items in LRUCache */
    private void printLRUCache() {
        DoublyLinkedListNode traverseNode = start;
        while (traverseNode != null) {
            System.out.print("key " + traverseNode.key + " value "
                    + traverseNode.value + " ");
            traverseNode = traverseNode.next;
        }
        System.out.println();
    }

    /* To remove last node from queue */
    private void removeLastNode() {
        DoublyLinkedListNode lastNode = nodeMap.remove(end.key);
        end = end.prev;
        if (end != null) {
            end.next = null;
        }
        lastNode = null; // make it eligible for GC
    }

    /* To add item in LRUCache */
    private void set(int key, int value) {
        if (nodeMap.containsKey(key)) {
            DoublyLinkedListNode node = nodeMap.get(key);
            node.value = value;
            bringToFront(node);
        } else {
            DoublyLinkedListNode insertNode = new DoublyLinkedListNode(key,
                    value);
            if (currentSize < capacity) {
                addToFront(insertNode);
                currentSize++;
            } else {
                removeLastNode();
                addToFront(insertNode);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(5);
        for (int i = 5; i < 11; i++) {
            lru.set(i, i * 2);
        }
        System.out.println("LRU Cache after creation");
        lru.printLRUCache();
        lru.get(7);
        System.out.println("LRU Cache after retrieving 7");
        lru.printLRUCache();
        lru.set(11, 11 * 2);
        System.out.println("LRU cache on adding one more item. It will replace last one");
        lru.printLRUCache();
    }

}
