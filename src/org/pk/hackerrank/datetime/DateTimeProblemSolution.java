package org.pk.hackerrank.datetime;

import java.io.IOException;
import java.time.LocalDate;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING. The function accepts following
     * parameters: 1. INTEGER month 2. INTEGER day 3. INTEGER year
     */
    public static String findDay(int month, int day, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.getDayOfWeek().toString();
    }

}

public class DateTimeProblemSolution {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        // String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$",
        // "").split(" ");

        // int month = Integer.parseInt(firstMultipleInput[0]);

        // int day = Integer.parseInt(firstMultipleInput[1]);

        // int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(8, 5, 2015);
        System.out.println(res);

        // bufferedWriter.write(res);
        // bufferedWriter.newLine();

        // bufferedReader.close();
        // bufferedWriter.close();
    }
}
