package com.test.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
//http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
import static com.test.practice.ConcurrentUtils.stop;

public class Main {

    int count = 0;


    synchronized   void incrementSync() {
        count = count + 1;
    }

    void incrementSync2() {
        synchronized (this) {
            count = count + 1;
        }
    }

    public static void main(String[] args) {
	// write your code here




        Main test = new Main();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(test.incrementSync));

        stop(executor);

        System.out.println(test.count);  // 10000

    }
}
