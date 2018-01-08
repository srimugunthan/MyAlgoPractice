package com.test.practice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
public class Main {



    public static void main(String[] args) throws InterruptedException {
	// write your code here
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);





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


        Callable<String> callable2(String result, long sleepSeconds) {
            return () -> {
                TimeUnit.SECONDS.sleep(sleepSeconds);
                return result;
            };
        }

        ExecutorService executor2 = Executors.newWorkStealingPool();

        List<Callable<String>> callables2 = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3));

        String result = executor2.invokeAny(callables2);
        System.out.println(result);

    }
}
