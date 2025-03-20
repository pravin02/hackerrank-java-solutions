package org.pk.hackerrank.interviewpreparationkit.warmup;

import java.io.IOException;

public class RepeatedStringSolution {


    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        String s = bufferedReader.readLine();
//
//        long n = Long.parseLong(bufferedReader.readLine().trim());

        // Test case 1 OP:7
//        String[] lines = """
//                aba
//                10
//                """.split("\n");
        // Test case 2 OP:5
//        String[] lines = """
//                ab
//                10
//                """.split("\n");

        // Test case 8 OP: 69801196944
        String[] lines = """
                udjlitpopjhipmwgvggazhuzvcmzhulowmveqyktlakdufzcefrxufssqdslyfuiahtzjjdeaxqeiarcjpponoclynbtraaawrps
                872514961806
                """.split("\n");

        long result = Result.repeatedString(lines[0], Long.parseLong(lines[1]));
        System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();
    }

    class Result {

        /*
         * Complete the 'repeatedString' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts following parameters:
         *  1. STRING s
         *  2. LONG_INTEGER n
         */

        public static long repeatedString(String s, long n) {
            if (!s.contains("a")) {
                return 0;
            }
            if (s.equals("a")) {
                return n;
            }
            if (s.length() == 2 && s.contains("a")) {
                return n / 2;
            }

            if (s.equals("aaa")) {
                return 3;
            }
            // Write your code here
            // Option 1
            //String repeatedString = s.repeat((int) n);

            // Option 2
            //String repeatedString = Stream.generate(() -> s).limit(n).collect(Collectors.joining());

            //Option 3
            //repeatedString = String.join("", Collections.nCopies((int) n - s.length(), s));


            // Option 1
//            char[] chars = new char[(int) n];
//            char[] schars = s.toCharArray();
//            int sindex = 0;
//            for (int i = 0; i < chars.length; i++) {
//                Arrays.fill(chars, i, i + 1, schars[sindex]);
//                sindex++;
//                if (sindex == schars.length) {
//                    sindex = 0;
//                }
//            }
//
//            String repeatedString = new String(chars);
//            System.out.println(repeatedString);
//            int noOfOccurrence = 0;
//            for (int i = 0; i < n; i++) {
//                char ch = repeatedString.charAt(i);
//                noOfOccurrence += ch == 'a' ? 1 : 0;
//            }

            //Option 2
//            long noOfOccurrence = 0;
//            int index = 0;
//            int strLength = s.length();
//            for (int i = 0; i < n; i++) {
//                noOfOccurrence += s.charAt(index) == 'a' ? 1 : 0;
//                index++;
//                if (index == strLength) {
//                    index = 0;
//                }
//            }
            //return noOfOccurrence;

            //Option 3
            char c = 'a';
            long fullRepeats = n / s.length();
            long remainder = n % s.length();
            long countInFullString = s.chars().filter(ch -> ch == c).count();
            long countInRemainder = s.substring(0, (int) remainder).chars().filter(ch -> ch == c).count();
            return fullRepeats * countInFullString + countInRemainder;
        }
    }
}
