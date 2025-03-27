package org.pk.hackerrank.staircase;

import java.io.IOException;

class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    public static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(n - 1 - i));
            System.out.print("#".repeat(i + 1));
            System.out.println();
        }
    }
}

public class StaircaseProblemSolution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//        Result.staircase(n);
//        bufferedReader.close();

        Result.staircase(5);
    }
}
