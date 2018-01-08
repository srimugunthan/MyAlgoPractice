package com.test.practice;

import java.util.Scanner;

public class Main {


    private DispenseChain c1;

    public Main() {
        // initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }



    //https://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java
//Chain of Responsibility Pattern Examples in JDK
//    java.util.logging.Logger#log()
//    javax.servlet.Filter#doFilter()
//
    public static void main(String[] args) {
	// write your code here




        Main atmDispenser = new Main();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        }
    }
}
