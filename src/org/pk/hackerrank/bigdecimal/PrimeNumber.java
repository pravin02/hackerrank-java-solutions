package org.pk.hackerrank.bigdecimal;

import java.util.Scanner;

public class PrimeNumber {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();
        System.out.println(scanner.nextBigInteger().isProbablePrime(100) ? "prime" : "not prime");
        scanner.close();
    }
}
