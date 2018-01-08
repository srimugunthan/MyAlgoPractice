package com.test.practice;

import java.lang.ref.WeakReference;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        WeakReference r = new WeakReference("I am here");
        String sr = new String("I am here");
        System.out.println("before gc: r="+ r.get() + "static = "+sr);
        System.gc();
        Thread.sleep(2000);
        System.out.println("after gc: r="+ r.get() + "static = "+sr);
    }
}

