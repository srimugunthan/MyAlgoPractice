package com.test.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

import static com.test.practice.ConcurrentUtils.stop;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        AtomicInteger atomicInt = new AtomicInteger(0);
//
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        IntStream.range(0, 1000)
//                .forEach(i -> executor.submit(atomicInt::incrementAndGet));
//
//        stop(executor);
//
//        System.out.println(atomicInt.get());    // => 1000

        //////////////////

//        AtomicInteger atomicInt = new AtomicInteger(0);
//
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        IntStream.range(0, 1000)
//                .forEach(i -> {
//                    Runnable task = () ->
//                            atomicInt.updateAndGet(n -> n + 2);
//                    executor.submit(task);
//                });
//
//        stop(executor);
//
//        System.out.println(atomicInt.get());    // => 2


        //////////

//        AtomicInteger atomicInt = new AtomicInteger(0);
//
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        IntStream.range(0, 1000)
//                .forEach(i -> {
//                    Runnable task = () ->
//                            atomicInt.accumulateAndGet(i, (n, m) -> n + m);
//                    executor.submit(task);
//                });
//
//        stop(executor);
//
//        System.out.println(atomicInt.get());    // => 499500


        /////////////

//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        IntStream.range(0, 1000)
//                .forEach(i -> executor.submit(adder::increment));
//
//        stop(executor);
//
//        System.out.println(adder.sumThenReset());   // => 1000


        ///////

        LongBinaryOperator op = (x, y) -> 2 * x + y;
        LongAccumulator accumulator = new LongAccumulator(op, 1L);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10)
                .forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

        stop(executor);

        System.out.println(accumulator.getThenReset());     // => 2539

        ////////
    }


}
