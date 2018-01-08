package com.test.practice;


public class ExampleSingleton {

    private ExampleSingleton(){}

    private static class ExampleSingletonHelper{
        private static final ExampleSingleton INSTANCE = new ExampleSingleton();
    }

    public static ExampleSingleton getInstance(){
        return ExampleSingletonHelper.INSTANCE;
    }
}