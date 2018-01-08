package com.test.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

//http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
import static java.lang.Thread.sleep;

public class Main {

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    void testit() {

        ReentrantLock lock = new ReentrantLock();
        int count = 0;


        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReentrantLock lock = new ReentrantLock();

        executor.submit(() -> {
            lock.lock();
            try {
                sleep(1);
            } finally {
                lock.unlock();
            }
        });

        executor.submit(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
        });

        stop(executor);


    }

    public static void main(String[] args) {
        // write your code here

        Main test = new Main();
        test.testit();


    }
}
