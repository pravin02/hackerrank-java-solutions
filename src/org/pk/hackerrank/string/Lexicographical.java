package org.pk.hackerrank.string;

import java.util.Scanner;

public class Lexicographical {

    public static String getSmallestAndLargest(String s, int k) {
        String currStr = s.substring(0, k);
        String lexMin = currStr;
        String lexMax = currStr;

        for (int i = 0; i <= s.length() - k; i++) {
            currStr = s.substring(i, i + k);
            if (lexMax.compareTo(currStr) < 0) {
                lexMax = currStr;
            }
            if (lexMin.compareTo(currStr) > 0) {
                lexMin = currStr;
            }
        }
        return lexMin + "\n" + lexMax;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}