package org.pk.hackerrank.formatter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class FormatterProblemSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        NumberFormat usNumberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat indiaNumberFormat = NumberFormat.getCurrencyInstance(new Locale(Locale.ENGLISH.getLanguage(), "in"));
        NumberFormat chinaNumberFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat franceNumberFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println("US: " + usNumberFormat.format(payment));
        System.out.println("India: Rs. " + indiaNumberFormat.format(payment));
        System.out.println("China: " + chinaNumberFormat.format(payment));
        System.out.println("France: " + franceNumberFormat.format(payment));
    }
}
