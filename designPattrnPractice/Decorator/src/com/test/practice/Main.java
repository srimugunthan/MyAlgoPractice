package com.test.practice;

/*

https://www.journaldev.com/1540/decorator-design-pattern-in-java-example

Decorator Design Pattern – Important Points
Decorator design pattern is helpful in providing runtime modification abilities and hence more flexible. Its easy to maintain and extend when the number of choices are more.
The disadvantage of decorator design pattern is that it uses a lot of similar kind of objects (decorators).
Decorator pattern is used a lot in Java IO classes, such as FileReader, BufferedReader etc.

 */
public class Main {

    public static void main(String[] args) {
	// write your code here

        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}


