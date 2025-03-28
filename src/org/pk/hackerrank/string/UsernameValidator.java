package org.pk.hackerrank.string;

import java.util.Scanner;

public class UsernameValidator {

    // ^ # Start of the line
    // [a-z0-9_-] # Match characters and symbols in the list, a-z, 0-9, underscore,
    // hyphen
    // {8,30} # Length at least 8 characters and maximum length of 30
    // $ # End of the line
    public static final String regularExpression = "^[A-Za-z][A-Za-z0-9_]{7,29}$";

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }

        scan.close();
    }
}