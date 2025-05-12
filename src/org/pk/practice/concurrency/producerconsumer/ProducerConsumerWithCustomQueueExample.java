package org.pk.practice.concurrency.producerconsumer;

import java.util.stream.IntStream;

public class ProducerConsumerWithCustomQueueExample {

    private final CustomQueue<Integer> queue = new CustomQueue<>();

    final Runnable producer = () -> {
        IntStream.rangeClosed(1, 5).forEach(no -> {
            if (Thread.currentThread().getName().split("-")[1].equals("1")) {
                no = no * 2;
            }
            System.out.println(Thread.currentThread().getName() + " Producing no " + no);
            queue.put(no);
        });
    };

    final Runnable producer2 = () -> {
        IntStream.rangeClosed(1, 5).forEach(no -> {
            no = no * 2;
            System.out.println("producer2 " + Thread.currentThread().getName() + " Producing no " + no);
            queue.put(no);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    };

    final Runnable consumer = () -> {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " Consumed " + queue.take());
        }
    };

    final Runnable consumer2 = () -> {
        while (true) {
            System.out.println("Consumer2 " + Thread.currentThread().getName() + " Consumed " + queue.take());
        }
    };


    public static void main(String[] args) {
        new ProducerConsumerWithCustomQueueExample().start();
    }

    void start() {
        new Thread(producer).start();
        new Thread(producer2).start();

        new Thread(consumer).start();
        new Thread(consumer2).start();
    }

}
