package org.pk.hackerrank.interviewpreparationkit.warmup;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class JumpingOnCloudsSolution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int n = Integer.parseInt(bufferedReader.readLine().trim());
        //String line = bufferedReader.readLine();

        // Test case 1 OP:
        String line = "0 0 1 0 0 1 0";
        //Test case 2 OP: 3
        //String line = "0 1 0 0 0 1 0";
        List<Integer> c = Stream.of(line.replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).toList();

        int result = Result.jumpingOnClouds(c);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }

    class Result {
        /*
         * Complete the 'jumpingOnClouds' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY c as parameter.
         */
        public static int jumpingOnClouds1(List<Integer> c) {
            int jumps = -1;
            for (int i = 0; i < c.size(); i++) {
                int cloud = c.get(i);

                if (isSafeCloud(cloud)) {
                    jumps++;
                }
            }
            return jumps;
        }

        public static int jumpingOnClouds2(List<Integer> c) {
            int jumps = -1;
            for (int i = 0; i < c.size(); i++) {
                int cloud = c.get(i);
                if (isSafeCloud(cloud)) {
                    jumps++;
                }
                int stepPlus1Cloud = -1;
                int stepPlus2Cloud = -1;
                if (i + 1 < c.size() && i + 2 < c.size()) {
                    stepPlus1Cloud = c.get(i + 1);
                    stepPlus2Cloud = c.get(i + 2);
                }

                if (isSafeCloud(cloud) && isSafeCloud(stepPlus1Cloud) && isSafeCloud(stepPlus2Cloud)) {
                    jumps--;
                }
            }
            return jumps;
        }

        public static int jumpingOnClouds3(List<Integer> c) {
            int n = c.size();
            int jumps = 0;
            int i = 0;
            while (i < n - 1) {
                if (i + 2 < n && c.get(i + 2) == 0) {
                    i += 2;
                } else {
                    i += 1;
                }
                jumps++;
            }
            return jumps;
        }

        public static int jumpingOnClouds(List<Integer> c) {
            int jumps = 0;
            int size = c.size();
            for (int i = 0; i < size - 1; ) {
                if (i + 2 < size && isSafeCloud(c.get(i + 2))) {
                    i += 2;
                } else {
                    i += 1;
                }
                jumps++;
            }
            return jumps;
        }

        public static boolean isSafeCloud(int cloud) {
            return cloud == 0;
        }
    }
}
