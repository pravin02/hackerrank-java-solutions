package org.pk.hackerrank.string;

import java.util.Scanner;

public class Palindrome {

    public static boolean isPalindrome(String str) {

        // Approch 1 start
        // custome logic for reverse string without using standard function
        char strCharArray[] = str.toCharArray();
        char reverseCharArray[] = new char[str.length()];
        int revIndex = 0;
        for (int i = strCharArray.length - 1; i >= 0; i--) {
            reverseCharArray[revIndex++] = strCharArray[i];
        }
        String reverseString = new String(reverseCharArray);
        return reverseString.equals(str);

        // Approch 1 end

        // Approch 2 start
        /**
         * char reverseCharArray[] = new char[str.length()]; int revIndex = 0; for (int
         * i = str.length() - 1; i >= 0; i--) { reverseCharArray[revIndex++] =
         * str.charAt(i); } String reverseString = new String(reverseCharArray); return
         * reverseString.equals(str);
         */
        // Approch 2 end

        // Approch 3 start
        // return str.equals(new StringBuilder(str).reverse().toString());
        // Approch 3 end

        // Approch 4 start
        // return str.equals(new StringBuffer(str).reverse().toString());
        // Approch 3 end
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(isPalindrome(scanner.next()) ? "Yes" : "No");

        scanner.close();
    }
}