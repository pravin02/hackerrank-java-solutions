package org.pk.practice.concurrency.fieldvisibility;

public class FieldVisibilityExample {

    public static void main(String[] args) {
        CounterTask task1 = new CounterTask();
        new Thread(task1).start();
        new Thread(task1).start();
        new Thread(task1).start();
        new Thread(task1).start();
        new Thread(task1).start();
    }
}
