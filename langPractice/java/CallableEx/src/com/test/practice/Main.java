package com.test.practice;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException{
	// write your code here
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done? " + future.isDone());

        Integer result = future.get();
        //future.get(1, TimeUnit.SECONDS);

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);


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
