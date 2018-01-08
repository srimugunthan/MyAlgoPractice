package com.test.practice;

import java.util.*;

//http://www.benchresources.net/how-to-sort-hashset-in-java-2-ways/

public class Main {

    public static void main(String[] args) {
	// write your code here

        // create HashSet of String type
        Set<String> coaches = new HashSet<String>();

        // add string values to HashSet
        coaches.add("Kirsten");
        coaches.add("Anil");
        coaches.add("John");
        coaches.add("Fletcher");
        coaches.add("Madan");
        coaches.add("Bishen");
        coaches.add("Chappell");

        // Before Sorting
        System.out.println("Before Sorting : HashSet contents in random order\n");
        for(String coach : coaches) {
            System.out.println(coach);
        }

        // create ArrayList and store HashSet contents
       // List<String> alCoaches = new ArrayList<String>(coaches);

        // sort using Collections class
       // Collections.sort(alCoaches);

        // sorting : create TreeSet and store HashSet contents
        Set<String> alCoaches = new TreeSet<String>(coaches);


        // After Sorting
        System.out.println("\n\nAfter Sorting : Sorted order\n");
        for(String coach : alCoaches) {
            System.out.println(coach);
        }
    }
}
