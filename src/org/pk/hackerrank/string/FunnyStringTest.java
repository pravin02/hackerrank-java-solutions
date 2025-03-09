package org.pk.hackerrank.string;

import java.util.Scanner;

public class FunnyStringTest {

    /**
     * A string is funny if it contains at least 3 wovels in uppercase, x y z in
     * lowercase and only even digits
     * 
     * @param str
     * @return true if string found funny otherwise false
     */
    public static boolean isFunnyString(String str) {
        char wowelsChar[] = new char[] { 'A', 'E', 'I', 'O', 'U', 'Y' };
        int totalWowels = 0;
        boolean isXPresent = false, isYPresent = false, isZPresent = false;
        // looping through is characters of string
        for (char ch : str.toCharArray()) {
            // checking for character lowercase
            // if (Character.isLowerCase(ch)) {
            if (ch >= 'a' && ch <= 'z') {
                // if x is not found yet check with condition if fount set to true and don't
                // check again for x
                if (!isXPresent) {
                    isXPresent = ch == 'x';
                }
                // if y is not found yet check with condition if fount set to true and don't
                // check again for y
                if (!isYPresent) {
                    isYPresent = ch == 'y';
                }
                // if z is not found yet check with condition if fount set to true and don't
                // check again for z
                if (!isZPresent) {
                    isZPresent = ch == 'z';
                }
            }
            // checking for character uppercase
            // } else if (Character.isUpperCase(ch) && totalWowels < 3) {
            else if ((ch >= 'A' && ch <= 'Z') && totalWowels < 3) {
                for (char wowel : wowelsChar) {
                    // suppose if we found char is A,E,I,O,U,Y so breaking
                    // the loop to avoid wastage of travelling
                    if (wowel == ch) {
                        totalWowels += 1;
                        break;
                    }
                }
            }
            // checking for character digit and if any odd found means string is not funny
            // } else if (Character.isDigit(ch) && !isEvenPresent) {
            else if ((ch >= '0' && ch <= '9')) {
                if (((int) ch) % 2 != 0) {
                    return false;
                }
            }
        }

        return (totalWowels >= 3 && (isXPresent && isYPresent && isZPresent));
    }

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int no = scanner.nextInt();
        while (no-- > 0) {
            String str = scanner.next();
            System.out.println(isFunnyString(str) ? "FUNNY" : "NOT FUNNY");
        }
        scanner.close();
    }
}
