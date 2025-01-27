package org.pk.hackerrank.string;

import java.util.Scanner;

public class Anagram {

    /**
     * 
     * @param str will operate on original format of string
     * @param c   directly check on given string
     * @return count of character in given string
     */
    public static int charCount(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 
     * @param str converts in lowercase
     * @param c   converts in lowercase to check
     * @return count of character in given string
     */
    public static int charStrictCount(String str, char c) {
        str = str.toLowerCase();
        c = Character.toLowerCase(c);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 
     * @param str1 input string 1
     * @param str2 input string 2
     * @return true if string found Anagram otherwise false
     */
    public static boolean isAnagram(String str1, String str2) {
        // Comparing for length of strings if not same then string will not contain same
        // frequency of characters
        if (str1.length() != str2.length()) {
            return false;
        }
        // looping to string 1 because both having same length
        for (int i = 0; i < str1.length(); i++) {
            // extracting character at index
            char ch = str1.charAt(i);
            // Strictly counting characters in both strings
            if (charStrictCount(str1, ch) == charStrictCount(str2, ch)) {
                // if lopping to last index means all character frequency matched means given
                // strings Anagrams
                if (i == str1.length() - 1) {
                    return true;
                } else {
                    // if not to last index process next character
                    continue;
                }
            } else {
                // if characters count not matched mean same character having different
                // frequency
                return false;
            }
        }
        // otherwise not anagrams
        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(isAnagram(scanner.next(), scanner.next()) ? "Anagrams" : "Not Anagrams");

        scanner.close();
    }
}