package org.pk.practice.concurrency.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomQueue<E> {

    private final ReentrantLock lock = new ReentrantLock(true); // lock to ensure only one thread should get chance to execute block of code
    private final Condition notEmpty = lock.newCondition(); // condition to wait if queue is empty
    private final Condition notFull = lock.newCondition(); // condition to wait if queue is full
    private Queue<E> queue = new LinkedList<>(); // queue to hold records order by added
    private int max = 10;

    public CustomQueue() {
    }

    public CustomQueue(int size) {
        this.queue = new LinkedList<>();
        this.max = size;
    }

    public void put(E item) {
        lock.lock();
        try {
            while (queue.size() == max) {
                notFull.await(); // queue is full it will wait for notification to move ahead
            }
            queue.add(item);
            notEmpty.signalAll(); // now queue is not empty signalling to other threads where they were waiting
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await(); // queue is empty it will wait here for notification to move ahead
            }

            E item = queue.remove();
            notFull.signalAll(); // now queue is not full some item got consumed, signalling to other threads where they were waiting
            return item;
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return max;
    }
}
