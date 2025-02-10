package org.pk.hackerrank.loops;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * As an user we want to print count of characters in given string, Example,
 * PravinPPatil In above example P occured 3 times and r only once Output should
 * be like below, P - 3 r - 1 a - 2 v - 1 i - 2 n - 1 t - 1 l - 1
 * 
 * NOTE : Using any standard data structure or create own logic
 */
public class CountCharsTest {

    /**
     * Here we are choosing map because it doesnt allow duplicates and wanted to
     * hold both data key and value
     * 
     * @param str input
     * @return map<Character, Integer> character count map
     */
    public static Map<Character, Integer> countChars(String str) {
        // Step 1 - create empty map
        Map<Character, Integer> map = new HashMap<>();
        // Step 2 - loop through string
        for (Character ch : str.toCharArray()) {
            // Step 3 - check character exists in map or not
            if (map.containsKey(ch)) {
                // Step 4 - if exist fetch old count value increment
                // it and replace on same key with updated value
                int count = map.get(ch);
                count++;
                map.replace(ch, count);
            } else {
                // Step 5 - if key not exist add to map with count 1
                map.put(ch, 1);
            }
        }
        // Step 6 - return map;
        return map;
    }

    /**
     * 
     * @param str input
     * @return char[][] 2 d array of charcter first array will contain characters
     *         and second its value [P][3] [r][1] [a][2] [v][1]
     */
    public static char[][] countCharsLogic2(String str) {
        // Step 1 - create empty char array of size str length & 1 for second array
        char array[][] = new char[str.length()][2];
        // Step 2 - loop through string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean isExists = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j][0] == ch) {
                    array[j][1] += 1;
                    isExists = true;
                }
            }
            if (!isExists) {
                array[i][0] = ch;
                array[i][1] = 1;
            }
            // System.out.println(array[i][0] + " - " + array[i][1]);
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter string : ");
        String str = scanner.next();
        System.out.println(countChars(str));

        char array[][] = countCharsLogic2(str);
        for (int i = 0; i < array.length; i++) {
            char ch = array[i][0];
            for (int j = 1; j < array[i].length; j++) {
                if (ch != Character.MIN_VALUE) {
                    System.out.println(ch + " - " + ((int) array[i][j]));
                }
            }
        }
        scanner.close();
    }

}
