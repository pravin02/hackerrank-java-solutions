package org.pk.hackerrank.string;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternSyntaxChecker {

    // 10
    // [][]
    // [ ]
    // [ ]
    // [a]
    // sanjay
    // shafaet
    // sasas asasasa sasasas asasasas
    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>
    // <<<<<<<<<<<<<<<<<
    // $$$$$$$$$$$$$

    // Invalid
    // Valid
    // Valid
    // Valid
    // Valid
    // Valid
    // Valid
    // Valid
    // Valid
    // Valid

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        int testCases = Integer.parseInt(scan.nextLine());

        while (testCases-- > 0) {
            try {
                String pattern = scan.next();
                try {
                    if ("".equals(pattern)) {
                        throw new PatternSyntaxException("Empty string can't applicable as pattern", pattern, -1);
                    }
                    Pattern.compile(pattern);
                    System.out.println("Valid");
                } catch (PatternSyntaxException patternSyntaxException) {
                    System.out.println("Invalid");
                }
            } catch (Exception e) {
                System.out.println("Invalid "+e.getMessage());
            }
        }
        scan.close();
    }
}
