package org.pk.practice.concurrency.fieldvisibility;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterTask implements Runnable {

    private final AtomicInteger count = new AtomicInteger(0);
    //private volatile int no = 0;


    @Override
    public void run() {
        try {
            Thread.sleep(200);
            int no = count.incrementAndGet();
            //no++;
            System.out.println(Thread.currentThread().getName() + " increasing count: " + no);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


