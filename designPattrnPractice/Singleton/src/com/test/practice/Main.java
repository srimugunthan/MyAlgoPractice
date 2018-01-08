package com.test.practice;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ExampleSingleton x =  ExampleSingleton.getInstance();
        ExampleSingleton y = ExampleSingleton.getInstance();
        System.out.print("x  = "+x+"  y = "+y);
    }
}


