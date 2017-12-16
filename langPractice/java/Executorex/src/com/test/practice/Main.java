package com.test.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
public class Main {

    public static void main(String[] args) {
	// write your code here

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });


        try {

            //shutdown() waits for currently running tasks to finish while shutdownNow() interrupts
            // all running tasks and shut the executor down immediately.

            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            //executor.awaitTermination(5, TimeUnit.SECONDS);
        }
//        catch (InterruptedException e) {
//            System.err.println("tasks interrupted");
//        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }


    }
}
