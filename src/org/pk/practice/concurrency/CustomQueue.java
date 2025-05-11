package org.pk.practice.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomQueue<E> {

    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private Queue<E> queue = new LinkedList<>();
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
            if (queue.size() == max) {
                notFull.await();
            }
            queue.add(item);
            notEmpty.signalAll();
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
                notEmpty.await();
            }

            E item = queue.remove();
            notFull.signalAll();
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
