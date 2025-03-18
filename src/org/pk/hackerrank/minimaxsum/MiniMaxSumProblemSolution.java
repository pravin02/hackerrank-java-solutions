package org.pk.hackerrank.minimaxsum;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void miniMaxSum(List<Integer> arr) {
        arr = arr.stream().sorted().toList();
        long minSum = 0;
        long maxSum = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            minSum += arr.get(i);
            maxSum += arr.get(i + 1);
        }
        System.out.println(minSum + " " + maxSum);
    }
}

public class MiniMaxSumProblemSolution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//        Result.miniMaxSum(arr);
//        bufferedReader.close();
        Result.miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));
    }
}
