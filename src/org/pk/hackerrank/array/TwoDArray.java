package org.pk.hackerrank.array;

import java.util.Scanner;
import java.util.stream.Stream;

public class TwoDArray {

    public static void main(final String[] args) {
        TwoDArrayProblemSolution.main(args);
    }

}

class TwoDArrayProblemSolution {

    public static int patternSum(final int[][] array) {
        int maxSum = -70;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum = array[i][j] + array[i][j + 1] + array[i][j + 2] + array[i + 1][j + 1] + array[i + 2][j]
                        + array[i + 2][j + 1] + array[i + 2][j + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            int[] arrRowItems = Stream.of(scanner.nextLine().split(" ")).mapToInt(no -> Integer.parseInt(no)).toArray();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 6; j++) {
                arr[i][j] = arrRowItems[j];
            }
        }

        int sum = TwoDArrayProblemSolution.patternSum(arr);
        System.out.println(sum);
        scanner.close();
    }
}
