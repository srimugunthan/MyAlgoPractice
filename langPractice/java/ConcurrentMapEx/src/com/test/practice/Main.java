package com.test.practice;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

//http://winterbe.com/posts/2015/05/22/java8-concurrency-tutorial-atomic-concurrent-map-examples/


public class Main {

    public static void main(String[] args) {
	// write your code here


        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");

        map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));

        String value = map.putIfAbsent("c3", "p1");
        System.out.println(value);    // p0


         value = map.getOrDefault("hi", "there");
        System.out.println(value);    // there


        map.replaceAll((key, valuex) -> "r2".equals(key) ? "d3" : valuex);
        System.out.println(map.get("r2"));    // d3

        map.compute("foo", (key, valuex) -> valuex + valuex);
        System.out.println(map.get("foo"));   // barbar

        map.merge("foo", "boo", (oldVal, newVal) -> newVal + " was " + oldVal);
        System.out.println(map.get("foo"));   // boo was foo

//
//        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        map.put("foo", "bar");
//        map.put("han", "solo");
//        map.put("r2", "d2");
//        map.put("c3", "p0");
//
//
//        map.forEach(1, (key, value) ->
//                System.out.printf("key: %s; value: %s; thread: %s\n",
//                        key, value, Thread.currentThread().getName()));
//
//// key: r2; value: d2; thread: main
//// key: foo; value: bar; thread: ForkJoinPool.commonPool-worker-1
//// key: han; value: solo; thread: ForkJoinPool.commonPool-worker-2
//// key: c3; value: p0; thread: main
//
//
//        String result = map.search(1, (key, value) -> {
//            System.out.println(Thread.currentThread().getName());
//            if ("foo".equals(key)) {
//                return value;
//            }
//            return null;
//        });
//        System.out.println("Result: " + result);
//
//// ForkJoinPool.commonPool-worker-2
//// main
//// ForkJoinPool.commonPool-worker-3
//// Result: bar
//
//
//        String result = map.searchValues(1, value -> {
//            System.out.println(Thread.currentThread().getName());
//            if (value.length() > 3) {
//                return value;
//            }
//            return null;
//        });
//
//        System.out.println("Result: " + result);
//
//// ForkJoinPool.commonPool-worker-2
//// main
//// main
//// ForkJoinPool.commonPool-worker-1
//// Result: solo
//
//
//        String result = map.reduce(1,
//                (key, value) -> {
//                    System.out.println("Transform: " + Thread.currentThread().getName());
//                    return key + "=" + value;
//                },
//                (s1, s2) -> {
//                    System.out.println("Reduce: " + Thread.currentThread().getName());
//                    return s1 + ", " + s2;
//                });
//
//        System.out.println("Result: " + result);
//
//// Transform: ForkJoinPool.commonPool-worker-2
//// Transform: main
//// Transform: ForkJoinPool.commonPool-worker-3
//// Reduce: ForkJoinPool.commonPool-worker-3
//// Transform: main
//// Reduce: main
//// Reduce: main
//// Result: r2=d2, c3=p0, han=solo, foo=bar


    }
}
