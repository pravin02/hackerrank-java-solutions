package org.pk.practice.concurrency.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class CustomQueueWaitAndNotifyAll<E> {
    private Queue<E> queue = new LinkedList<>(); // queue to hold records order by added
    private int max = 10;

    public CustomQueueWaitAndNotifyAll() {
    }

    public CustomQueueWaitAndNotifyAll(int size) {
        this.queue = new LinkedList<>();
        this.max = size;
    }

    public synchronized void put(E item) {
        try {
            while (queue.size() == max) {
                wait(); // queue is full it will wait for notification to move ahead
            }
            queue.add(item);
            notifyAll(); // now queue is not empty signalling to other threads where they were waiting
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized E take() {
        try {
            while (queue.isEmpty()) {
                wait(); // queue is empty it will wait here for notification to move ahead
            }

            E item = queue.remove();
            notifyAll(); // now queue is not full some item got consumed, signalling to other threads where they were waiting
            return item;
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }

    public int size() {
        return max;
    }
}
