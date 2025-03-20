package org.pk.hackerrank.loops;

import java.util.Scanner;

class PrintSeriesTestSolution {
    public static void main(String[] argh) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            printSeries(a, b, n);
        }
        in.close();
    }

    public static void printSeries(int a, int b, int n) {
        // Creating a index variable
        int index = 1;
        // Creating separate index for i >= n
        int newIndex = 1;
        while (n-- > 0) {
            // initializing multiplication value by 1 each time when threshold--
            int multiValue = 1;
            // incrementing new index by 1 when threshold--
            newIndex++;
            // setting output variable 0 each time to get fresh value
            int output = 0;
            // inner loop for to do calculation index > 0, 1 > 0, 2 > 0, 3 > 0
            while (index-- > 0) {
                // If multiplication value is 1 then adding a to it
                if (multiValue == 1) {
                    output = a + multiValue * b;
                    multiValue = multiValue + 1;
                } else { // other wise last calculated value multivalue * b
                    output += multiValue * b;
                    // Now moifiing multiplication value by 2 table
                    multiValue = multiValue * 2;
                }
            }
            // finally printing value to console
            System.out.print(output + " ");
            // modifing index by 1, 2, 3, 4, 5
            index = newIndex;
        }
        System.out.println();
    }
}

