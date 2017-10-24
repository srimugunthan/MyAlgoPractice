package trieprob;

import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sdhandap
 */
public class TrieNode {

    public Character l = null;
    public ArrayList<TrieNode> children = null;
    static int nodeCount = 0;
    boolean fullWord;

    TrieNode() {
        nodeCount++;
        children = new ArrayList<TrieNode>();
        System.out.println("children size" + children.size());
        fullWord = false;
    }

    TrieNode(char ch) {
        l = ch;
        children = new ArrayList<TrieNode>();
    }

    public int getnumchild() {
        TrieNode node = this;
        return node.children.size();
    }

    void insert(String word) {
        char[] letters = word.toCharArray();

        TrieNode node = this;

        for (char ch : letters) {

            
                 
            
         

            int i;
            TrieNode x = node;
            for (i = 0; i < node.children.size(); i++) {

                x = node.children.get(i);
                if (x.l.equals(ch)) {
                    break;
                }

            }

            if (i < node.children.size()) {
                node = x;
            } else {

                TrieNode newnode = new TrieNode(ch);
                node.children.add(newnode);
                node = newnode;

            }

        }
        node.fullWord = true;
    }

    void print(TrieNode node, int offset) {
        System.out.println();
        for (int i = 0; i < offset; i++) {
            System.out.print(" ");
        }
        if (node.fullWord == true) {
            System.out.print("<" + node.l + ">");

        } else {
            System.out.print(node.l);
        }
        for (TrieNode x : node.children) {
            print(x, offset + 2);
        }

    }

    boolean search(String word) {
        return searchRec(this, word, 0);
    }

    void printTrie() {
        print(this, 2);
    }

    private boolean searchRec(TrieNode node, String word, int offs) {

        /* no mismatch */
        if (node.l == null && node.children.size() == 0) {
            return false;
        }

        if (offs >= word.length()) {
            System.out.println("Exception");
        }
        if(node.l == null){
            for (TrieNode x : node.children) {
                /* if any path gives a prefix match */
                if (searchRec(x, word, offs) == true) {
                    return true;
                }

            }
            return false;
        }
        else if (node.l == word.charAt(offs)) {

            
            offs = offs + 1;
            if (node.fullWord == true) {
                /* prefix match */
                return true;
            }

            /* reached end of word . no match */
            if (offs == word.length()) {
                return false;
            }
            for (TrieNode x : node.children) {
                /* if any path gives a prefix match */
                if (searchRec(x, word, offs) == true) {
                    return true;
                }

            }
            /* none of the path results in prefix match */
            return false;
        } else {
            return false;
        }

    }

}
