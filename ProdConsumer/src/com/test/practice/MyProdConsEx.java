package com.test.practice;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

public class MyProdConsEx {

    public static class Producer<T> {

        ArrayBlockingQueue<T> putQ;

        public Producer(ArrayBlockingQueue<T> sharedQ) {

            putQ = sharedQ;
        }

        void produce(T item) {
            try {
                putQ.put(item);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


    static void startProducer(ArrayBlockingQueue qqq) {

        Producer<String> prod = new Producer<String>(qqq);


        Runnable lambda1 = () -> {
            for (int i = 0; i < 10; i++) {
                prod.produce("Hell" + i);
            }
        };


        Thread prodThread = new Thread(lambda1);

        prodThread.start();


    }


    public static class Consumer<T> {

        private ArrayBlockingQueue<T> getQ;

        public Consumer(ArrayBlockingQueue<T> sharedQ) {
            getQ = sharedQ;
        }

        T consume() {
            try {
                return getQ.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    static void startConsumer(ArrayBlockingQueue qqq) {

        Consumer<String> cons = new Consumer<String>(qqq);
        Runnable lambda2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(cons.consume());
            }
        };

        Thread consumerThread = new Thread(lambda2);
        consumerThread.start();

    }

    public static void main(String args[]) {
        ArrayBlockingQueue<String> qqq = new ArrayBlockingQueue<String>(10);
        startProducer(qqq);
        startConsumer(qqq);
        System.out.println("Hello world");
    }
}
