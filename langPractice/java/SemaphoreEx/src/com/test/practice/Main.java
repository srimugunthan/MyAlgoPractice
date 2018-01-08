package com.test.practice;

//http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/

        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;
        import java.util.concurrent.Semaphore;
        import java.util.concurrent.TimeUnit;
        import java.util.concurrent.locks.ReentrantLock;
        import java.util.stream.IntStream;

        import static com.test.practice.ConcurrentUtils.stop;
        import static java.lang.Thread.sleep;

public class Main {

    public void testit(){
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Semaphore semaphore = new Semaphore(5);

        Runnable longRunningTask = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit) {
                    System.out.println("Semaphore acquired");
                    sleep(5);
                } else {
                    System.out.println("Could not acquire semaphore");
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                if (permit) {
                    semaphore.release();
                }
            }
        };

        IntStream.range(0, 10)
                .forEach(i -> executor.submit(longRunningTask));

        stop(executor);
    }
    public static void main(String[] args) {
	// write your code here
        Main test = new Main();
        test.testit();
    }
}
