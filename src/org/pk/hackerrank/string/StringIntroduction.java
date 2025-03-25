package org.pk.hackerrank.string;

import java.util.Scanner;

public class StringIntroduction {

    /**
     * 
     * @param first  first input string
     * @param second second input string
     * @return
     */
    public boolean isStringLexicographically(String first, String second) {
        return first.compareTo(second) > 0;
    }

    /**
     * 
     * @param s string for titlecase
     * @return will return title case String
     */
    public String toTitleCase(String s) {
        if (s == null) {
            return null;
        }
        String array[] = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String as : array) {
            String ss = Character.toUpperCase(as.charAt(0)) + as.substring(1);
            stringBuilder.append(ss);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        StringIntroduction si = new StringIntroduction();

        System.out.println(a.length() + b.length());
        System.out.println(si.isStringLexicographically(a, b) ? "Yes" : "No");
        System.out.println(si.toTitleCase(a) + " " + si.toTitleCase(b));

        scanner.close();

    }

}