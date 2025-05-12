package org.pk.practice.concurrency.scatterandgather;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class FetchDataTaskV1 implements Runnable {

    private final Set<ProductPrice> prices;
    private final String url;
    private final String provider;
    private final Integer productId;
    private CountDownLatch latch;

    public FetchDataTaskV1(String url, Integer productId, String provider, Set<ProductPrice> prices, CountDownLatch latch) {
        this.url = url;
        this.productId = productId;
        this.prices = prices;
        this.provider = provider;
        this.latch = latch;
    }

    @Override
    public void run() {
        LocalTime startTime = LocalTime.now();
        try {
            // do the API for the product id to fetch its price
            System.out.println("* Calling provider " + provider + " product id " + productId);
            // update the set with price and provider
            Random random = new Random();
            prices.add(new ProductPrice(provider, random.nextDouble()));
            Thread.sleep(random.nextInt(2000, 2500));
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        } finally {
            latch.countDown();
            LocalTime endTime = LocalTime.now();
            Duration duration = Duration.between(startTime, endTime);
            System.out.println("* " + provider + " Task completed Duration " + duration);
        }
    }
}
