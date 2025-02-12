package org.pk.hackerrank.interviewpreparationkit.warmup;

import java.io.IOException;

/**
 * The "Counting Valleys" problem is a classic exercise in understanding sequences of steps in a hiking scenario. The goal is to determine how many valleys a hiker has traversed based on a sequence of uphill (U) and downhill (D) steps.
 * <p>
 * Problem Description
 * A hiker starts at sea level and makes a series of steps. The steps are represented by a string where:
 * <p>
 * 'U' indicates an uphill step.
 * <p>
 * 'D' indicates a downhill step.
 * <p>
 * A valley is defined as a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Key Concepts
 * Sea Level: The starting point and reference level.
 * <p>
 * Valley: A sequence of steps where the hiker moves below sea level and then returns to sea level.
 * <p>
 * Mountain: A sequence of steps where the hiker moves above sea level and then returns to sea level.
 * <p>
 * Example
 * Consider the sequence of steps: "UDDDUDUU".
 * <p>
 * Step 1: 'U' (sea level to +1)
 * <p>
 * Step 2: 'D' (+1 to sea level)
 * <p>
 * Step 3: 'D' (sea level to -1)
 * <p>
 * Step 4: 'D' (-1 to -2)
 * <p>
 * Step 5: 'U' (-2 to -1)
 * <p>
 * Step 6: 'D' (-1 to -2)
 * <p>
 * Step 7: 'U' (-2 to -1)
 * <p>
 * Step 8: 'U' (-1 to sea level)
 * <p>
 * This sequence contains one valley: from step 2 to step 7.
 * <p>
 * Approach to Solve
 * Track the Current Level: Initialize a variable to keep track of the hiker's current level relative to sea level.
 * <p>
 * Count Valleys: Initialize a counter for valleys.
 * <p>
 * Iterate Through Steps: Loop through each step in the sequence.
 * <p>
 * Update the current level based on whether the step is 'U' or 'D'.
 * <p>
 * Detect the start of a valley when the hiker steps below sea level from sea level.
 * <p>
 * Detect the end of a valley when the hiker steps up to sea level from below sea level.
 */
public class CountingValleysSolution {

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int steps = Integer.parseInt(bufferedReader.readLine().trim());

        //String path = bufferedReader.readLine();

        // Test Case 1
        String[] lines = """
                8
                UDDDUDUU
                """.split("\n");
        int result = Result.countingValleys(Integer.parseInt(lines[0]), lines[1]);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();
    }

    class Result {

        /*
         * Complete the 'countingValleys' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER steps
         *  2. STRING path
         */
        public static int countingValleys(int steps, String path) {
            // Solution 1
            int countValleys = 0;
            int seaLevel = 0;
            int currentLevel = 0;
            for (int i = 0; i < steps; i++) {
                char step = path.charAt(i);
                if (step == 'U') {
                    currentLevel++;

                } else if (step == 'D') {
                    currentLevel--;
                }
                if (seaLevel == currentLevel && step == 'U')
                    countValleys++;
            }

            return countValleys;
        }

        // Solution 2
        public static int countingValleys2(int steps, String path) {
            // Solution 1
            int countValleys = 0;
            int seaLevel = 0;
            int stepUp = 0;
            int stepDown = 0;
            for (int i = 0; i < steps; i++) {
                if (path.charAt(i) == 'U') {
                    stepUp += 1;
                    if (seaLevel == (stepUp + stepDown))
                        countValleys++;

                } else if (path.charAt(i) == 'D') {
                    stepDown -= 1;
                }
            }

            return countValleys;
        }

    }
}
