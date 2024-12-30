package org.pk.hackerrank.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArraySum {

    public static void main(final String[] args) {
        TwoDArrayProblemSolution.main(args);
    }

}

class Solution {

    /**
     * [1 -2 4 -5 1]
     * 
     * 0, 0 = 1 = 1 0, 1 = 1, -2 = -1 0, 2 = 1, -2, 4 = 3 0, 3 = 1, -2, 4, -5 = -2
     * 0, 4 = 1, -2, 4, -5, 1 = -1 1, 1 = -2 = -2 1, 2 = -2, 4 = 2 1, 3 = -2, 4, -5
     * = -3 1, 4 = -2, 4, -5, 1 = -2 2, 2 = 4 = 4 2, 3 = 4, -5 = -1 2, 4 = 4, -5, 1
     * = 0 3, 3 = -5 = -5 3, 4 = -5, 1 = -4 4, 4 = 1 = 1
     * 
     * Negative arrays are = -1, -2, -1, -2, -3, -2, -1, -5, -4 total count of
     * negeative no = 9 Positive arrays are = 1, 3, 2, 4, 0, 1 total count of
     * positive no = 6 9 > 6 true return negative no count otherwise positve no
     * count
     * 
     * @param array
     * @return
     */
    public int arraySum(final int[] array) {
        if (array == null) {
            return 0;
        }
        int size = array.length;
        int negative = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                final int subArray[] = Arrays.copyOfRange(array, i, j + 1);
                final int sum = IntStream.of(subArray).sum();
                if (sum <= 0) {
                    negative++;
                }
            }
        }
        return negative;
    }

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int size = scanner.nextInt();
        final int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        final Solution solution = new Solution();
        final int sum = solution.arraySum(array);
        System.out.println(sum);
        scanner.close();
    }

}
