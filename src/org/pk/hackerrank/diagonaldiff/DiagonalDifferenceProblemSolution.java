package org.pk.hackerrank.diagonaldiff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        if (arr.isEmpty()) {
            throw new RuntimeException("Two D Array should not be null or empty");
        }
        int leftToRightDiagonalSum = arr.get(0).get(0) + arr.get(arr.size() - 1).get(arr.size() - 1);
        int rightToLeftDiagonalSum = arr.get(0).get(arr.size() - 1) + arr.get(arr.size() - 1).get(0);
        int leftInc = 1;
        int rightInc = arr.size() - 2;

        for (int i = 1; i < arr.size() - 1; i++) {
            List<Integer> middleArray = arr.get(i);
            leftToRightDiagonalSum += middleArray.get(leftInc);
            rightToLeftDiagonalSum += middleArray.get(rightInc);
            leftInc++;
            rightInc--;
        }
        return Math.abs(leftToRightDiagonalSum - rightToLeftDiagonalSum);
    }
}

public class DiagonalDifferenceProblemSolution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
        List<List<Integer>> arr = new ArrayList<>();
//
//        IntStream.range(0, n).forEach(i -> {
//            try {
//                arr.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        int result = Result.diagonalDifference(arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
        arr.add(Arrays.asList(1, 2, 3, 5));
        arr.add(Arrays.asList(4, 5, 6, 7));
        arr.add(Arrays.asList(7, 8, 9, 8));
        arr.add(Arrays.asList(10, 11, 12, 11));

//        arr.add(Arrays.asList(1, 2, 3));
//        arr.add(Arrays.asList(4, 5, 6));
//        arr.add(Arrays.asList(9, 8, 9));

        int result = Result.diagonalDifference(arr);
        System.out.println(result);
    }
}


