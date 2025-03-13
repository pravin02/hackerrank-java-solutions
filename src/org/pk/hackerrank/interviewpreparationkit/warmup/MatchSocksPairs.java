package org.pk.hackerrank.interviewpreparationkit.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /**
     * Complete the 'sockMerchant' function below.
     * <p>
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER_ARRAY ar
     * <p>
     * Example
     * <p>
     * <p>
     * There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
     * <p>
     * Function Description
     * <p>
     * Complete the sockMerchant function in the editor below.
     * <p>
     * sockMerchant has the following parameter(s):
     * <p>
     * int n: the number of socks in the pile
     * int ar[n]: the colors of each sock
     * Returns
     * <p>
     * int: the number of pairs
     *
     * @param n
     * @param ar
     * @return
     */
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        int maxPairs = 0;
        for (Integer socksColor : ar) {
            if (!map.containsKey(socksColor)) {
                map.put(socksColor, 1);
            } else {
                Integer count = map.get(socksColor);
                count += 1;
                map.put(socksColor, count);
                if (count % 2 == 0) {
                    maxPairs++;
                }
            }
        }

//        System.out.println(n);
//        System.out.println(ar);
//        System.out.println(map + ", maxPairs " + maxPairs);
        return maxPairs;
    }

}

public class MatchSocksPairs {

    public static void main(String[] args) throws IOException {

        // Test 1
//9
//10 20 20 10 10 30 50 10 20
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);
        System.out.println("OP: " + result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

