package org.pk.hackerrank.plusminus;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int positiveNumbersCount = 0;
        int negativeNumbersCount = 0;
        int zeroNumbersCount = 0;
        int arraySize = arr.size();
        for (int i = 0; i < arraySize; i++) {
            int element = arr.get(i);
            if (element == 0) {
                zeroNumbersCount++;
            } else if (element > 0) {
                positiveNumbersCount++;
            } else {
                negativeNumbersCount++;
            }
        }

        double positiveNumberRatio = (double) positiveNumbersCount / arraySize;
        System.out.printf("%.6f%n", positiveNumberRatio);

        double negativeNumberRatio = (double) negativeNumbersCount / arraySize;
        System.out.printf("%.6f%n", negativeNumberRatio);

        double zeroNumberRatio = (double) zeroNumbersCount / arraySize;
        System.out.printf("%.6f%n", zeroNumberRatio);
    }
}

public class PlusMinusProblemSolution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());

        //Result.plusMinus(arr);
        Result.plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));

        //bufferedReader.close();
    }
}
