package org.pk.practice.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class ProducerConsumerBlockingQueueExample {

    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

    final Runnable producer = () -> {
        IntStream.rangeClosed(1, 5).forEach(no -> {
            if (Thread.currentThread().getName().split("-")[1].equals("1")) {
                no = no * 2;
            }
            System.out.println(Thread.currentThread().getName() + " Producing no " + no);
            queue.add(no);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    };

    final Runnable producer2 = () -> {
        IntStream.rangeClosed(1, 5).forEach(no -> {
            no = no * 2;
            System.out.println("producer2 " + Thread.currentThread().getName() + " Producing no " + no);
            queue.add(no);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    };

    final Runnable consumer = () -> {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " Consumed " + queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };


    public static void main(String[] args) {
        new ProducerConsumerBlockingQueueExample().start();
    }

    void start() {
        new Thread(producer).start();
        new Thread(producer2).start();

        new Thread(consumer).start();
        new Thread(consumer).start();
    }

}
