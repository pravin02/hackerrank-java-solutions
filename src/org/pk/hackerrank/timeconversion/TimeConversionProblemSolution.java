package org.pk.hackerrank.timeconversion;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String s) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");

        return outputFormat.format(inputFormat.parse(s));
    }

}

public class TimeConversionProblemSolution {
    public static void main(String[] args) throws IOException, ParseException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();
//
//        String result = Result.timeConversion(s);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();

        System.out.println(Result.timeConversion("12:01:00AM"));
    }
}
