package org.pk.practice.concurrency.scatterandgather;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.Set;

public class FetchDataTaskV2 implements Runnable {
    private static final Random random = new Random();
    private final Set<ProductPrice> prices;
    private final String url;
    private final String provider;
    private final Integer productId;

    public FetchDataTaskV2(String url, Integer productId, String provider, Set<ProductPrice> prices) {
        this.url = url;
        this.productId = productId;
        this.prices = prices;
        this.provider = provider;
    }

    @Override
    public void run() {
        LocalTime startTime = LocalTime.now();
        try {
            // do the API for the product id to fetch its price
            System.out.println("* Calling provider " + provider + " product id " + productId);
            // update the set with price and provider
            Thread.sleep(random.nextInt(1981, 2000));
            prices.add(new ProductPrice(provider, random.nextDouble()));
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        } finally {
            LocalTime endTime = LocalTime.now();
            Duration duration = Duration.between(startTime, endTime);
            System.out.println("* " + provider + " Task completed Duration " + duration);
        }
    }
}
