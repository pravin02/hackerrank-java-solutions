package org.pk.practice.concurrency.scatterandgather;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * This example depicts the scatter and gather example where we have a below requirement,
 * 1. All should process asynchronously.
 * 2. Once Task is done should add price in synchronous set.
 * 3. Whichever tasks are completed within threshold their value should be printed.
 * 4. If any task gets completed after threshold its response should get ignored.
 * 5. Example should be developed based on CompletableFuture
 */
public class ScatterAndGatherImplSolution2 {

    public static void main(String[] args) throws InterruptedException {
        LocalTime startTime = LocalTime.now();

        Set<ProductPrice> prices = Collections.synchronizedSet(new HashSet<>(0));

        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new FetchDataTaskV2("Url1", 1, "Amazon", prices));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new FetchDataTaskV2("Url2", 2, "Flipkart", prices));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new FetchDataTaskV2("Url3", 3, "Mintra", prices));
        try {
            CompletableFuture
                    .allOf(task1, task2, task3)
                    .get(2, TimeUnit.SECONDS);
        } catch (Exception e) {
        }
        synchronized (Object.class) {
            print(prices);
        }
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.println();
        System.out.println("Duration " + duration);
    }

    public static void print(Set<ProductPrice> prices) {
        System.out.println("*****Product prices");
        prices.forEach((productPrice) -> System.out.println("provider " + productPrice.provider() + ", value " + productPrice.price()));
        System.out.println("*****Product prices");
    }

}
