package org.pk.practice.concurrency.scatterandgather;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * This example depicts the scatter and gather example where we have a below requirement,
 * 1. All should process asynchronously.
 * 2. Once Task is done should add price in synchronous set.
 * 3. Whichever tasks are completed within threshold their value should be printed.
 * 4. If any task gets completed after threshold its response should get ignored.
 * 5. Example should be developed based on CountDownLatch or Phaser
 */

public class ScatterAndGatherImplSolution1 {

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);
    private static final CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        LocalTime startTime = LocalTime.now();
        Set<ProductPrice> prices = Collections.synchronizedSet(new HashSet<>());
        fetchPrices(prices);
        latch.await(3, TimeUnit.SECONDS);
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.println();
        System.out.println("Duration " + duration);
        System.out.println("*****Product prices");
        prices.forEach((productPrice) -> System.out.println("provider " + productPrice.provider() + ", value " + productPrice.price()));
        System.out.println("*****Product prices");
        executor.shutdown();
    }

    public static void fetchPrices(Set<ProductPrice> prices) {
        executor.submit(new FetchDataTaskV1("Url1", 1, "Amazon", prices, latch));
        executor.submit(new FetchDataTaskV1("Url2", 2, "Flipkart", prices, latch));
        executor.submit(new FetchDataTaskV1("Url3", 3, "Mintra", prices, latch));

    }
}
